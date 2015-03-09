FROM tomcat:7.0
MAINTAINER Mihail Agranat

ADD ./build/jar/MyTestJavaProject.jar /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]