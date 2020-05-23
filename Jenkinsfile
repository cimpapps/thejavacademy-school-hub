pipeline {
    agent any
    triggers {
        pollSCM '''H/2 * * * *'''
    }

    stages {
        stage(echo) {
            echo 'hello'
        }
    }
}