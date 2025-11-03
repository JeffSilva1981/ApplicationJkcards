INSERT INTO tb_user(first_name, last_name, email, password) VALUES ('Vitor', 'Luan', 'vitorluan@gmail.com', '$2a$10$4GCdS85pkpDRVbga.FAWSuary8O3lcATobPoQ0nh56m85N8sTCJpy');
INSERT INTO tb_user(first_name, last_name, email, password) VALUES ('Jeferson', 'Ferreira da silva', 'jfds.ferreirasilva@gmail.com', '$2a$10$4GCdS85pkpDRVbga.FAWSuary8O3lcATobPoQ0nh56m85N8sTCJpy');

INSERT INTO tb_roles (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_roles (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO tb_user_roles (user_id, roles_id) VALUES (2, 1);
INSERT INTO tb_user_roles (user_id, roles_id) VALUES (2, 2);