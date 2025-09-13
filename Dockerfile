FROM gradle:8.10-jdk21 AS build

WORKDIR /app
COPY . .

# Chỉ build, không test
RUN gradle clean build -x test --no-daemon

# Khi run container mới chạy test
CMD ["gradle", "test", "--no-daemon"]