# Start with base image contaning Java runtime
FROM openjdk:17

# Information around who maintains the image
MAINTAINER tuneprotect.com

# Add the application's jar to the container
COPY target/tips_claim_service_stub-0.0.1-SNAPSHOT.jar tips_claim_service_stub-0.0.1-SNAPSHOT.jar

# execute the application
ENTRYPOINT ["java","-jar","tips_claim_service_stub-0.0.1-SNAPSHOT.jar"] 