FROM openjdk:18
EXPOSE 8080
ADD target/address-book-spring-boot.jar address-book-spring-boot.jar
ENTRYPOINT ["java", "-jar", "address-book-spring-boot.jar"]