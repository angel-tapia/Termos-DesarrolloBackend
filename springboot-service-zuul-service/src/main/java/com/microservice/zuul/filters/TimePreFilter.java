package com.microservice.zuul.filters;

import java.util.Base64;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TimePreFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(TimePreFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		String uuid = UUID.randomUUID().toString();
		
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		// Agregamos el header propio
		ctx.addZuulResponseHeader("X-Request-ID", uuid);
		
		// Vamos a codificar un mensaje como prueba y decodificarlo en el post
		String value = "este es el mensaje secreto secretoso";
		
		// Base64 es el estandar para codificar
		String encodedValue = Base64.getEncoder().encodeToString(value.getBytes());
		
		// Lo añadimos como un header extra
		ctx.addZuulResponseHeader("secret-message", encodedValue);
		
		log.info("El mensaje enviado fue: " + value);
		
		
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
