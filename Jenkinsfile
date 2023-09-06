pipeline{
    agent any

    stages {
        stage ('Build') {

            steps{
                bat 'mvn clean compile install -e'
            }
        }

        stage('Test') {
            steps{
                echo 'Testing...'
            }
        }

        stage('Deply') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
