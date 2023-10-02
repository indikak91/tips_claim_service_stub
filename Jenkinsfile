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
        
	   stage('SonarQube analysis') {
	    withSonarQubeEnv(credentialsId: '0a6b33099214c5a7ba9b372e577a9b2cb89c77ba', installationName: 'tune_cicd') { // You can override the credential to be used
	      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
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
                sh 'docker push indikak2005/tips_claims_service:$BUILD_NUMBER '
            }
        }             

        stage('Invokde Downstream Job') {
            steps{
              // buil anothe job with interval  
              //  build quietPeriod: 5, job: 'pipeline_scm_git_job_tips_claims-Service_downstream', waitForStart: true
              // pass parameter
             build job: 'pipeline_scm_git_job_tips_claims-Service_downstream', parameters: [string(name: 'BUILD_NUMBER', value: env.BUILD_NUMBER)]   
            }
        }

    }
    
    post {
    	always {
    		sh 'docker logout'
    	}
    
    }
    
    
}
