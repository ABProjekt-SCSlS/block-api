pipeline {
    agent none
    environment {
        SPRING_BOOT_WEBBLOG_DB_URL = 'jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_blog?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8'
        SPRING_BOOT_WEBBLOG_DB_USERNAME = 'root'
        SPRING_BOOT_WEBBLOG_DB_PASSWORD = 'root'
    }
    stages {
         stage('build') {
           agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                }
            }
            steps {
                sh 'mvn compile'
            }
         }
    stage('Unit tests') {
             agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                }
            }
            steps {
                sh 'mvn test'
            }
         }
         
         stage('warfile erstellen') {
             agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                    args '--network abschlussprojekt'
                }
            }
            steps {
                sleep (7)
                sh 'mvn clean package'
            }
         }
        
    }
}
