pipeline {
    agent any
      stages {
        stage('Test Docker Version') {
            steps{
                    script {

                        docker.dockerversion()
                }
            }
        }
    } 
}
