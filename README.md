# Spring Boot GraphQL Application

Este es un proyecto de ejemplo utilizando **Spring Boot** con **GraphQL** para la gestión de cursos y estudiantes. La aplicación interactúa con una base de datos PostgreSQL y expone un API GraphQL que permite crear, leer y eliminar cursos y estudiantes.

## Tecnologías Utilizadas

- **Java** (JDK 11+)
- **Spring Boot** (con Spring Data JPA, Spring GraphQL)
- **GraphQL** (para consultas y mutaciones)
- **PostgreSQL** (como base de datos relacional)
- **Docker** (para el entorno de la base de datos)
- **Docker Compose** (para facilitar la configuración y el despliegue)

## Requisitos Previos

Asegúrate de tener instalados los siguientes programas:

- **Java 11** o superior
- **Maven**
- **Docker** y **Docker Compose**

## Configuración del Proyecto

### 1. Clonar el Repositorio

Clona el proyecto desde el repositorio de GitHub:

```bash
git clone https://github.com/tuusuario/tu-repositorio.git
cd tu-repositorio
```

### 2. Configuración de la Base de Datos con Docker

Este proyecto utiliza PostgreSQL como base de datos. Para configurar PostgreSQL, hemos proporcionado un archivo docker-compose.yml.

Puedes ejecutar el siguiente comando para iniciar el contenedor de PostgreSQL:

```bash
docker-compose up -d
```

Esto creará un contenedor con la siguiente configuración:

Usuario: springbootgraphql
Contraseña: springbootgraphql
Base de datos: springbootgraphql

### 3. Configuración de la Aplicación Spring Boot
La aplicación está configurada para conectarse a la base de datos PostgreSQL a través de la URL jdbc:postgresql://localhost:5432/springbootgraphql. Si necesitas cambiar esta configuración, puedes hacerlo en el archivo application.properties:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/springbootgraphql
spring.datasource.username=springbootgraphql
spring.datasource.password=springbootgraphql
spring.jpa.hibernate.ddl-auto=update
```

### 4. Compilar y Ejecutar la Aplicación

```bash
mvn clean install
mvn spring-boot:run
```

Esto iniciará el servidor en http://localhost:8080.

### 5. Detener contenedor

Para detener y eliminar los contenedores y la red creada por Docker Compose, ejecuta:

```bash
docker-compose down
```

## Interacción con la API GraphQL

### Obtener un curso por ID:

```bash
query {
  findCourseById(courseId: "1") {
    id
    name
    category
    teacher
  }
}

```
### Obtener todos los cursos:

```bash
query {
  findAllCourses {
    id
    name
    category
    teacher
  }
}

```
### Obtener un estudiante por ID:

```bash
query {
  findStudentById(studentId: "1") {
    id
    name
    lastName
    age
    course {
      name
    }
  }
}

```
### Obtener todos los estudiantes:

```bash
query {
  findAllStudents {
    id
    name
    lastName
    age
    course {
      name
    }
  }
}

```
## Mutaciones Disponibles (Mutations)

### Crear un nuevo curso:
```bash
mutation {
  createCourse(inputCourse: {name: "Curso de Java", category: "Programación", teacher: "Juan Pérez"}) {
    id
    name
    category
    teacher
  }
}

```
### Eliminar un curso por ID:

```bash
mutation {
  deleteCourseById(courseId: "1")
}

```
### Crear un nuevo estudiante:

```bash
mutation {
  createStudent(inputStudent: {name: "Ana", lastName: "García", age: 20, courseId: "1"}) {
    id
    name
    lastName
    age
    course {
      name
    }
  }
}

```
### Eliminar un estudiante por ID:

```bash
mutation {
  deleteStudentById(studentId: "1")
}

```


```bash

```



## Arquitectura del Proyecto
El proyecto está organizado en las siguientes capas:

### Controllers:
Manejan las solicitudes entrantes de GraphQL y dirigen las operaciones correspondientes.

CourseController: Controlador que gestiona las operaciones relacionadas con los cursos.
StudentController: Controlador que gestiona las operaciones relacionadas con los estudiantes.
### Services:
Contienen la lógica de negocio de la aplicación.

CourseService: Servicios relacionados con la gestión de cursos.
StudentService: Servicios relacionados con la gestión de estudiantes.
### Models: 
Definen las entidades de la aplicación.

Course: Entidad que representa un curso.
Student: Entidad que representa un estudiante.
### GraphQL Models:
Definen los objetos de entrada para las mutaciones.

InputCourse: Objeto de entrada para crear un curso.
InputStudent: Objeto de entrada para crear un estudiante.