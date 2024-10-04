# Sử dụng image chính thức của Maven để build ứng dụng
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy file pom.xml và tải về các dependencies cần thiết
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy toàn bộ mã nguồn dự án vào container
COPY src ./src

# Build dự án và đóng gói thành file JAR
RUN mvn clean package -DskipTests

# Sử dụng image chính thức của OpenJDK để chạy ứng dụng
FROM eclipse-temurin:21-jdk-alpine

# Đặt thư mục làm việc cho container runtime
WORKDIR /app

# Copy file JAR từ quá trình build trước vào container runtime
COPY --from=build /app/target/spring-advanced-0.0.1-SNAPSHOT.jar ./app.jar

# Expose port 8080
EXPOSE 8080

# Chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
