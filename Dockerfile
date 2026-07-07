# Sử dụng JDK 17 (hoặc đổi thành 21 tùy phiên bản Java bạn đang dùng)
FROM eclipse-temurin:17-jdk-alpine

# Thư mục làm việc trong container
WORKDIR /app

# Copy file .jar sau khi build vào trong container
COPY target/*.jar app.jar

# Mở cổng 8080
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]