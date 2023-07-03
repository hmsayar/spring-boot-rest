
FROM openjdk:20-jdk-slim


# Change the working directory in the image to /app
WORKDIR /app

# Copy the application's jar file (built with the maven package command) into the image
COPY ./target/usermovie-0.0.1-SNAPSHOT.jar /app/usermovie.jar
EXPOSE 8080
# Run the jar file
ENTRYPOINT ["java","-jar","/app/usermovie.jar"]
