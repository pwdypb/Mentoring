FROM tomcat:8.0-jre8
ENV ARTIFACT traveller-0.0.1-SNAPSHOT
EXPOSE 8080
COPY target/$ARTIFACT.war /usr/local/tomcat/webapps
RUN sh -c 'touch /usr/local/tomcat/webapps/$ARTIFACT.war'
ENTRYPOINT ["catalina.sh", "run"]