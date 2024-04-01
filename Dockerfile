FROM amazoncorretto:21
COPY target/pokemon-challenge-1.0.0.jar pokemon-challenge-1.0.0.jar
ENTRYPOINT ["java","-jar","/pokemon-challenge-1.0.0.jar"]