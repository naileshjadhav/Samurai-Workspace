#Create Tomcat User
groupadd ttg-n
sudo useradd -r -m -U -d /opt/tomcat -s /bin/false ttg-n
#Update permissions to Tomcat
sudo chgrp -R tomcat /opt/tomcat
cd /opt/tomcat/apache-tomcat-9.0.30
sudo chmod -R g+r conf
sudo chmod g+x conf
sudo chown -R tomcat webapps/ work/ temp/ logs/
#Created a systemd Unit File as tomcat_service
#Save and close the tomcat_service file and notify systemd that we created a new unit file as below
sudo vim /etc/systemd/system/tomcat.service
sudo systemctl daemon-reload
#Start the Tomcat service by executing:
sudo systemctl start tomcat
#Check the service status with the following command:
sudo systemctl status tomcat