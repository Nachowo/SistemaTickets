CREATE DATABASE SistemaTickets

CREATE TABLE IF NOT EXISTS Usuarios
(
    id_usuario SERIAL PRIMARY KEY,
    correo TEXT,
    nombre TEXT,
    contrasena TEXT,
    rol TEXT
) ;

CREATE TABLE IF NOT EXISTS Tickets
(
  id_ticket SERIAL PRIMARY KEY,
  solicitante BIGINT,
  analista BIGINT,
  categoria TEXT,
  prioridad INTEGER,
  estado TEXT,
  titulo TEXT,
  descripcion TEXT,
  correo TEXT,
  creacion DATE,
  FOREIGN KEY (solicitante) REFERENCES Usuarios(id_usuario),
  FOREIGN KEY (analista) REFERENCES Usuarios(id_usuario)
  
);

CREATE TABLE IF NOT EXISTS Observaciones
(
    id_observacion SERIAL PRIMARY KEY,
    tarea TEXT,
    fecha DATE,
    usuario BIGINT,
    ticket BIGINT,
    FOREIGN KEY (ticket) REFERENCES Tickets(id_ticket)
    FOREIGN KEY (usuario) REFERENCES Usuarios(id_usuario)
);

INSERT INTO usuarios(id_usuario,correo,nombre,contrasena,rol)
VALUES (0,null,null,null,'invitado');

INSERT INTO usuarios(id_usuario,correo,nombre,contrasena,rol)
VALUES (1,'user@usach.cl','user','123','registrado');

INSERT INTO usuarios(id_usuario,correo,nombre,contrasena,rol)
VALUES (2,'jefatura@usach.cl','jefatura','123','jefatura');

INSERT INTO usuarios(id_usuario,correo,nombre,contrasena,rol)
VALUES (3,'analista@usach.cl','analista','123','analista');

