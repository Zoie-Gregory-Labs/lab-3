FROM maven:3.8.6-openjdk-11

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

CMD ["mvn", "exec:java", "-Dexec.mainClass=App"]
