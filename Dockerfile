FROM tomcat:9

RUN ["apt-get", "update"]
RUN ["apt-get", "install", "vim", "-y"] # 추후 간단한 파일 편집을 위해 컨테이너 내부에 vim 설치
RUN ["apt-get", "install", "openjdk-8-jdk", "maven", "-y"]

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY server.xml /usr/local/tomcat/conf/server.xml

# 톰캣 타임존 설정
RUN ["rm", "/etc/localtime"]
RUN ["ln", "-sf", "/usr/share/zoneinfo/Asia/Seoul", "/etc/localtime"]

RUN mvn install
RUN cp /app/target/base.war /usr/local/tomcat/webapps/ROOT.war
#ADD target/ROOT.war /usr/local/tomcat/webapps/
# EXPOSE 8081
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
