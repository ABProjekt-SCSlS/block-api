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
    }
}
