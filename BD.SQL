CREATE DATABASE SistemaTickets

CREATE TABLE IF NOT EXISTS Usuarios
(
    id_usuario SERIAL PRIMARY KEY,
    correo TEXT,
    nombre TEXT,
    contrasena TEXT,
    rol TEXT
) ;

CREATE TABLE IF NOT EXISTS SistemaTickets
(
  id_ticket SERIAL PRIMARY KEY,
  solicitante BIGINT,
  analista BIGINT,
  categoria TEXT,
  prioridad INTEGER,
  estado TEXT,
  titulo TEXT,
  descripcion TEXT,
  FOREIGN KEY (solicitante) REFERENCES Usuario(id_usuario),
  FOREIGN KEY (analista) REFERENCES Usuario(id_usuario)
  
);

CREATE TABLE IF NOT EXISTS Observaciones
(
    id_observacion SERIAL PRIMARY KEY,
    tarea TEXT,
    clasificacion TEXT,
    fecha DATE,
    usuario BIGINT,
    FOREIGN KEY (usuario) REFERENCES Usuario(id_usuario)
);