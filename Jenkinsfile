pipeline {
    agent {
        label 'win'  // Chỉ định agent với label "win"
    }

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
                // Trên Windows, dùng bat thay vì sh. Chạy gradlew.bat trực tiếp (không cần chmod)
                bat 'gradlew.bat build'  // Hoặc nếu dùng Gradle tool: bat "${GRADLE_HOME}/bin/gradle.bat build"
            }
        }

        stage('Run Tests') {
            steps {
                bat './gradlew test'
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




