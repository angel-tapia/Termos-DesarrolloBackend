package com.microservice.zuul.filters;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class TimePostFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(TimePostFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Entrando a filtro post");
		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

		log.info(String.format("Tiempo transcurrido en segundos %s seg", tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("Teimpo transcurrido en milisegundos es %s ms", tiempoTranscurrido.toString()));
			
		// Conseguimos el mensaje secreto de los headers "secret-message"
		String encodedMessage = ctx.getZuulResponseHeaders().stream()
				.filter(header -> header.first().equals("secret-message"))
				.findFirst()
				.map(Pair::second)
				.orElse(null);
				
		// Lo decodeamos
		String decodedMessage = new String(Base64.getDecoder().decode(encodedMessage));
				
		// Lo logeamos el mensaje encodeado y decodeado a partir del header
		log.info("Encoded secret message: " + encodedMessage);
		log.info("Decoded secret message: " + decodedMessage);
		
		log.info("Before deleting headers: ");
		
		ctx.getZuulResponseHeaders().forEach(header -> {
			log.info(header.first() + ": " + header.second());
		});

		// Remove headers from the response
		ctx.getZuulResponseHeaders().removeIf(header -> header.first().equals("secret-message"));
		ctx.getZuulResponseHeaders().removeIf(header -> header.first().equals("Date"));
		ctx.getZuulResponseHeaders().removeIf(header -> header.first().equals("Keep-Alive"));
		
		
		log.info("After deleting headers: ");
		
		ctx.getZuulResponseHeaders().forEach(header -> {
			log.info(header.first() + ": " + header.second());
		});	
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
