# Используем официальный образ OpenJDK
FROM openjdk:17
# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app
# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
RUN mvn dependency:go-offline
# Копируем все файлы проекта
COPY . .
# Собираем JAR-файл
RUN mvn clean package -DskipTests
# Указываем команду для запуска
CMD ["java", "-jar", "target/*.jar"]
# Указываем, что приложение слушает порт 8080
EXPOSE 8080
