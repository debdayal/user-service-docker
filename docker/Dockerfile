FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD user-service-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
