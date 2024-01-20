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

## Variables de entorno ##

La aplicación utiliza las siguientes variables de entorno:

- `datasource_url`: URL de la base de datos.
- `datasource_username`: Nombre de usuario de la base de datos.
- `datasource_password`: Contraseña de la base de datos.
- `cognito_client_id`: ID del cliente de Cognito.
- `cognito_user_pool_id`: ID del grupo de usuarios de Cognito.
- `aws_access_key_id`: ID de la clave de acceso de AWS.
- `aws_secret_access_key`: Clave de acceso secreta de AWS.
- `env`: Entorno de ejecución de la aplicación (local, dev, prod).
- `secret_key`: Clave secreta para la generación de tokens JWT.

## Configuracion y ejecucion de docker ##

Este manual detalla los pasos necesarios para construir y ejecutar la aplicación Academic Friends API mediante Docker.
Asegúrate de
tener Docker instalado en tu entorno antes de comenzar.

### Requisitos Previos

- [Docker](https://www.docker.com/) instalado y configurado en tu sistema.

### Pasos para Ejecutar la Aplicación con Docker

1. **Limpieza y Construcción del Proyecto:**
   Abre una terminal y navega al directorio raíz del proyecto. Ejecuta los siguientes comandos para limpiar y construir
   el proyecto:

   ```bash
   ./gradlew clean build
   ```

2. **Mover el JAR a la Carpeta de Despliegue:**
   Ejecuta el siguiente comando para mover el archivo JAR generado a la carpeta de despliegue:

   ```bash
   mv applications/app-service/build/libs/academic-friends-api.jar deployment/
   ```

3. **Navegar al Directorio de Despliegue:**
   Cambia al directorio de despliegue con el siguiente comando:

   ```bash
   cd deployment/
   ```

4. **Construcción de la Imagen Docker:**
   Construye la imagen Docker utilizando el siguiente comando:

   ```bash
   docker build -t <dockerhub_username>/af-image .
   ```

5. **Subir la Imagen a Docker Hub:**
   Sube la imagen recién construida a Docker Hub con el siguiente comando: (Opcional)

   ```bash
   docker push <dockerhub_username>/af-image
   ```

6. **Ejecutar el Contenedor Docker:**
   Finalmente, ejecuta el contenedor Docker con el siguiente comando:

   ```bash
   docker run -p 8080:8080 --name af-container -d \
   -e academic-friends-bucket=<bucket_name> \
   -e aws_access_key_id=<aws_access_key_id> \
   -e aws_secret_access_key=<aws_secret_access_key> \
   -e cognito_client_id=<cognito_client_id> \
   -e cognito_user_pool_id=<cognito_user_pool_id> \
   -e datasource_password=<datasource_password> \
   -e datasource_url=<datasource_url> \
   -e datasource_username=<datasource_username> \
   -e env=local \
   -e secret_key=<secret_key> \
   <dockerhub_username>/af-image
   ```

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
artículo "[Clean Architecture – Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)"
(en español).

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

El proyecto incluye pruebas unitarias que cubren el 90% del código. Para ejecutar estas pruebas, puedes usar el
comando:

```bash
.\gradlew :usecase:clean :usecase:build :usecase:jacocoTestReport
```

Después de ejecutar las pruebas, puedes ver el reporte de cobertura de código en el
archivo `domain/usecase/build/reports/jacocoHtml/index.html`, o ejecutando el siguiente comando:

```bash
Invoke-Item domain/usecase/build/reports/jacocoHtml/index.html
```

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

Si tienes alguna pregunta o comentario sobre el proyecto, puedes contactarme a través de mi correo electrónico.