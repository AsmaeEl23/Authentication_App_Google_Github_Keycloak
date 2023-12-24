#image openjdk
FROM openjdk:17
VOLUME /tmp
#copy the jar file from target to docker with the name app.jar, so in the docker we will find the image ad the app
COPY target/*.jar  app.jar
#To execute the app (jave -jar app.jar) manually
ENTRYPOINT ["java","-jar", "app.jar"]