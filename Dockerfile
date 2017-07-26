#oracle java use
#FROM isuper/java-oracle:jdk_8
FROM java:8
MAINTAINER Foy Lian <ljs2342003@gmail.com>
VOLUME /tmp
RUN wget  -c "http://10.71.161.109:8081/repository/maven-snapshots/com/pactera/pds/entity-engine/boot-entity-engine-api/1.0-SNAPSHOT/boot-entity-engine-api-1.0-20160921.073515-1.jar" -O api.jar
RUN bash -c 'touch /api.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]