/*
pipeline{
 agent any
 stages{
   stage('Build')
   {
     steps
     {
     bat "mvn clean install"
     }
   }

  stage("Sonar") {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-pipeline -Dsonar.projectName=jenkins-pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.token=\$SONAR_TOKEN"
                }
            }
            }
 }
} */
pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')
         TOMCAT_CREDENTIALS = credentials('TOMCAT_CREDENTIALS') // Use the ID of the Jenkins credential containing Tomcat credentials

    }

    stages {
        stage('Build, Test, and Generate Coverage') {
            steps {
                bat "mvn clean verify"
                bat "mvn jacoco:prepare-agent"
            }
        }
        stage('SonarQube Analysis') {
            steps {
                bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-pipeline -Dsonar.projectName='jenkins-pipeline' -Dsonar.host.url=http://localhost:9000 -Dsonar.login=%SONAR_TOKEN% -Dsonar.java.coveragePlugin=jacoco"
            }
        }
         stage('Deploy to Tomcat') {
                     steps {
                         deploy adapters: [
                             tomcat(credentialsId: 'TOMCAT_CREDENTIALS', war: '**/*.war', url: 'http://localhost:9005')
                         ]
                     }
                 }
    }
}