pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/markza1998/team-generator.git'
            }
        }
        stage('Unit Test') {
            steps {
                // Run your unit tests using Maven
                sh 'mvn clean test'
            }
        }
        stage('Build') {
            steps {
                // Build your Spring Boot application using Maven
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                // Deploy your Spring Boot application using Maven
                sh 'mvn deploy'
            }
        }
    }
}
