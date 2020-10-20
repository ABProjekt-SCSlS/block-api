pipeline {
    agent any
      stages {
        stage('Test Docker Version') {
            steps{
                    script {
                        dockerlib.dockerList(config.docker_opt="container")
                }
            }
        }
    } 
}
