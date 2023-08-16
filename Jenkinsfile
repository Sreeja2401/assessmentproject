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
           bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-pipeline -Dsonar.projectName=jenkins-pipeline -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_206e5cc7eaf759b2444c23cd78db5eeffe1ef711"
       }
   }

 }
}