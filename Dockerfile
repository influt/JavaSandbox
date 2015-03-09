FROM tomcat:7.0
MAINTAINER Mihail Agranat

ADD ./build/war/myapp.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]