INSERT INTO especies (nombre) VALUES 
('Perro'), 
('Gato'), 
('Ave');

INSERT INTO razas (especie_id, nombre) VALUES
(1, 'Labrador Retriever'),
(1, 'Bulldog Francés'),
(2, 'Siames'),
(2, 'Persa'),
(3, 'Canario');

INSERT INTO producto_tipos (nombre) VALUES 
('Medicamento'), 
('Vacuna'), 
('Insumo Médico'), 
('Alimento');

INSERT INTO evento_tipos (nombre) VALUES 
('Vacunación'), 
('Consulta'), 
('Cirugía'), 
('Desparasitación');

INSERT INTO cita_estados (nombre) VALUES 
('Programada'), 
('En Proceso'), 
('Finalizada'), 
('Cancelada');

INSERT INTO duenos (nombre_completo, documento_identidad, direccion, telefono, email) VALUES
('Carlos Ramírez', '123456789', 'Calle 10 #45-23', '3001234567', 'carlos.ramirez@example.com'),
('María López', '987654321', 'Carrera 8 #12-34', '3019876543', 'maria.lopez@example.com');

INSERT INTO mascotas (dueno_id, nombre, raza_id, fecha_nacimiento, sexo, url_foto) VALUES
(1, 'Firulais', 1, '2020-05-10', 'Macho', 'https://example.com/firulais.jpg'),
(2, 'Mishita', 3, '2019-08-15', 'Hembra', 'https://example.com/mishita.jpg');

INSERT INTO historial_medico (mascota_id, fecha_evento, evento_tipo_id, descripcion, diagnostico, tratamiento_recomendado) VALUES
(1, '2023-07-01', 2, 'Consulta general', 'Alergia leve en la piel', 'Antihistamínicos por 7 días'),
(2, '2023-09-20', 1, 'Vacunación anual', 'Saludable', 'Revisar refuerzo en un año');

INSERT INTO inventario (nombre_producto, producto_tipo_id, descripcion, fabricante, lote, cantidad_stock, stock_minimo, fecha_vencimiento, precio_venta) VALUES
('Vacuna Rabia', 2, 'Vacuna contra la rabia', 'PfizerVet', 'L001', 50, 5, '2026-01-01', 45000.00),
('Amoxicilina 500mg', 1, 'Antibiótico de amplio espectro', 'VetPharma', 'L002', 100, 10, '2025-12-01', 2500.00),
('Gasa estéril 10x10', 3, 'Paquete de gasas estériles', 'MediCare', 'L003', 200, 20, '2027-01-01', 500.00);

INSERT INTO citas (mascota_id, fecha_hora, motivo, estado_id) VALUES
(1, '2025-09-25 10:00:00', 'Revisión de piel', 1),
(2, '2025-09-26 15:30:00', 'Control post vacunación', 1);

INSERT INTO facturas (dueno_id, fecha_emision, total) VALUES
(1, '2025-09-20 11:00:00', 47500.00),
(2, '2025-09-21 14:00:00', 2500.00);

INSERT INTO items_factura (factura_id, producto_id, servicio_descripcion, cantidad, precio_unitario, subtotal) VALUES
(1, 1, NULL, 1, 45000.00, 45000.00), 
(1, NULL, 'Consulta general', 1, 2500.00, 2500.00),
(2, 2, NULL, 1, 2500.00, 2500.00);

INSERT INTO veterinarios (nombre_completo, documento_identidad, especialidad, telefono, email)
VALUES
('Laura Martínez Gómez', '1001234567', 'Medicina general', '3104567890', 'laura.martinez@happyfeet.com'),
('Carlos Andrés Rojas', '1009876543', 'Cirugía', '3157896541', 'carlos.rojas@happyfeet.com'),
('Mariana López Torres', '1012345678', 'Dermatología', '3126549870', 'mariana.lopez@happyfeet.com'),
('Andrés Felipe Gutiérrez', '1018765432', 'Cardiología', '3201234567', 'andres.gutierrez@happyfeet.com'),
('Valentina Ramírez Castro', '1023456789', 'Oftalmología', '3187654321', 'valentina.ramirez@happyfeet.com');

-- Insertar usuarios en la tabla usuarios
INSERT INTO usuarios (nombre_usuario, contrasena, rol) VALUES
('admin_happyfeet', 'admin123', 'ADMIN'),
('vet_carlos', 'vetcarlos123', 'VETERINARIO'),
('vet_andrea', 'vetandrea123', 'VETERINARIO'),
('vet_julian', 'vetjulian123', 'VETERINARIO'),
('aux_maria', 'auxmaria123', 'AUXILIAR');

-- Inserciones para la tabla proveedores
INSERT INTO proveedores (nombre, telefono, email, direccion) VALUES
('Distribuidora VetLife', '3104567890', 'contacto@vetlife.com', 'Cra 10 # 25-30, Bucaramanga'),
('Agroinsumos del Oriente', '3176543210', 'ventas@agroinsumos.co', 'Km 5 vía Girón, Santander'),
('Laboratorios AnimalCare', '3019876543', 'info@animalcare.com', 'Av. Libertad #45-20, Bogotá'),
('Farmapet S.A.S', '3152345678', 'pedidos@farmapet.com', 'Calle 34 #12-18, Medellín'),
('Nutrición y Salud Animal', '3027654321', 'soporte@nutrisalud.com', 'Carrera 15 # 45-67, Cali'),
('Distribuciones Mascotas Plus', '3194561230', 'mascotasplus@gmail.com', 'Calle 5 # 20-55, Barranquilla'),
('BioVet Solutions', '3112349876', 'contacto@biovet.com', 'Carrera 50 # 80-15, Bogotá'),
('Zootecnia del Valle', '3148765432', 'ventas@zootecnia.co', 'Av. Roosevelt #90-45, Cali'),
('PetHouse Proveedores', '3001234567', 'proveedores@pethouse.com', 'Calle 9 # 14-25, Bucaramanga'),
('VetDistribuciones Global', '3126547890', 'global@vetdistribuciones.com', 'Carrera 100 # 50-40, Bogotá');

-- Actividades de adopción
INSERT INTO actividades_especiales (tipo, descripcion, fecha) VALUES
('ADOPCION', 'Jornada de adopción de perros rescatados en alianza con la Fundación Patitas Felices.', '2025-10-05'),
('ADOPCION', 'Feria de adopción de gatos adultos y cachorros.', '2025-11-12');

-- Actividades de vacunación
INSERT INTO actividades_especiales (tipo, descripcion, fecha) VALUES
('VACUNACION', 'Campaña de vacunación antirrábica gratuita para perros y gatos.', '2025-09-30'),
('VACUNACION', 'Vacunación contra moquillo y parvovirus con descuentos especiales.', '2025-10-15');

-- Actividades del club de frecuentes
INSERT INTO actividades_especiales (tipo, descripcion, fecha) VALUES
('CLUB_FRECUENTES', 'Charla sobre cuidados de mascotas exóticas para miembros del club.', '2025-10-20'),
('CLUB_FRECUENTES', 'Entrega de kit de bienvenida y descuentos para nuevos afiliados.', '2025-11-01');

INSERT INTO adopciones (mascota_id, nuevo_dueno_id, fecha, contrato)
VALUES
(1, 1, '2025-01-15', 'Contrato firmado: Se garantiza buen trato y cuidados médicos anuales.'),
(2, 2, '2025-02-02', 'Adopción condicionada: seguimiento trimestral durante el primer año.'),
(1, 2, '2025-03-10', 'Contrato simple: la mascota será esterilizada y vacunada en la clínica.'),
(2, 2, '2025-04-05', 'Se firma acuerdo de responsabilidad civil en caso de abandono.'),
(2, 1, '2025-06-20', 'NULL'); -- Caso donde no se anexó contrato formal

INSERT INTO puntos_clientes (dueno_id, puntos) VALUES
(1, 120),   -- Cliente 1 con 120 puntos
(2, 450);   -- Cliente 2 más constante