FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app

COPY target/teamGenerator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8443

CMD ["java", "-jar", "app.jar"]
