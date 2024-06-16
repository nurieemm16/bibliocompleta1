CREATE DATABASE bibliotecanuriacompleta;
USE bibliotecanuriacompleta;

CREATE TABLE usuario (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(250) NOT NULL,
    telefono int UNIQUE NOT NULL, 
    correo VARCHAR(250),
    fecha_alta DATE NOT NULL,
    fecha_baja DATE
   );
   
CREATE TABLE autor (
	id_autor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_autor VARCHAR(250) NOT NULL,
    telefono int UNIQUE NOT NULL, 
    correo VARCHAR(250),
    fecha_alta DATE NOT NULL
);

CREATE TABLE libro (
	id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(250) NOT NULL,
    autor VARCHAR(250) NOT NULL,
    fecha_publicacion DATE NOT NULL, 
    disponibilidad BOOLEAN NOT NULL DEFAULT TRUE,
    genero VARCHAR(255) NOT NULL
);


CREATE TABLE actividad (
	id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    actividad VARCHAR(250) NOT NULL,
    fecha_actividad VARCHAR(250) NOT NULL
);


CREATE TABLE usuario_librosprestados ( -- USUARIO HAS LIBROS PRESTADOS
	id_usuario INT,
    nombre_usuario VARCHAR(250),
    id_libro INT,
    titulo VARCHAR(250),
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    telefono INT,
    PRIMARY KEY (id_usuario, id_libro),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);

CREATE TABLE autor_libro ( -- AUTOR HAS LIBROS
	id_autor INT,
    nombre_autor VARCHAR(250),
    id_libro INT,
    titulo VARCHAR(250),
    fecha_devolucion DATE,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);


-- INSERTS--

   INSERT INTO usuario (nombre_usuario, telefono, correo, fecha_alta, fecha_baja)
VALUES
('Maya Moliner', 999888777, 'maya@moliner.com', '2024-06-05', '2024-06-01'),
('Bego Caballero', 666555321, 'bego@caballero.com', '2022-07-05', null);

 INSERT INTO autor (nombre_autor, telefono, correo, fecha_alta)
VALUES
('Brandon Sanderson', 978645321, 'brandon@sanderson.com', '2005-04-01');

INSERT INTO libro (titulo, autor, fecha_publicacion, disponibilidad)
VALUES
('El aliento de los Dioses', 'Brandon Sanderson','2014-07-25' ,TRUE),
('Elantris', 'Brandon Sanderson', '2007-05-21',TRUE);

 INSERT INTO actividad (actividad, fecha_actividad)
VALUES
('Exposició i cicle de conferències “Bicentenari de Clavé, Pi i Margall, i Balaguer a l’Arús (1824-2024). Catalanitat, republicanisme federal i liberalisme a Barcelona', '18 de junio de 2024');
COMMIT;

-- CONSULTAR TABLAS --
	-- Consultar los elementos de cada tabla --
		SELECT * FROM usuario;
		SELECT * FROM autor;
		SELECT * FROM libro;
        SELECT * FROM actividad;
 -- Lista libros prestados por usuarios --
        SELECT * FROM usuario_librosprestados;


-- Lista de libros de todos los autores
		SELECT a.id_autor, l.autor, l.id_libro, l.titulo
        FROM libro l
        INNER JOIN autor a ON l.autor = a.nombre_autor
        ORDER BY a.id_autor ASC;
        
--  Lista de libros por Santiago Posteguillo --
		SELECT a.id_autor, a.nombre_autor AS autor, l.id_libro, l.titulo
        FROM autor a
        INNER JOIN libro l ON a.nombre_autor = l.autor
        WHERE a.nombre_autor LIKE 'Santiago Posteguillo';
        
        SELECT l.id_libro, l.titulo, l.disponibilidad FROM libro l
        INNER JOIN autor a ON l.autor = a.nombre_autor
        WHERE a.nombre_autor LIKE 'Santiago Posteguillo';
		
-- Lista de libros por Brandon Sanderson--
        SELECT a.id_autor, a.nombre_autor AS autor, l.id_libro, l.titulo
        FROM autor a
        INNER JOIN libro l ON a.nombre_autor = l.autor
        WHERE a.nombre_autor LIKE 'Brandon Sanderson';
        
        SELECT l.id_libro, l.titulo, l.disponibilidad FROM libro l
        INNER JOIN autor a ON l.autor = a.nombre_autor
        WHERE a.nombre_autor LIKE 'Brandon Sanderson';
        
	-- Tabla libros prestados por usuario si existen el libro y el usuario en cuestión

        INSERT INTO usuario_librosprestados (id_usuario, nombre_usuario, id_libro, titulo)
	    SELECT u.id_usuario, u.nombre_usuario, l.id_libro, l.titulo
        FROM usuario u , libro l
        WHERE u.nombre_usuario= "Núria Marzo" and l.titulo = "Roma soy yo" and EXISTS(
        SELECT 1
        FROM usuario u , libro l
        WHERE u.nombre_usuario = "Núria Marzo"  and l.titulo = "Roma soy yo");
        
        -- Tabla libros prestados por usuario 
        
        INSERT INTO usuario_libroslrestados (id_usuario, nombre_usuario, id_libro, titulo) 
        SELECT u.id_usuario, u.nombre_usuario, l.id_libro, l.titulo 
        FROM usuario u, libro l 
        WHERE u.nombre_usuario = "Núria Marzo" and l.titulo = "Yo, Julia";
	
    
   -- Tabla LIBROS PRESTADOS
SELECT l.titulo, l.disponibilidad
FROM libro l
INNER JOIN usuario_librosprestados ulp ON l.titulo = ulp.titulo
WHERE ulp.titulo IS NOT NULL;
	
COMMIT;

   