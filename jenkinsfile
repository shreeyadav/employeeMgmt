pipeline {
    agent any

    environment {
        PROJECT_NAME = 'employeeMgmt'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Checked out branch: ${env.BRANCH_NAME}"
            }
        }

        stage('Build') {
            steps {
                echo "Building ${env.PROJECT_NAME} on branch ${env.BRANCH_NAME}"
                // Add your build commands here
            }
        }

        stage('Test') {
            steps {
                echo "Running tests for ${env.PROJECT_NAME}"
                // Add your test commands here
            }
        }

        stage('Deploy') {
            when {
                branch 'main'
            }
            steps {
                echo "Deploying ${env.PROJECT_NAME} to production"
                // Add production deployment steps here
            }
        }

        stage('Staging Deploy') {
            when {
                branch 'dev'
            }
            steps {
                echo "Deploying ${env.PROJECT_NAME} to staging"
                // Add staging deployment steps here
            }
        }
    }

    post {
        always {
            echo "Pipeline completed for branch: ${env.BRANCH_NAME}"
        }
    }
}
