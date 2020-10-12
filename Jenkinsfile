pipeline {
    agent none
    environment {
        NEXUS_HOST = 'nexus:8081'
    }
    stages {
        stage('build') {
            steps {
                echo 'build'
            }
         }
        stage('test') {
            steps {
                echo 'test'
            }
         }
        stage('deploy tomcat') {
            steps {
            	echo 'deploy tomcat'
            }
        }
    
    }
}
