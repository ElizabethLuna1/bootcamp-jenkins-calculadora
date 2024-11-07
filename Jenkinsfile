pipeline {
  agent any
  //agent { label 'jdk21' }
  /*
  environment {
    WEBHOOKURL = credentials('discord-webhook')
  }
  */
  
   tools {
      maven "maven 3.9.9"
   }
  
   parameters {
      string(name: 'ENTRADA', defaultValue:'hola', description:'Parametro requerido')
   }

  stages {
    /*
    stage ('JAVA 8') {
      agent {
        label 'jdk8'
      }
      steps {
        echo "Esto es java 8"
      }
    }
    */
    
    stage ('Ejemplo') {
      /*
      agent {
        label 'jdk21'
      }
      */
      steps {
        echo params.ENTRADA
      }
    }
    stage('Deploy') {
        steps {
            /*bat 'D:\devenv\CURSO-GIT-PRUEBAS\apache-tomcat-9.0.96_2\bin\shutdown.bat'*/
            bat 'copy target\\ROOT.war D:\devenv\CURSO-GIT-PRUEBAS\apache-tomcat-9.0.96_2'+ params.DEPLOY_ENVIRONMENT +'\\webapps'
            /*bat 'D:\devenv\CURSO-GIT-PRUEBAS\apache-tomcat-9.0.96_2\bin\startup.bat'*/
        }
    } 
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
    failure {
      echo "Cuando falla"
    }
    success {
      echo "Se ejecuto con exito"
    }
    aborted {
      echo "El job se aborto"
    }
    changed {
      echo "Cambió"
    }
    fixed {
      echo "Arreglado"
    }
    always {
      echo "Siempre se ejecuta"
    }
  }
}


 /*
  stages {
    paralel {
      stage ('JAVA 8') {
        agent {
          label 'jdk8'
        }
        steps {
          echo "Esto es java 8"
        }
      }
      stage ('JAVA 21') {
        agent {
          label 'jdk21'
        }
        steps {
          echo "Esto es java 21"
        }
      }
    }
  }
  */
    
/*
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
    */
    
/*
    post {
      always {
        mail to: 'madrigal.bd@gmail.com, davidmadrigalbuendia@gmail.com',
          subject: env.JOB_NAME,
          body: currentBuild.currentResult + ': ' + env.BUILD_URL
      }
    }
*/
