#!/bin/bash -x
DB_USER='root';
DB_PASSWD='root';
DB_NAME='samurai';
TABLE='samurai_service';

serviceId=null
RANDOM=$$
for i in `seq 100`
do
	serviceId=$RANDOM
done
deploymentStatus=null
#installationStatus=null
serviceName=null
#stageName=null

#logic to set python values
if [ ! -z "$(python3.6 --version)" ]; then
  deploymentStatus=1
  serviceName=python3.6
fi

echo 'deploymentStatus found :' $deploymentStatus
echo 'serviceName found :' $serviceName
serviceId=$((serviceId+1))
echo 'serviceId :' $serviceId

#mysql commands
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME << EOF
INSERT INTO $TABLE (service_id,deployment_status,service_name) VALUES ($serviceId,$deploymentStatus,"$serviceName");
EOF

#logic to set mongodb values
if [ ! -z "$(mongod --version)" ]; then
 deploymentStatus=1
 serviceName=mongodb
fi

echo 'deploymentStatus found :' $deploymentStatus
echo 'serviceName found :' $serviceName
serviceId=$((serviceId+1))
echo 'serviceId :' $serviceId

#mysql commands
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME << EOF
INSERT INTO $TABLE (service_id,deployment_status,service_name) VALUES ($serviceId,$deploymentStatus,"$serviceName");
EOF

#logic to set mysql values
if [ ! -z "$(mysqld --version)" ]; then
 deploymentStatus=1
 serviceName=mysql
fi

echo 'deploymentStatus found :' $deploymentStatus
echo 'serviceName found :' $serviceName
serviceId=$((serviceId+1))
echo 'serviceId :' $serviceId

#mysql commands
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME << EOF
INSERT INTO $TABLE (service_id,deployment_status,service_name) VALUES ($serviceId,$deploymentStatus,"$serviceName");
EOF


#logic to set tomcat values
if [ ! -z "$(which tomcat)" ]; then
 deploymentStatus=1
 serviceName=tomcat
fi

echo 'deploymentStatus found :' $deploymentStatus
echo 'serviceName found :' $serviceName
serviceId=$((serviceId+1))
echo 'serviceId :' $serviceId

#mysql commands
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME << EOF
INSERT INTO $TABLE (service_id,deployment_status,service_name) VALUES ($serviceId,$deploymentStatus,"$serviceName");
EOF

#logic to set java values
if [ ! -z "$(which java)" ]; then
 deploymentStatus=1
 serviceName=java
fi

echo 'deploymentStatus found :' $deploymentStatus
echo 'serviceName found :' $serviceName
serviceId=$((serviceId+1))
echo 'serviceId :' $serviceId

#mysql commands
mysql --user=$DB_USER --password=$DB_PASSWD $DB_NAME << EOF
INSERT INTO $TABLE (service_id,deployment_status,service_name) VALUES ($serviceId,$deploymentStatus,"$serviceName");
EOF
