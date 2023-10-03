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
            steps {
	    		withSonarQubeEnv('sonarcube') {	    		    
	      			sh 'mvn sonar:sonar'
	      			//sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar -X'
	      			//sh 'sleep 50'
	    		}
            }
        }
        
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }	   
	   
                
        stage ('Build Image...') {
            steps{
                  sh 'docker build -t indikak2005/tips_claims_service:latest . '
                //sh 'docker build -t indikak2005/tips_claims_service:$BUILD_NUMBER . '
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
                sh 'docker push indikak2005/tips_claims_service:latest '
                //sh 'docker push indikak2005/tips_claims_service:$BUILD_NUMBER '
            }
        }             

        stage('Cont. Deployment') {
            steps{
              // include this if you need any interval  
              //  build quietPeriod: 5, job: 'pipeline_scm_git_job_tips_claims-Service_downstream', waitForStart: true
              // pass parameter
             build job: 'ansible_deployment', parameters: [string(name: 'BUILD_NUMBER', value: env.BUILD_NUMBER)]   
            }
        }

    }
    
    post {
    	always {
    		sh 'docker logout'
    	}
    
    }
    
    
}
