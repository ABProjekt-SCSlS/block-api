pipeline {
    agent any
      stages {
        stage('Build Stage') {
            steps {
                script {
                    mvn.compile()
                }
            }
        }
        stage('Unit Testing') {
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

        stage('Package Stage') {
            steps {
                script {
                    mvn.artifactpackage()
                }
            }
        }

        stage('Deploy to Nexus') {
            steps{
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_GLOBAL_SETTINGS')]){
                    script {

                        mvn.deploy()

                    }
                }
            }
        }

        stage('Build Test Environment') {
            steps{
                    script {
                        dockerlib.dockerCompose([docker_opt:"up",docker_arg:"--build"])
                        dockerlib.dockerPS([docker_opt:"",docker_arg:""])
                        dockerlib.dockerCompose([docker_opt:"down",docker_arg:""])
                }
            }
        }
          
       stage('Deploy to Tomcat') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'tomcat', usernameVariable: 'TOMCAT_USER', passwordVariable: 'TOMCAT_PASSWORD')]) {
                configFileProvider([configFile(fileId: 'default', variable: 'MAVEN_GLOBAL_SETTINGS')]){
                    sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS tomcat7:redeploy -DskipTests'
                }
              }     
            }
        }
          
       stage('Build Docker Image') {
            steps{
                    script {

                        dockerlib.dockerBuild([docker_opt:"",docker_arg:"-t devopsdus2020.azurecr.io/scsls:latest ${WORKSPACE} "])

                }
            }
        }

        stage('Push Image to Blob Storage') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'AZURECR', usernameVariable: 'AZURECR_USER', passwordVariable: 'AZURECR_PASSWORD')]) {
                    script {

                        dockerlib.dockerLogin([docker_opt:"",docker_arg:" devopsdus2020.azurecr.io -u ${AZURECR_USER} -p ${AZURECR_PASSWORD}"])
                        dockerlib.dockerPush([docker_opt:"",docker_arg:"devopsdus2020.azurecr.io/scsls:latest"])
                        dockerlib.dockerLogout([docker_opt:"",docker_arg:"devopsdus2020.azurecr.io"])
                    }
                }
            }
        }
    } 
}
