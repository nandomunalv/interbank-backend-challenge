FROM centos:7

RUN yum install -y java-1.8.0-openjdk

VOLUME /tmp

COPY "./target/reto-backend-interbank-0.0.1-SNAPSHOT.jar" "reto-backend-interbank.jar"

ENTRYPOINT ["java","-jar","reto-backend-interbank.jar"]
