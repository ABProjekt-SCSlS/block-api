pipeline {
    agent any
      stages {
         stage('mvn compile') {
            steps {
                script {
                    mvn.compile()
                }
            }
        }
      stage('mvn test') {
            steps {
                script {
                    mvn.test()
                }
            }
        }
      stage('Statische Code-Analyse') {
            steps {
                script {
                    mvn.verify()
                }
            }
        }
      stage('mvn package') {
            steps {
                script {
                    mvn.artifactpackage()
                }
            }
        }
        stage('mvn deploy on Tomcat') {
            steps {
                    sh 'mvn tomcat7:deploy'
            }
        }
    } 
}