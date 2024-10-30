pipeline {
  agent any

  tools {
    maven "maven 3.9.9"
  }

  environment {
    WEBHOOKURL = credentials('discord')
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
      discordSend webhookURL: WEBHOOKURL,
        link: env.BUILD_URL,
        result: currentBuild.currentResult,
        title: env.BUILD_URL,
        description: env.JOB_NAME,
        footer: currentBuild.currentResult
    }
  }
}
