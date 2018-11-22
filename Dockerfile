FROM adoptopenjdk/openjdk8:latest
RUN mkdir /app
CMD ["java", "-cp", "app/*", "be.sourcedbvba.seed.SeedApplication"]
COPY build/dependencies/third-party /app
COPY build/dependencies/app /app
