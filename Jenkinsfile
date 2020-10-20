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

      stage('Package and deploy to Nexus') {
            steps{
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_GLOBAL_SETTINGS')]){
                    script {

                        mvn.deploy()

                    }
                }
            }
        }
          
       stage('Deploy to Tomcat') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'tomcat', usernameVariable: 'TOMCAT_USER', passwordVariable: 'TOMCAT_PASSWORD')]) {
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_GLOBAL_SETTINGS')]){
                    sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS tomcat7:deploy -DskipTests'
                }
              }     
            }
        }
          
       stage('Test Docker Version') {
            steps{
                    script {

                        dockerlib.dockerPS([docker_opt:""])
                }
            }
        }
    } 
}
