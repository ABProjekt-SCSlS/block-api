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
    
          stage('Statische Codeanalyse') {
            steps {
              script {
               		mvn.verify()
            }
            }
 }
        stage('WAR File erstellen') {
            steps {
              script {
               		mvn.artifactpackage()      
            }
            }
 }
}
}
