FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/hospitalProject-0.0.1-SNAPSHOT.jar /app/hospitalProject.jar

#EXPOSE 9002

CMD ["java", "-jar", "/app/hospitalProject.jar"]