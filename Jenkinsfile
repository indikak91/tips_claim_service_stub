pipeline{
    agent any
    
    environment{
    	DOCKERHUB_CREDS  = credentials('dockerhub')
    }

    stages {
    
        stage ('Clone Repository...') {

            steps{
                checkout scm
                sh 'cat Dockerfile'
            }
        }
        
        stage ('Package the Project...') {
            steps{
                sh 'mvn clean install '
            }
        }
                
        stage ('Build Image...') {
            steps{
                sh 'docker build -t indikak2005/tips_claims_service:$BUILD_NUMBER . '
                // indikak2005 is the dockerhub password
            }
        }
        
        stage ('DockerHub Login....') {

            steps{
                sh 'echo $DOCKERHUB_CREDS_PSW | docker login -u $DOCKERHUB_CREDS_USR --password-stdin'
            }
        } 
        
        stage ('Docker Push....') {

            steps{
                sh 'docker push indikak91/tips_claims_service:$BUILD_NUMBER '
            }
        }             

        stage('Test') {
            steps{
                echo 'Testing...'
            }
        }

    }
    
    post {
    	always {
    		sh 'docker logout'
    	}
    
    }
    
    
}
