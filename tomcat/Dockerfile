FROM tomcat:latest

ENV SPRING_BOOT_WEBBLOG_DB_URL=jdbc:mysql://${MYSQL_HOST:52.233.247.20}:8085/db_blog?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME=root
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD=root

EXPOSE 8080

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
COPY ../target/spring-boot-webblog.war /usr/local/tomcat/webapps/spring-boot-webblog.war
CMD ["catalina.sh", "run"]

