create schema if not exists samurai;

CREATE TABLE if not exists `samurai_service` (
  `service_id` bigint(20) NOT NULL,
  `deployment_status` tinyint(1) DEFAULT '0',
  `installation_status` tinyint(1) DEFAULT '0',
  `service_name` varchar(50) NOT NULL,
  `stage_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
);

CREATE TABLE if not exists `samurai_path` (
  `path_id` bigint(20) NOT NULL,
  `databasepath` varchar(500) DEFAULT NULL,
  `deploymentpath` varchar(500) DEFAULT NULL,
  `integrationpath` varchar(500) DEFAULT NULL,
  `path_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`path_id`)
);
