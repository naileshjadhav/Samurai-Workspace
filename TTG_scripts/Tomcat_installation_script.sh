#!/bin/bash

#Install Tomcat
wget https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.31/bin/apache-tomcat-9.0.31.tar.gz
sudo mkdir -p /opt/tomcat
sudo mv apache-tomcat-9.0.30.tar.gz /opt/tomcat
#sudo tar -xvzf /opt/tomcat/apache-tomcat-9.0.31.tar.gz
sudo tar -xzvf /opt/tomcat/apache-tomcat-9.0.30.tar.gz
