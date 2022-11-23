INSERT INTO funcionario VALUES (1,'admin@chacombo.pe','98765432','administrador');
INSERT INTO funcionario VALUES (2,'cliente@cliente.pe','11111111','cliente');

INSERT INTO usuario VALUES (1,'pass123','admin',1);


INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (1, '1 kilo de chancho+Camote+cancha+ensalada criolla', '1 Kilo', 80, 'P', 'chicharron1k.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (2, '500gr de chancho+Camote+cancha+ensalada criolla', '1/2 Kilo', 45, 'P', 'chicharronmediok.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (3, '250gr de chancho+camote+cancha+ensalada criolla', '1/4 Kilo', 22, 'P', 'chicharroncuartok.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (4, 'Generosa porción de camote dulce', 'Camote', 6, 'A', 'camote.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (5, 'Cancha crocante de acompañamiento', 'Cancha', 3.5, 'A', 'cancha.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (6, 'Sarsa de cebolla con trozos de aji limo', 'Sarsa criolla', 3, 'A', 'sarsa.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (7, 'Taza de cafe pasado 300ml', 'Café pasado', 3, 'A', 'cafe.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (8, 'Infusión McColins 300ml', 'Té', 2.5, 'A', 'infusion.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (9, 'Infusión McColins 300ml', 'Anis', 2.5, 'A', 'infusion.jpg');
INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (10, 'Infusión McColins 300ml', 'Manzallina', 2.5, 'A', 'infusion.jpg');

INSERT INTO producto (id_producto, descripcion, nombre, precio, tipo, imagen) VALUES (11, 'Infusión McColins 300ml de Mate de coca', 'Mate', 3, 'A', 'infusion.jpg');


INSERT INTO pago VALUES (1, 'Efectivo');
INSERT INTO pago VALUES (2, 'Tarjeta');
INSERT INTO pago VALUES (3, 'Transferencia');
INSERT INTO pago VALUES (4, 'Plin o Yape');

INSERT INTO entrega VALUES (1, 'Delivery');
INSERT INTO entrega VALUES (2, 'Recojo en Tienda');