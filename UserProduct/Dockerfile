FROM openjdk

WORKDIR usr/lib

ADD ./target/UserProduct-0.0.1-SNAPSHOT.jar /usr/lib/UserProduct-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","UserProduct-0.0.1-SNAPSHOT.jar"]