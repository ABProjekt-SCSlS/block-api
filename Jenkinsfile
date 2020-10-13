pipeline {
    agent none
    environment {
        NEXUS_HOST = 'nexus:8081'
        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = 'admin'
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

         stage('push auf nexus') {
                    agent {
                        docker {
                            image 'maven:3.6.3-adoptopenjdk-14'
                            args '--network abschlussprojekt'
                        }
                    }
                    steps  {
                            withCredentials([usernamePassword(credentialsId: 'nexus_credentials', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASSWORD')]) {
                            sh 'mvn -s settings.xml deploy'
                        }
                    }
         }

         stage('nexus pull and add in target directory') {
            agent {
                docker {
                    image 'curlimages/curl'
                    args '--network abschlussprojekt'
                }
            }
        	steps {
           		sh 'curl -O -v http://nexus:8081/nexus/de/awacademy/spring-boot-webblog/0.0.1-SNAPSHOT/spring-boot-webblog-0.0.1-20201013.130347-26.war'
                sh 'mv spring-boot-webblog-0.0.1-20201013.130347-26.war spring-boot-webblog-nexus.war'
                sh 'mv spring-boot-webblog-nexus.war target/'
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
                echo 'mvn deploy'
            }
         }
    }
}
