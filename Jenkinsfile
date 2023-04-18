pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout your source code from your version control system
                git 'https://github.com/your-username/your-repo.git'
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
