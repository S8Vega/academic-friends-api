# Aplicación Web de Amigos Académicos IS - Backend #

Este es el repositorio del backend de la "Aplicación Web de Amigos Académicos IS", un proyecto cuyo objetivo es mejorar
la gestión del programa de amigos académicos para evitar la deserción de los estudiantes de la carrera de ingeniería de
sistemas.

## Instalación ##

Antes de comenzar, asegúrese de tener instalado y configurado lo siguiente:

1. Java 17
2. Gradle 8.4
3. Una cuenta de aws con las variables de entorno aws_access_key_id y aws_secret_access_key configuradas, ademas de
   tener creado un grupo de usuarios en cognito con las variables cognito_client_id y cognito_user_pool_id configuradas,
   y un bucket en S3
4. Una base de datos PostgreSQL con las variables de entorno datasource_url, datasource_username y datasource_password
   configuradas

Para instalar y configurar la aplicación en un entorno local, siga los siguientes pasos:

1. Clone este repositorio en su máquina local.
2. Importe el proyecto en su IDE preferido.
3. Instale las dependencias del proyecto utilizando Gradle.
4. Configure las variables de entorno necesarias para la aplicación.
5. Configure las variables de entorno necesarias para la base de datos.
6. Configure las variables de entorno necesarias para AWS.
7. Ejecute la aplicación.
8. La aplicación estará disponible en `http://localhost:8080/ufps/academic-friends-api`.
9. Consulte la documentación de la API para obtener más detalles sobre los endpoints disponibles
   en `http:localhost:8080/ufps/academic-friends-api/swagger-ui/index.html`.

## Configuración de la base de datos ##

La aplicación requiere una base de datos para funcionar correctamente. Siga estos pasos para configurar la base de
datos:

1. Cree una base de datos PostgreSQL.
2. Configure las variables de entorno `datasource_url`, `datasource_username` y `datasource_password` con los valores
   de conexión a la base de datos.
3. Ejecute la aplicación para crear las tablas y relaciones necesarias en la base de datos.

## Estructura del proyecto ##

El proyecto está estructurado utilizando Arquitectura Limpia de la siguiente manera:

- `domain`: Contiene las entidades y modelos del dominio.
- `domain.usecase`: Contiene los casos de uso del sistema.
- `domain.model`: Contiene los modelos de datos del dominio
- `infrastructure`: Contiene los adaptadores externos y utilidades.
- `infrastructure.entry-points`: Contiene los controladores de la API REST.
- `infrastructure.driven-adapters`: Contiene los adaptadores externos (AWS, base de datos, etc.).
- `applications`: Contiene la configuración de la aplicación.

Para mas informacion lee el
articulo [Clean Architecture � Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

## Cómo ejecutar la aplicación ##

Teniendo en cuenta que ya se configuraron las variables de entorno necesarias para la aplicación y se configuro la base
de datos:

Ejecute el archivo `applications/app-service/src/main/java/co/com/ufps/MainApplication.java`

## Uso y funcionalidades ##

La aplicación web de Amigos Académicos IS proporciona las siguientes funcionalidades:

- Registro de usuarios: Los estudiantes y amigos académicos pueden registrarse en el sistema.
- Creacion de convocatorias: Los coordinadores pueden crear convocatorias para que los estudiantes se inscriban.
- Registro de sesiones de asesoría: Los amigos académicos pueden registrar las sesiones de asesoría que realizan con
  los estudiantes.
- Visualizacion de estadisticas: Los coordinadores pueden visualizar estadísticas sobre las sesiones de asesoría
  realizadas.
- Registro de informes: Los amigos académicos pueden registrar informes sobre las sesiones de asesoría que realizan con
  los estudiantes.

## Endpoints de la API ##

Para obtener más información sobre los endpoints disponibles, consulte la documentación de la API
importando la colección de Postman ubicada en `documentation/academic-friends-api.postman_collection.json` o accediendo
a la documentación de Swagger en `http:localhost:8080/ufps/academic-friends-api/swagger-ui/index.html`.

## Tests y pruebas ##

Se le realizaron pruebas unitarias a los casos de uso del sistema, llegando a un 91% de cobertura de código.
Para ejecutar las pruebas unitarias, ejecute el subproyecto `domain/usecase` con el
comando `.\gradlew :usecase:clean :usecase:build :usecase:jacocoTestReport`.

Posteriormente, para ver el reporte de cobertura de código, abra el
archivo `domain/usecase/build/reports/jacocoHtml/index.html` en su navegador.

## Contribución ##

Se agradece cualquier contribución al proyecto. Si desea informar un error, solicitar una nueva característica o
contribuir con código, siga los siguientes pasos:

1. Cree un fork de este repositorio.
2. Cree una nueva rama con el nombre apropiado para su contribución.
3. Realice los cambios necesarios en su nueva rama.
4. Envíe un pull request con una descripción clara y concisa de los cambios realizados.

## Licencia ##

Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo LICENSE para obtener más información.

## Contacto ##

Si tiene alguna pregunta o problema relacionado con la aplicación, no dude en contactarnos
en bsebastianvg18@gmail.com Estaremos encantados de ayudar.