pipeline {
    agent any
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
        stage('Deploy') {
            steps {
                // Deploy your Spring Boot application to AWS
                echo 'Deploying to AWS'
                sh 'java -jar target/teamGenerator-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
