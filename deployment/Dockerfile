FROM amazoncorretto:17
LABEL maintainer="S8Vega"

COPY *.jar academic-friends-api.jar
ENV JAVA_OPTS="-Xms256m -Xmx512m -Djava.security.egd=file:/dev/./urandom -debug"


ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar academic-friends-api.jar" ]