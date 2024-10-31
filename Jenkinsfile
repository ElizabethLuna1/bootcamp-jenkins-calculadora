pipeline {
  agent {label 'jdk21'}

  tools {
    maven "maven 3.9.9"
  }
  parameters{
    //string(name:'ENTRADA', defaultValue: 'Hola', description:'Un parametro requerido')
    //password(name:'CONTRASENIA', defaultValue: 'esta es mi contrasenia', description:'contrasenia requerida')
    string(name:'CONTRASENIA', defaultValue: 'esta es mi contrasenia', description:'contrasenia requerida')
  }  

  stages {
    stage ('ejemplo') {
      steps {
        //echo params.ENTRADA
        echo params.CONTRASENIA
      }
    }
    stage('Build') {
      steps {
        //sh  'mvn -B -q package' 
        bat 'mvn -B -q package'
      }
       post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
    }
    }
    post{
      always{
        mail to: 'eli.liza.moon@gmail.com',
          subject: env.JOB_NAME,
          body: currentBuild.currentResult + ':' + env.BUILD_URL
      }
      
    }

  }
post{
  failure{
    echo "falla..."
  }
  seccess{
    echo "éxito"
  }
  aborted{
    echo "se aborta..."
  }
  changed{
    echo "hubo cambios.."
  }
  fixed{
    echo "arreglado.."
  }
  always{
    echo "siempre se ejecuta"
  }

  
  }
}

