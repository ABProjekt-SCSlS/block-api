pipeline {
    agent any
      stages {
         stage('deploy on Tomcat') {
           agent {
                docker { 
                    image 'maven:3.6.3-adoptopenjdk-14'
                }
            }
            steps {
                sh 'mvn tomcat7:deploy'
            }
         }
}
}
