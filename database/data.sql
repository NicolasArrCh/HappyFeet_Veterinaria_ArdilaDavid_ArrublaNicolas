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