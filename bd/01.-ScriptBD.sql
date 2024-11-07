

-- borra la bd si existe
DROP DATABASE IF EXISTS bd_ventas_cursos;
-- creamos la bd
CREATE DATABASE bd_ventas_cursos;
-- activamos la bd
USE bd_ventas_cursos;


CREATE TABLE tb_cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    nivel   INT,
    modalidad  INT,
    creditos INT,
    precio  decimal(18,2)
);

INSERT INTO tb_cursos (nombre, nivel, modalidad, creditos, precio)VALUES 
 ('Java con JSP y MySQL', 2, 1, 4, 299.99),
 ('SpringBoot y Microservicios', 2, 1, 4, 500.99),
 ('Angular con SpringBoot', 3, 3, 5, 750.86),
 ('Base de datos Mysql', 1, 2, 5, 280.50),
 ('Base de datos Sql Server', 1, 2, 5, 350.50),
 ('Base de datos Oracle', 1, 2, 5, 480.70);
 
 
select * from tb_cursos;



CREATE TABLE tb_profesion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    des_profesion VARCHAR(255) NOT NULL
);

INSERT INTO tb_profesion (des_profesion) VALUES
('Ingeniero(a) de Sistemas'),
('Ingeniero(a) de Datos'),
('Ingeniero(a) de Software'),
('Diseñador(a) Gráfico(a)'),
('Licenciado(a) en Marketing');

select * from  tb_profesion;

CREATE TABLE tb_docente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    apePaterno VARCHAR(100) NOT NULL,
    apeMaterno VARCHAR(100) NOT NULL,
	email  VARCHAR(100) NOT NULL,
    celular  numeric NOT NULL ,
	id_profesion INT,
    CONSTRAINT fk_id_profesion FOREIGN KEY (id_profesion) REFERENCES tb_profesion(id)
);


INSERT INTO tb_docente (nombre, apePaterno, apeMaterno, email, celular, id_profesion) VALUES
('Juan', 'Perez', 'Gomez', 'juanperez@gmail.com', 987456321, 1),
('Mirko', 'Soto', 'Paredes', 'mirkoparedes@gmail.com', 931411254, 2),
('Liliana', 'Mino', 'Vargas', 'lilianamino@gmail.com', 941462811, 3),
('Ximena', 'Suarez', 'Mendez', 'ximenasuarez@gmail.com', 933335478, 3),
('Ronad', 'Trujillo', 'Zavala', 'ronaldtrujillo@gmail.com', 959584468, 3),
('Pedro', 'López', 'Martínez', 'pedrolopez@gmail.com', 978598978, 4),
('María', 'González', 'López', 'mariagonzale@gmail.com', 999666587, 5);

