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
                    bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-pipeline -Dsonar.projectName=jenkins-pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.login=\$SONAR_TOKEN"
                }
            }
            }
 }
}