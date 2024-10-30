pipeline {
  agent any

  tools {
    maven "maven 3.9.9"
  }

  environment {
    WEBHOOKURL = credentials('discord')
  }

  stages {
    parallel {
      stage('node') {
        steps {
          echo 'hola'
        }
      }
      stage('Build21') {
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
    stage('fuera de') {
      steps {
        echo 'esta fuera'
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
