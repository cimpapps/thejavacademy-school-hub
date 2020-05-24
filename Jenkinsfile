def DOCKER_TAG=''

pipeline {
    agent any
    triggers {
        pollSCM '''H/2 * * * *'''
    }

    stages {
        stage('scm pull') {

            steps{
                git branch: 'master', credentialsId: 'git-creds', url: 'https://github.com/cimpapps/thejavacademy-school-hub.git'
            }
        }
        stage ('build') {
            steps {
                sh 'cd user-service; mvn clean package'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
                success {
                    archiveArtifacts 'user-service/target/*.jar'
                }
            }
        }

        stage ('docker build') {
            steps {
                script {
                    DOCKER_TAG = 'docker.io/cimbonda/user-service:$BUILD_ID-$BUILD_NUMBER'
                    println DOCKER_TAG
                    sh "cd user-service; docker build . -t ${DOCKER_TAG}"
                }
            }
        }

        stage ('docker push') {
            steps {
                sh "docker push ${DOCKER_TAG}"
            }
        }

    }
}