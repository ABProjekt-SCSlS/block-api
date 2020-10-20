FROM tomcat:9.0.38-jdk14

FROM tomcat:latest

EXPOSE 8080

COPY tomcat/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY tomcat/context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
COPY target/scslswebblog.war /usr/local/tomcat/webapps/scslswebblog.war

CMD ["catalina.sh","run"]
