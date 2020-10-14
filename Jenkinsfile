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
         
         stage ('warfile erstellen') {
             agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                    args '--network abschlussprojekt'
                }
            }
            steps {
                sleep (7)
                sh 'mvn clean package'
                sh 'ls target'
            }
         }
         stage ('deploy on tomcat') {
             agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                    args '--network abschlussprojekt'
                }
            }
            steps {
                sleep (7)
                echo 'mvn deploy'
            }
         }
         stage('sonarqube') {
            agent {
                docker {
                    image 'maven:3.6.3-adoptopenjdk-14'
                    args '--network abschlussprojekt'
                }
            }
            steps {
                sh 'cd app && mvn -s settings.xml clean verify sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=d405de432ed34ed78f8dbe5bfbcd9fe340eb9940 -Dsonar.projectName=abschlussprojekt'
            }
        }
    }
}
