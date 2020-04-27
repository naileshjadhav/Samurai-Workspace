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
#sudo vi /home/tomcat.service_new
cat <<EOF >/home/tomcat.service_new
[Unit]
Description=Apache Tomcat Web Application Container
After=network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms1024M -Xmx5120M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/opt/tomcat/bin/shutdown.sh

User=ttg-n
Group=ttg-n
UMask=0007
RestartSec=10
Restart=on-failure
KillMode=process


[Install]
WantedBy=multi-user.target
EOF
sudo systemctl daemon-reload
#Start the Tomcat service by executing:
sudo systemctl start tomcat
#Check the service status with the following command:
sudo systemctl status tomcat