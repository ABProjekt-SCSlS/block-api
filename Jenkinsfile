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

        stage('mvn verify/sonar') {
            steps {
                script {
                    
                    mvn.verify()
                    
                }
            }
        }

        stage('Package and deploy to Nexus') {
            steps {
                script {
                    
                    echo 'warten auf gruppe nginy'
                    
                }
            }
        }

     stage('Deployment to Tomcat') {
            steps {
                script {
                    
                    echo 'Deployment to Tomcat'
                    
                }
            }
        }
        
    }
}
