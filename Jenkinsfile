pipeline{
    agent any
    
    environment{
    	DOCKERHUB_CREDS = credentials('dockerhub')
    }

    stages {
    
        stage ('Clone Repository...') {

            steps{
                checkout scm
                sh 'cat Dockerfile'
            }
        }
        stage ('Build Image...') {

            steps{
                sh 'sudo docker build -t indikak91/tips_claims_service:$BUILD_NUMBER . '
            }
        }
        
        stage ('DockerHub Login....') {

            steps{
                sh 'echo $DOCKERHUB_CREDS_PSW | docker login -u DOCKERHUB_CREDS_USR --password-stdin'
            }
        } 
        
        stage ('Docker Push....') {

            steps{
                sh 'sudo docker push indikak91/tips_claims_service:$BUILD_NUMBER '
            }
        }             

        stage('Test') {
            steps{
                echo 'Testing...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    
    post {
    	always {
    		sh 'docker logout'
    	}
    
    }
    
    
}
