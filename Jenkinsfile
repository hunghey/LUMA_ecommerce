pipeline {
    agent any

    environment {
        JAVA_HOME = tool name: 'JDK21', type: 'jdk'  // JDK 21 đã cấu hình trong Jenkins Global Tool
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
        GRADLE_HOME = tool name: 'Gradle'            // Nếu dùng Gradle
    }

    tools {
        jdk 'JDK21'
        gradle 'Gradle'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                sh 'chmod +x gradlew' // Cấp quyền thực thi
                sh './gradlew build'  // Chạy build
            }
        }

        stage('Run Tests') {
            steps {
                sh './gradlew test'
            }
        }

//         stage('Generate Allure Report') {
//             steps {
//                 sh './gradlew allureReport'
//             }
//         }

//         stage('Publish Allure Report') {
//             steps {
//                 allure([
//                     includeProperties: false,
//                     jdk: '',
//                     results: [[path: 'build/allure-results']]
//                 ])
//             }
//         }
    }

//     post {
//         always {
//             archiveArtifacts artifacts: '**/build/reports/tests/test/*.*', allowEmptyArchive: true
//             junit 'build/test-results/test/*.xml'
//         }
//     }
}



