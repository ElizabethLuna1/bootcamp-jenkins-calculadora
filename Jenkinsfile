pipeline {
  agent any

  tools {
    maven "maven 3.9.9"
  }

  stages {
    stage('Build') {
      steps {
        bat 'mvn -B -q package'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    post {
      mail to to: 'mcnewster@gmail.com',
        subject: env.JOB_NAME,
        body: currentBuild.currentResult + ': ' + env.BUILD_URL
    }
  }

}
