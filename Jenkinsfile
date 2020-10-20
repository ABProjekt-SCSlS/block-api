pipeline {
    agent any
      stages {
        stage('Test Docker Version') {
            steps{
                    script {
                        config=[docker_opt:""]
                        dockerlib.dockerList(config)
                }
            }
        }
    } 
}
