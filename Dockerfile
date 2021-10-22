FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/*.jar shopping-cart-demo.jar
ENTRYPOINT ["sh", "-c", "java -jar /shopping-cart-demo.jar"]