FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# give permission to mvnw
RUN chmod +x mvnw

# build project
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
