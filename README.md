# ConsuBanco Investment API

## Descripción

El proyecto **ConsuBanco Investment API** es una aplicación desarrollada en **Java Spring Boot** para manejar información relacionada con las inversiones, las sucursales y los clientes del banco. Proporciona una API REST para gestionar datos sobre sucursales, clientes, productos de inversión y planes de ISR, incluyendo la creación, actualización, consulta y eliminación de estos datos.

Esta API permite la interacción a través de operaciones HTTP como `GET`, `POST`, `PUT` y `DELETE`, facilitando así la administración de los diferentes recursos de ConsuBanco.

## Tecnologías Utilizadas

- **Java 8+**
- **Spring Boot** (Spring Web, Spring Data JPA)
- **MySQL** (para la base de datos relacional)
- **Hibernate** (JPA para ORM)
- **Maven** (gestión de dependencias)

## Instalación y Ejecución

1. Clona el repositorio:

   ```bash
   git clone <URL_REPOSITORIO>
   ```

2. Importa el proyecto en tu IDE favorito (IntelliJ, Eclipse, VS Code).

3. Asegúrate de tener una instancia de MySQL corriendo y crea la base de datos requerida:

   ```sql
   CREATE DATABASE ConsuBanco;
   ```

4. Configura las credenciales de la base de datos en `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ConsuBanco
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   ```

5. Ejecuta la aplicación desde tu IDE o mediante Maven:

   ```bash
   mvn spring-boot:run
   ```

6. La API estará disponible en `http://localhost:8080`.

## Endpoints Disponibles

### Branch (Sucursal)

#### Crear una nueva sucursal

- **URL:** `/branch/saveBranch`
- **Método:** `POST`
- **Body:**
  ```json
  {
    "branchName": "Sucursal Centro",
    "address": "Ciudad de México"
  }
  ```
- **Respuesta:**
  ```json
  {
    "idBranch": 1,
    "branchName": "Sucursal Centro",
    "address": "Ciudad de México"
  }
  ```

#### Actualizar una sucursal existente

- **URL:** `/branch/updateBranch`
- **Método:** `PUT`
- **Body:**
  ```json
  {
    "idBranch": 1,
    "branchName": "Sucursal Actualizada",
    "address": "Ciudad de México"
  }
  ```
- **Respuesta:**
  ```json
  {
    "idBranch": 1,
    "branchName": "Sucursal Actualizada",
    "address": "Ciudad de México"
  }
  ```

#### Obtener una sucursal por ID

- **URL:** `/branch/{branchId}`
- **Método:** `GET`
- **Ejemplo de URL:** `/branch/1`
- **Respuesta:**
  ```json
  {
    "idBranch": 1,
    "branchName": "Sucursal Centro",
    "address": "Ciudad de México"
  }
  ```

#### Eliminar una sucursal por ID

- **URL:** `/branch/{branchId}`
- **Método:** `DELETE`
- **Ejemplo de URL:** `/branch/1`
- **Respuesta:**
  ```
  200 OK
  ```

#### Obtener todas las sucursales

- **URL:** `/branch/all`
- **Método:** `GET`
- **Respuesta:**
  ```json
  [
    {
      "idBranch": 1,
      "branchName": "Sucursal Centro",
      "address": "Ciudad de México"
    },
    {
      "idBranch": 2,
      "branchName": "Sucursal Norte",
      "address": "Ciudad de México"
    }
  ]
  ```

### ISR (Impuesto Sobre la Renta)

#### Crear un nuevo ISR

- **URL:** `/isr/saveIsr`
- **Método:** `POST`
- **Body:**
  ```json
  {
    "idIsr": "YU69",
    "rate": 0.7,
    "factor": 102,
    "annualBase": 366
  }
  ```
- **Respuesta:**
  ```json
  {
    "idIsr": "YU69",
    "rate": 0.7,
    "factor": 102,
    "annualBase": 366
  }
  ```

#### Actualizar un ISR existente

- **URL:** `/isr/modificarIsr`
- **Método:** `PUT`
- **Body:**
  ```json
  {
    "idIsr": "YU69",
    "rate": 0.8,
    "factor": 110,
    "annualBase": 366
  }
  ```
- **Respuesta:**
  ```json
  {
    "idIsr": "YU69",
    "rate": 0.8,
    "factor": 110,
    "annualBase": 366
  }
  ```

#### Obtener todos los ISR

- **URL:** `/isr/obtenerIsr`
- **Método:** `GET`
- **Respuesta:**
  ```json
  [
    {
      "idIsr": "YU69",
      "rate": 0.8,
      "factor": 110,
      "annualBase": 366
    }
  ]
  ```

#### Eliminar un ISR por ID

- **URL:** `/isr/eliminarIsr?idIsr={idIsr}`
- **Método:** `DELETE`
- **Ejemplo de URL:** `/isr/eliminarIsr?idIsr=YU69`
- **Respuesta:**
  ```
  200 OK
  ```

### Client (Cliente)

#### Crear un nuevo cliente

- **URL:** `/client/saveClient`
- **Método:** `POST`
- **Body:**
  ```json
  {
    "idClient": "CL001",
    "clientName": "Juan Pérez",
    "phoneNum": "5551234567"
  }
  ```
- **Respuesta:**
  ```json
  {
    "idClient": "CL001",
    "clientName": "Juan Pérez",
    "phoneNum": "5551234567"
  }
  ```

#### Actualizar un cliente existente

- **URL:** `/client/updateClient`
- **Método:** `PUT`
- **Body:**
  ```json
  {
    "idClient": "CL001",
    "clientName": "Juan Pérez Actualizado",
    "phoneNum": "5559876543"
  }
  ```
- **Respuesta:**
  ```json
  {
    "idClient": "CL001",
    "clientName": "Juan Pérez Actualizado",
    "phoneNum": "5559876543"
  }
  ```

#### Obtener un cliente por ID

- **URL:** `/client/{clientId}`
- **Método:** `GET`
- **Ejemplo de URL:** `/client/CL001`
- **Respuesta:**
  ```json
  {
    "idClient": "CL001",
    "clientName": "Juan Pérez",
    "phoneNum": "5551234567"
  }
  ```

#### Eliminar un cliente por ID

- **URL:** `/client/{clientId}`
- **Método:** `DELETE`
- **Ejemplo de URL:** `/client/CL001`
- **Respuesta:**
  ```
  200 OK
  ```

#### Obtener todos los clientes

- **URL:** `/client/all`
- **Método:** `GET`
- **Respuesta:**
  ```json
  [
    {
      "idClient": "CL001",
      "clientName": "Juan Pérez",
      "phoneNum": "5551234567"
    },
    {
      "idClient": "CL002",
      "clientName": "María López",
      "phoneNum": "5557654321"
    }
  ]
  ```

## Modelos de Datos

### Branch (Sucursal)
- `idBranch` (String): Identificador de la sucursal.
- `branchName` (String): Nombre de la sucursal.
- `address` (String): Dirección de la sucursal.

### ISR
- `idIsr` (String): Identificador del ISR.
- `rate` (float): Tasa del ISR.
- `factor` (int): Factor del ISR.
- `annualBase` (int): Base anual para el cálculo del ISR.

### Client (Cliente)
- `idClient` (String): Identificador del cliente.
- `clientName` (String): Nombre del cliente.
- `phoneNum` (String): Número de teléfono del cliente.

## Notas Adicionales
- **Errores comunes**: Si experimentas problemas al realizar operaciones `POST`, `PUT` o `DELETE`, verifica que las credenciales de la base de datos sean correctas y que las tablas estén correctamente configuradas.
- **Datos de prueba**: Puedes usar herramientas como **Postman** o **cURL** para realizar pruebas sobre los diferentes endpoints.

## Autor
ConsuBanco Development Team (Ana Gabriela Campos, Asinú García Krinis)

## Licencia
Este proyecto está bajo la licencia MIT.
