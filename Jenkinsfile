pipeline {
    agent any
    stages {
        stage('Checkout') { 
            steps {
                sh 'echo checkout'
            }
        }
        stage('Build') { 
            steps {
                sh 'echo build'
                dir('backend') {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew test'    
                }
                jacoco()
                junit stdioRetention: '', testResults: '**/build/test-results/test/*.xml'
                nodejs('NodeJS 24.11.1') {
                    dir('frontend') {
                        sh 'npm install'
                        sh 'npm run lint:html'                    
                    }
                }
                withCredentials([string(credentialsId: 'Sonarqube-Backend', variable: 'TOKEN')]) {
                    dir('backend') {
                        sh './gradlew sonar -Dsonar.projectKey=DevOpsDemo-Backend -Dsonar.projectName=\'DevOpsDemo-Backend\' -Dsonar.host.url=http://sonarqube:9000 -Dsonar.token=$TOKEN'    
                    }                    
                }
                withCredentials([string(credentialsId: 'Sonarqube-Frontend', variable: 'TOKEN')]) {
                    dir('frontend') {
                        sh 'npx sonar-scanner -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=DevOpsDemo-Frontend -Dsonar.projectName=\'DevOpsDemo-Frontend\' -Dsonar.token=$TOKEN'    
                    }                    
                }
            }
        }
        stage('Docker') {
            steps {
                sh '''
                    export DOCKER_HOST=tcp://172.17.0.2:2375
                    docker build -t cavaszil/devopsdemo .
                '''
            }
        }
    }
}