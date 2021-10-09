Crear un proyecto Spring Boot ([https://start.spring.io/](https://start.spring.io/)) con las dependencias:

- Spring Data JPA
- H2 database
- Spring Web

Formato nombre: m2-testing-nombre-apellido

## Parte 1 (Spring Data JPA)

Crear una entidad (a propia elección)

Dentro del proyecto crearemos un menú para leer por consola diferentes opciones CRUD sobre la entidad:
(las operaciones CRUD se realizan contra la base de datos H2)

* Crear
* Buscar todos
* Buscar uno por id
* Modificar
* Borrar uno
* Borrar todos
* Contar el número de elementos
* Comprobar si existe un elemento por id

## Parte 2 (Spring REST)

Crear un controlador REST que permita realizar las operaciones CRUD sobre la entidad a través de [Postman](https://www.postman.com/).