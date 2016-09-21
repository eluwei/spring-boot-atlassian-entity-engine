a show case to integrate  
"atlassian entity engine(ofbiz entity engine)" with spring boot.


前置条件：
 假设需要跑的war、jar包已经ready，并且在某个地方可用。
 本例假设spring boot的包已经deploy到maven私服。
 地址:
 http://10.71.161.109:8081/repository/maven-public/com/pactera/pds/entity-engine/boot-entity-engine-api/1.0-SNAPSHOT/boot-entity-engine-api-1.0-20160921.023248-1.jar
 
 启动顺序：
 1.启动mysql (如果要开放端口使用-p 3306:3306)
 docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=Admin123 -e MYSQL_DATABASE=entity_engine -e MYSQL_USER=entity_engine -e MYSQL_PASSWORD=entity_engine -d mysql:5.6
 
 2.编译镜像，并push到docker私库
 docker build ./ 10.71.161.109:5555/demo_entity_engine
 docker push 10.71.161.109:5555/demo_entity_engine
 
 3.需要启动的机器上拉取镜像
 docker pull 10.71.161.109:5555/demo_entity_engine
 
 4.启动
 docker run -p 8080:8080 --name demo_entity_engine --link demo-mysql:mysql_db -d 10.71.161.109:5555/demo_entity_engine