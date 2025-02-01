pipeline {
    agent any

    stages {
        stage('Create Namespace') {
            steps {
                script {
                    // Write the namespace YAML to a file
                    writeFile file: 'namespace.yaml', text: '''
apiVersion: v1
kind: Namespace
metadata:
  name: test-namespace
'''

                    // Apply the namespace YAML using kubectl
                    sh 'kubectl apply -f namespace.yaml'
                }
            }
        }
    }
}