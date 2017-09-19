FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAVA_OPTS=""
ENV ARTIFACT trek-0.0.1-SNAPSHOT
EXPOSE 8200
ADD target/$ARTIFACT.jar app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar"]