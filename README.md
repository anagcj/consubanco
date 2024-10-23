# ConsuBanco Investment API

## Descripción

El proyecto **ConsuBanco Investment API** es una aplicación desarrollada en **Java Spring Boot** para exponer un ejemplo de un servicio en el cual se puedan dar de alta un producto de inversión con su respectivo isr y plan de interes, asi mismo se expone otro servicio para clientes y sucursales del banco. Proporciona una API REST para gestionar datos sobre productos de inversión con su respectivo ISR y planes de interes asi mismo los clientes y sucursales incluyendo la creación, actualización, consulta y eliminación de estos datos.

Esta API permite la interacción a través de operaciones HTTP como `GET`, `POST`, `PUT` y `DELETE`, facilitando así la exposición de estos servicios para la administración de los diferentes recursos de ConsuBanco.

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

### Client (Cliente) y Branch (Sucursal)

#### Crear un nuevo cliente y branch

- **URL:** `/client/saveClient`
- **Método:** `POST`
- **Body:**
  ```json
      {
        "clientName": "Juan Pérez",
        "phoneNum": "5551234567",
        "clientCol": "Colonia Ejemplo",
        "branches": [
          {
            "branchName": "Sucursal Norte",
            "address": "Ciudad de México"
          },
          {
            "branchName": "Sucursal Sur",
            "address": "Monterrey"
          }
        ]
      }

  ```
- **Respuesta:**
  ```json
     {
        "clientName": "Juan Pérez",
        "phoneNum": "5551234567",
        "clientCol": "Colonia Ejemplo",
        "branches": [
          {
            "branchName": "Sucursal Norte",
            "address": "Ciudad de México"
          },
          {
            "branchName": "Sucursal Sur",
            "address": "Monterrey"
          }
        ]
      }
  ```

#### Actualizar un cliente y branch existente

- **URL:** `/client/updateClient`
- **Método:** `PUT`
- **Body:**
  ```json
   {
        "clientName": "Juan Pérez",
        "phoneNum": "5551234567",
        "clientCol": "Se modifica la colonia",
        "branches": [
          {
            "branchName": "Sucursal Norte",
            "address": "Ciudad de México"
          },
          {
            "branchName": "Sucursal Sur",
            "address": "Monterrey"
          }
        ]
      }
  ```
- **Respuesta:**
  ```json
      {
          "idClient": 146,
          "clientName": "Juan Pérez",
          "phoneNum": "5551234567",
          "clientCol": "Se modifica la colonia"
      }
  ```

#### Obtener un cliente y branch por ID 

- **URL:** `/client/{clientId}`
- **Método:** `GET`
- **Ejemplo de URL:** `/client/145`
- **Respuesta:**
  ```json
        {
          "idClient": 145,
          "clientName": "Juan Pérez",
          "phoneNum": "5551234567",
          "clientCol": "Colonia Ejemplo"
        }  
   ```

#### Elimina un cliente y branch por ID

- **URL:** `/client/{clientId}`
- **Método:** `DELETE`
- **Ejemplo de URL:** `/client/CL001`
- **Respuesta:**
  ```
  200 OK
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

### InvestmentProduct (Producto de Invesión), ISR e Interest Plan (Plan de interes)

#### Crear un nuevo InvestmentProduct (Producto de Invesión), ISR e Interest Plan (Plan de interes)

- **URL:** `/investmentProduct/saveInvestmentProduct`
- **Método:** `POST`
- **Body:**
  ```json
       {
          "idProduct": "106",
          "productDescription": "CONSUINVERSION 90 DIAS",
          "productCommercialName": "INVERSION DIGITAL",
          "term": "92",
          "investmentProfile": "PLATINUM",
          "periodsInterest": 28,
          "factor": 100,
          "interestAnnualBase": 360,
          "isr": {
              "idIsr": "YU75",
              "rate": 0.6,
              "factor": 100,
              "annualBase": 365
              },
          "interestPlan":         
              {
                  "idInterestPlan": "97",
                  "term": 92,
                  "amount": 5000,
                  "interestRate": 6.5
              }
            }
  ```
- **Respuesta:**
  ```json
       {
       "idProduct": "110",
       "productDescription": "CONSUINVERSION 0 DIAS",
       "productCommercialName": "INVERSION DIGITAL",
       "term": "92",
       "investmentProfile": "PLATINUM",
       "periodsInterest": 28,
       "factor": 100,
       "interestAnnualBase": 360,
       "isr": {
           "idIsr": "YU76",
           "rate": 0.6,
           "factor": 100,
           "annualBase": 365
       },
       "interestPlan": {
           "idInterestPlan": "98",
           "term": 92,
           "amount": 5000,
           "interestRate": 6.5
       }
      }
  ```

#### Actualizar un InvestmentProduct (Producto de Invesión), ISR e Interest Plan (Plan de interes)

- **URL:** `investmentProduct/modificarInvestmentProduct`
- **Método:** `PUT`
- **Body:**
  ```json
      {
       "idProduct": "110",
       "productDescription": "CONSUINVERSION 0 DIAS",
       "productCommercialName": "MODIFICA",
       "term": "93",
       "investmentProfile": "PLATINUM",
       "periodsInterest": 28,
       "factor": 100,
       "interestAnnualBase": 360,
       "isr": {
           "idIsr": "YU76",
           "rate": 0.6,
           "factor": 120,
           "annualBase": 365
           },
       "interestPlan":         
           {
               "idInterestPlan": "98",
               "term": 92,
               "amount": 5001,
               "interestRate": 6.5
           }
         }
  ```
- **Respuesta:**
  ```json
      {
       "idProduct": "110",
       "productDescription": "CONSUINVERSION 0 DIAS",
       "productCommercialName": "MODIFICA",
       "term": "93",
       "investmentProfile": "PLATINUM",
       "periodsInterest": 28,
       "factor": 100,
       "interestAnnualBase": 360,
       "isr": {
           "idIsr": "YU76",
           "rate": 0.6,
           "factor": 120,
           "annualBase": 365
       },
       "interestPlan": {
           "idInterestPlan": "98",
           "term": 92,
           "amount": 5001,
           "interestRate": 6.5
       }
      }
  ```

#### Obtener un InvestmentProduct (Producto de Invesión), ISR e Interest Plan (Plan de interes)

- **URL:** `/investmentProduct/obtenerInvestmentProduct`
- **Método:** `GET`
- **Respuesta:**
  ```json
         Lista todos los Investment Products 
  ```

#### Elimina un InvestmentProduct (Producto de Invesión), ISR e Interest Plan (Plan de interes)

- **URL:** `investmentProduct/eliminarInvestmentProduct?idProduct=110`
- **Método:** `DELETE`
- **Respuesta:**
  ```
  200 OK
  ```


## Notas Adicionales
- **Errores comunes**: Si experimentas problemas al realizar operaciones `POST`, `PUT` o `DELETE`, verifica que las credenciales de la base de datos sean correctas y que las tablas estén correctamente configuradas.
- **Datos de prueba**: Puedes usar herramientas como **Postman** o **cURL** para realizar pruebas sobre los diferentes endpoints.

## Autor
ConsuBanco Development Team (Ana Gabriela Campos, Asinú García Krinis)

## Licencia
Este proyecto está bajo la licencia MIT es un ejemplo con fines educativos para aplicar conocimientos adquiridos en el curso de Diplomado Java con Spring.
