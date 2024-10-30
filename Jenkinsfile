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
  }

  post {
    always {
      mail to: 'eli.liza.moon@gmail.com, josepp0117@gmail.com, pietromineralle@gmail.com, kiregon@gmail.com, ing.armandohb@gmail.com, lreyeso1001@gmail.com',
        subject: env.JOB_NAME,
        body: currentBuild.currentResult + ': ' + env.BUILD_URL
    }
  }

}
