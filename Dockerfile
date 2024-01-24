For reasons i can't tell, i no fit raise pr but see the new content of the Dockerfile

FROM public.ecr.aws/docker/library/maven:3.6-jdk-11 AS build

COPY src /app/src

WORKDIR /app

COPY pom.xml /app


RUN mvn clean install -DskipTests




FROM public.ecr.aws/docker/library/maven:3.6-jdk-11

WORKDIR /app
COPY .env /app


COPY --from=build /app/target/spring-security-jpa-0.0.1-SNAPSHOT.jar security-app.jar
EXPOSE 80

ENTRYPOINT ["java", "-jar", "security-app.jar"]