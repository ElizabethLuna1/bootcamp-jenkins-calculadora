pipeline {
  agent any

  tools {
    maven "maven 3.9.9"
  }

  stages {
    stage('Build') {
      steps {
        //sh  'mvn -B -q package' 
        bat 'mvn -B -q package'
      }
    }
    post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
    }
  }

}
