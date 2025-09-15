# Sử dụng image base có Gradle và JDK 21
FROM gradle:8.10-jdk21 AS build

# Cài đặt Chrome và ChromeDriver
USER root
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    curl \
    unzip \
    --no-install-recommends \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && CHROMEVER=$(google-chrome --version | sed 's/.* \([0-9]*\.[0-9]*\.[0-9]*\.[0-9]*\).*/\1/' || echo "114.0.5735.90") \
    && DRIVERVER=$(curl -s "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$CHROMEVER" || echo "114.0.5735.90") \
    && wget -q --continue -P /usr/local/bin https://chromedriver.storage.googleapis.com/$DRIVERVER/chromedriver_linux64.zip \
    && unzip /usr/local/bin/chromedriver_linux64.zip -d /usr/local/bin/ \
    && rm /usr/local/bin/chromedriver_linux64.zip \
    && chmod +x /usr/local/bin/chromedriver \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Thiết lập thư mục làm việc
WORKDIR /app
COPY . .

# Build dự án (không chạy test)
RUN gradle clean build -x test --no-daemon

# Stage chạy test với Chrome
FROM build AS test
USER gradle
CMD ["gradle", "test", "--no-daemon"]