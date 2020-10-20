FROM tomcat:latest

EXPOSE 8080

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
COPY ../target/spring-boot-webblog.war /usr/local/tomcat/webapps/spring-boot-webblog.war

CMD ["catalina.sh", "run"]

