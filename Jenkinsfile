pipeline {
  agent {
    node {
      label 'agent any'
    }

  }
  stages {
    stage('Prueba 1') {
      steps {
        echo 'Probando....'
        writeFile(file: 'texto1.txt', text: 'escrubiendo desde jenkins', encoding: 'UTF-8')
      }
    }
    stage('Finalizar') {
      agent {
        node {
          label 'n2'
        }

      }
      steps {
        pwd(tmp: true)
      }
    }
  }
}