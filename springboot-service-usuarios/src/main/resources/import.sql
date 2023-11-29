INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', 'abcde', true, 'Admin', 'Admin', 'admin@localhost');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('angel', 'abcde', true, 'Angel', 'Tapia', 'angel@tapia.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER')
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN')

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(1, 1)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 2)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES(2, 1)