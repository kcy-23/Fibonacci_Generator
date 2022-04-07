FROM node as client
WORKDIR /client
COPY client .
RUN npm ci
RUN npm run-script build
FROM maven:3.6.3-jdk-11 as server
WORKDIR /server
COPY server .
RUN mkdir -p src/main/resources/static
COPY --from=client /client/build src/main/resources/static
RUN mvn clean verify
FROM openjdk:14-jdk-alpine
COPY --from=server /server/target/server.jar ./app.jar
EXPOSE 8080
RUN adduser -D user
USER user
CMD ["sh", "-c", "java -Dserver.port=$PORT -Djava.security.egd=file:/dev/./urandom -jar app.jar"]