# Используем JDK образ
FROM openjdk:24-jdk-slim
# Рабочая директория
WORKDIR /app
# Копируем JAR файл
COPY build/libs/forum-0.0.1-SNAPSHOT.jar app.jar
# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]