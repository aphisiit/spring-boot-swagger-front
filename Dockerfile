### Frontend ###
FROM java:8
EXPOSE 8080
ADD target/swagger-front-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","app.war"]