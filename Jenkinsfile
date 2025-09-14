pipeline {
    agent {
        label 'win'  // Chỉ định agent với label "win"
    }

    environment {
        JAVA_HOME = tool name: 'JDK21', type: 'jdk'  // JDK 21 đã cấu hình trong Jenkins Global Tool
        PATH = "${JAVA_HOME}\\bin:${env.PATH}"
        GRADLE_HOME = tool name: 'Gradle'            // Nếu dùng Gradle
        ALLURE_HOME = tool name: 'Allure', type: 'allure'
    }

    tools {
        jdk 'JDK21'
        gradle 'Gradle'
        allure 'Allure'
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

       stage('Generate Allure Report') {
            steps {
                // Chạy lệnh Allure để tạo và mở báo cáo
                bat """
                    ${ALLURE_HOME}\\bin\\allure.bat generate allure-results --clean -o allure-report
                    ${ALLURE_HOME}\\bin\\allure.bat open allure-report
                """
            }
        }

    }

    post {
        always {
            // Xuất báo cáo Allure trên Jenkins
            allure includeProperties: false, jdk: '', results: [[path: 'allure-report']]
            cleanWs()
        }
    }
}






