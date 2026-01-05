pipeline {
    agent any

    tools {
        jdk 'JDK-17'          // must match Jenkins Global Tool Configuration
        maven 'Maven-3.9.6'   // must match Jenkins Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Thejaswini079/employee-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQube') {  // name must match Jenkins SonarQube server config
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}
