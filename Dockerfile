FROM openjdk:8-jdk-slim
COPY "./target/reto-backend-interbank-0.0.1-SNAPSHOT.jar" "reto-backend-interbank.jar"
CMD ["java","-jar","reto-backend-interbank.jar"]
