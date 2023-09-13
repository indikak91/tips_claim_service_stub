pipeline{
    agent any
    
    environment{
    	DOCKERHUB_CREDS = credentials('dockerhub')
    }

    stages {
    
        stage ('Clone Repository...') {

            steps{
                checkout scm
                sh 'ls *'
            }
        }
        stage ('Build Image...') {

            steps{
                sh 'docker build -t indikak91/tips_claims_service:$BUILD_NUMBER ./pushdockerimage/'
            }
        }
        
        stage ('DockerHub Login....') {

            steps{
                sh 'echo $DOCKERHUB_CREDS_PSW | docker login -u DOCKERHUB_CREDS_USR --password-stdin'
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
