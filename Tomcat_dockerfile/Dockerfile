FROM tomcat:latest

ENV SPRING_BOOT_WEBBLOG_DB_URL jdbc:mysql://g4-mysql:3306/db_blog
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME root
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD root

EXPOSE 8787

COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY context.xml /usr/local/tomcat/webapps.dist/manager/META-INF/context.xml
COPY spring-boot-webblog.war /usr/local/tomcat/webapps/spring-boot-webblog.war
CMD ["catalina.sh", "run"]

