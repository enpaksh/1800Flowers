FROM openjdk:8
ADD  target/docker-1800flowers.jar docker-1800flowers.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-1800flowers.jar"]