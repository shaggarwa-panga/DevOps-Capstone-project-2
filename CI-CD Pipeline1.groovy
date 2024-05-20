pipeline {
    agent { label 'testnode' }

    stages {
        stage('Git cloning') {
            steps {
                git branch: 'main',
                url: 'https://github.com/aggrawalshanky/DevOps-Capstone-project-2.git'
            }
        }

        stage ('Building a dockerimage') {
            steps {
                sh 'sudo docker rm -f $(docker ps -aq)'
                sh 'sudo docker build . -t aggrawalshanky/testimage'
                sh 'sudo docker run -d --name container1 -p 8080:80 aggrawalshanky/testimage'
                sh 'sudo docker push aggrawalshanky/testimage'
            }
        }
    }
}
