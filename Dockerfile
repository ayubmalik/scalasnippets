# Install centos7/java8
FROM centos:7
MAINTAINER "Ayub Malik" <ayub.malik@gmail.com>
ENV container docker

RUN yum update -y && yum -y install tar

RUN cd /tmp && \
curl --insecure --junk-session-cookies --location --remote-name --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u45-b14/jdk-8u45-linux-x64.tar.gz

RUN cd /tmp && tar -xf jdk-8u45-linux-x64.tar.gz && mv /tmp/jdk1.8.0_45 /opt
RUN ln -s /opt/jdk1.8.0_45 /opt/java
ENV JAVA_HOME /opt/java

RUN /opt/java/bin/java -version

RUN cd /tmp && \
curl --insecure --junk-session-cookies --location --remote-name http://downloads.typesafe.com/scala/2.11.6/scala-2.11.6.tgz

RUN cd /tmp && tar -xf scala-2.11.6.tgz && mv scala-2.11.6 /opt
RUN ln -s /opt/scala-2.11.6 /opt/scala
ENV SCALA_HOME /opt/scala
RUN /opt/scala/bin/scala -version

