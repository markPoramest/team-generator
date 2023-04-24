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
            sh 'nohup ./mvnw spring-boot:run -Dserver.port=8001 &'
        }
    }
}
