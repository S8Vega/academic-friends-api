# Aplicación Web de Amigos Académicos IS - Backend #

Este repositorio contiene el código del backend de la "Aplicación Web de Amigos Académicos IS". El objetivo principal de
este proyecto es mejorar la gestión del programa de amigos académicos para evitar la deserción de los estudiantes de la
carrera de ingeniería de sistemas.

## Instalación y configuración ##

Antes de empezar, asegúrate de tener instalados y configurados los siguientes elementos:

1. Java 17
2. Gradle 8.4
3. Cuenta de AWS (con las variables de entorno aws_access_key_id y aws_secret_access_key configuradas), grupo de usuario
   en Cognito (con las variables cognito_client_id y cognito_user_pool_id configuradas) y un bucket en S3.
4. Base de datos PostgreSQL (con las variables de entorno datasource_url, datasource_username y datasource_password
   configuradas).

Para instalar y configurar la aplicación en un entorno local, sigue estos pasos:

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE favorito.
3. Instala las dependencias del proyecto usando Gradle.
4. Configura las variables de entorno necesarias para la aplicación.
5. Configura las variables de entorno necesarias para la base de datos.
6. Configura las variables de entorno necesarias para AWS.
7. Ejecuta la aplicación.
8. La aplicación estará disponible en `http://localhost:8080/ufps/academic-friends-api`.
9. Consulta la documentación de la API para obtener más detalles sobre los endpoints disponibles
   en `http:localhost:8080/ufps/academic-friends-api/swagger-ui/index.html`.

## Estructura del proyecto ##

El proyecto sigue una estructura basada en la Arquitectura Limpia (Clean Architecture), dividiéndolo en los siguientes
componentes:

- `domain`: Contiene las entidades y modelos del dominio.
- `domain.usecase`: Contiene los casos de uso del sistema.
- `domain.model`: Contiene los modelos de datos del dominio.
- `infrastructure`: Contiene los adaptadores externos y utilidades.
- `infrastructure.entry-points`: Contiene los controladores de la API REST.
- `infrastructure.driven-adapters`: Contiene los adaptadores externos (AWS, base de datos, etc.).
- `applications`: Contiene la configuración de la aplicación.

Para más información sobre la Arquitectura Limpia, puedes leer el
artículo "[Clean Architecture – Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)" (
en español).

## Uso y funcionalidades ##

La aplicación web de Amigos Académicos IS proporciona las siguientes funcionalidades:

- Registro de usuarios: Los estudiantes y los amigos académicos pueden registrarse en el sistema.
- Creación de convocatorias: Los coordinadores pueden crear convocatorias para que los estudiantes se inscriban.
- Registro de sesiones de asesoría: Los amigos académicos pueden registrar las sesiones de asesoría que realizan con los
  estudiantes.
- Visualización de estadísticas: Los coordinadores pueden ver estadísticas sobre las sesiones de asesoría realizadas.
- Registro de informes: Los amigos académicos pueden registrar informes sobre las sesiones de asesoría que realizan con
  los estudiantes.

## Endpoints de la API ##

Para obtener más información sobre los endpoints disponibles, consulta la documentación de la API. Puedes importar la
colección de Postman ubicada en `documentation/academic-friends-api.postman_collection.json` o acceder a la
documentación de Swagger en `http:localhost:8080/ufps/academic-friends-api/swagger-ui/index.html`.

## Pruebas ##

El proyecto incluye pruebas unitarias que cubren el 87% del código. Para ejecutar estas pruebas, puedes usar el
comando `.\gradlew :usecase:clean :usecase:build :usecase:jacocoTestReport`.

Después de ejecutar las pruebas, puedes ver el reporte de cobertura de código en el
archivo `domain/usecase/build/reports/jacocoHtml/index.html`.

## Contribución ##

Cualquier contribución al proyecto es bienvenida. Si deseas informar un error, solicitar una nueva funcionalidad o
contribuir con código, sigue estos pasos:

1. Crea un fork de este repositorio.
2. Crea una nueva rama con un nombre descriptivo.
3. Haz los cambios necesarios en esa rama.
4. Envía un pull request con una descripción clara y concisa de los cambios realizados.

## Licencia ##

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más información.

## Contacto ##

Si tienes alguna pregunta o problema relacionado con la aplicación, no dudes en ponerte en contacto con nosotros a
través de bsebastianvg18@gmail.com. Estaremos encantados de ayudarte.