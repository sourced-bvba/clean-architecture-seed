FROM adoptopenjdk/openjdk8:latest
RUN mkdir /app
CMD ["java", "-cp", "app/*", "be.sourcedbvba.seed.SeedApplication"]
COPY target/dependencies/third-party /app
COPY target/dependencies/app/* target/*.jar /app/
