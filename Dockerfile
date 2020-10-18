FROM tomcat:9.0.38-jdk14


ENV SPRING_BOOT_WEBBLOG_DB_URL jdbc:mysql://mysql:3306/scsls_db_blog?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME root
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD root

COPY target/scsls-webblog.war /usr/local/tomcat/webapps/scsls-webblog.war

CMD ["catalina.sh","run"]
