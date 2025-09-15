pipeline {
    agent {
        label 'win'
    }
    parameters {
        string(name: 'DOCKER_HUB_USER', defaultValue: 'hunghey', description: 'Docker Hub username')
        string(name: 'DOCKER_IMAGE_NAME', defaultValue: 'luma-java-test', description: 'Docker image name')
    }
    environment {
        JAVA_HOME = tool name: 'JDK21', type: 'jdk'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
        ALLURE_HOME = tool name: 'Allure', type: 'allure'
        DOCKER_HUB_USER = "${params.DOCKER_HUB_USER}"
        DOCKER_IMAGE_NAME = "${params.DOCKER_IMAGE_NAME}"
        DOCKER_PASSWORD = credentials('docker-hub-password')
    }
    tools {
        jdk 'JDK21'
        allure 'Allure'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Project') {
            steps {
                bat 'gradlew.bat clean build -x test'  // Build trên Windows
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat """
                        docker build -t ${DOCKER_HUB_USER}/${DOCKER_IMAGE_NAME}:latest .
                    """
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    bat """
                        docker login -u ${DOCKER_HUB_USER} -p ${DOCKER_PASSWORD}
                        docker push ${DOCKER_HUB_USER}/${DOCKER_IMAGE_NAME}:latest
                    """
                }
            }
        }
        stage('Run Tests in Docker') {
            steps {
                script {
                    bat """
                        docker run --rm ${DOCKER_HUB_USER}/${DOCKER_IMAGE_NAME}:latest
                    """
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                bat """
                    "${ALLURE_HOME}\\bin\\allure.bat" generate allure-results --clean -o allure-report
                """
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'allure-report']]
            cleanWs()
        }
    }
}