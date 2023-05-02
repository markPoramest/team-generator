pipeline {
    agent any
     environment {
        DOCKER_IMAGE_NAME = 'team-generator'
        DOCKER_REGISTRY_URL = 'your-docker-registry-url'
        DOCKER_REGISTRY_CREDENTIALS = 'docker-registry-credentials-id'
        DOCKER_IMAGE_TAG = "latest-${env.BUILD_NUMBER}"
      }
    stages {
        stage('Checkout') {
            steps {
                // Checkout your code from your Git repository
                echo 'Checking out code from Git'
                git branch: 'main',
                    url: 'https://github.com/markza1998/team-generator.git'
            }
        }
        stage('Unit Test') {
            steps {
                // Run your unit tests using Maven
                echo 'Running unit tests with Maven'
                sh 'mvn clean test'
            }
        }
        stage('Build') {
            steps {
                // Build your Spring Boot application using Maven
                echo 'Building with Maven'
                sh 'mvn clean install'
            }
        }
        stage("Deployment") {
            steps {
            echo "Killing the process"
            sh 'sudo -nS lsof -i :8433 || true'
            sh 'sudo -nS kill -9 `sudo -nS lsof -t -i:8433` || true'
            echo 'start spring boot'
            sh 'sudo nohup java -jar target/teamGenerator-0.0.1-SNAPSHOT.jar &'
            }
        }
        stage('Health Check') {
            steps {
                 retry(5){
                    script {
                        def ipAddress = sh(script: 'curl -sSf http://169.254.169.254/latest/meta-data/public-ipv4', returnStdout: true).trim()
                        def response = sh(script: "curl -sSf http://${ipAddress}:8443/health", returnStdout: true)
                        if (response.contains('UP')) {
                            echo 'Application is up and running'
                        } else {
                            error 'Application is not responding'
                        }
                        sleep 30000
                    }
                }
            }
        }

    }
}
