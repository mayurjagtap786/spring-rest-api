# define base docker image
FROM openjdk:17
LABEL maintainer="mayurjagtap"
CMD mkdir app
COPY target/rest-webservice-0.0.1-SNAPSHOT.jar app/springboot-restwebservice-docker.jar
ENTRYPOINT [ "java" ,"-jar" ,"/app/springboot-restwebservice-docker.jar" ]