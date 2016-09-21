FROM java:8
VOLUME /tmp
WGET  -c "http://10.71.161.109:8081/repository/maven-public/com/pactera/pds/entity-engine/boot-entity-engine-api/1.0-SNAPSHOT/boot-entity-engine-api-1.0-20160921.023248-1.jar" -O api.jar
RUN bash -c 'touch /api.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]