FROM adoptopenjdk/openjdk11:alpine

ENV APP_TARGET target
ENV APP grao-0.0.1-SNAPSHOT.jar

RUN mkdir -p /opt

COPY COPY ${APP_TARGET}/${APP} /opt/

EXPOSE 8080

CMD java -Xms${JAVA_XMS:-256m} -Xmx${JAVA_XMX:-512m} -jar /opt/${APP}