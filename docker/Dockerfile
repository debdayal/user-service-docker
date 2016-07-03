FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD user-service-1.0.jar app.jar
COPY run.sh run.sh
COPY wait-for-it.sh wait-for-it.sh
ENTRYPOINT ["./run.sh"]
