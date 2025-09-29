# 👥 Autores

David Ardila
Nicolás Arrubla

# 🐾 HappyFeet Veterinaria

HappyFeet es un sistema de gestión para una clínica veterinaria.  
Permite administrar **mascotas, especies, razas, citas y estados de las citas**, facilitando el control de la información y la atención de los pacientes.

---

## 📌 Funcionalidades principales

- Gestión de **Especies** (crear, listar, buscar, actualizar y eliminar).
- Gestión de **Razas** asociadas a especies.
- Gestión de **Mascotas** (registro, listado, búsqueda).
- Gestión de **Citas** veterinarias.
- Control de **Estados de citas** (Pendiente, Confirmada, Cancelada, Completada).
- Conexión a base de datos con **Singleton** (`ConexionBD`).

---

## 🛠️ Tecnologías utilizadas

- **Java 17+**
- **JDBC** para acceso a datos
- **MySQL** (u otro motor relacional)
- **Maven** como gestor de dependencias
- **IntelliJ IDEA** (IDE recomendado)

---

## 📂 Estructura del proyecto
src/
└── com.happyfeet/
├── model/
│ └── entities/ # Entidades (Especie, Raza, Mascota, Cita, CitaEstado...)
├── repository/
│ ├── DAO/ # Implementación de DAOs con JDBC
│ └── inter/ # Interfaces DAO
├── service/ # (Opcional) Servicios de negocio
├── controller/ # Controladores que interactúan con la vista/menús
└── util/ # Utilidades como ConexionBD (Singleton)


---

## 🗄️ Base de datos

Ejemplo de tablas principales:

```sql
CREATE TABLE especies (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE razas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  especie_id INT NOT NULL,
  FOREIGN KEY (especie_id) REFERENCES especies(id)
);

CREATE TABLE mascotas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  raza_id INT NOT NULL,
  FOREIGN KEY (raza_id) REFERENCES razas(id)
);

CREATE TABLE cita_estados (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE citas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mascota_id INT NOT NULL,
  fecha_hora DATETIME NOT NULL,
  motivo VARCHAR(255),
  estado_id INT NOT NULL,
  FOREIGN KEY (mascota_id) REFERENCES mascotas(id),
  FOREIGN KEY (estado_id) REFERENCES cita_estados(id)
); ```


#️ Instalación y configuración

Clonar el repositorio:
git clone https://github.com/NicolasArrCh/HappyFeet_Veterinaria_ArdilaDavid_ArrublaNicolas.git
cd HappyFeet_Veterinaria_ArdilaDavid_ArrublaNicolas

Crear la base de datos en MySQL:
CREATE DATABASE happyfeet;
USE happyfeet;
-- Ejecutar los scripts de creación de tablas

Configurar la conexión en ConexionBD.java:
private static final String URL = "jdbc:mysql://localhost:3306/happyfeet";
private static final String USER = "tu_usuario";
private static final String PASSWORD = "tu_contraseña";

Compilar y ejecutar:
mvn clean install
mvn exec:java -Dexec.mainClass="com.happyfeet.Main"


▶️ Ejecución del sistema

El sistema se maneja por menús de consola.
Ejemplo de opciones:

=== GESTIÓN DE ESTADOS DE CITAS ===
1. Registrar nuevo estado
2. Listar todos los estados
3. Buscar estado por ID
4. Buscar estado por nombre
5. Actualizar estado
6. Eliminar estado
0. Volver al menú principal


