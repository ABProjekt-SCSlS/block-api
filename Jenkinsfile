pipeline {
    agent any
      stages {
        stage('Test Docker Version') {
            steps{
                    script {

                        dockerlib.dockerList(docker_opt:"container")
                }
            }
        }
    } 
}
