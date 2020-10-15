FROM tomcat:latest

ENV SPRING_BOOT_WEBBLOG_DB_URL jdbc:mysql://localhost:3306/spring_boot_webblog
ENV SPRING_BOOT_WEBBLOG_DB_USERNAME root
ENV SPRING_BOOT_WEBBLOG_DB_PASSWORD root

COPY ./target /usr/local/tomcat/webapps
CMD ["cathalina.sh", "run"]
EXPOSE 8787