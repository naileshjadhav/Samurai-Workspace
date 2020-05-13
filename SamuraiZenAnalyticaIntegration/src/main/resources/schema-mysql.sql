create schema if not exists samurai;
use samurai;
CREATE TABLE if not exists `samurai_rpa` (
  `samurai_rpa_id` bigint NOT NULL AUTO_INCREMENT,
  `eform_id` bigint DEFAULT NULL,
  `eform_status_by_platform` varchar(50) DEFAULT NULL,
  `eform_status_update_date` datetime(6) DEFAULT NULL,
  `impact` varchar(20) DEFAULT NULL,
  `platform_remarks` varchar(100) DEFAULT NULL,
  `request_date_time` datetime(6) DEFAULT NULL,
  `severity` varchar(10) DEFAULT NULL,
  `type_of_request` varchar(20) DEFAULT NULL,
  `user_email` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `zeva_request_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`samurai_rpa_id`)
);

CREATE TABLE if not exists `samurai_analytica` (
  `samurai_analytica_id` bigint NOT NULL AUTO_INCREMENT,
  `db_connection_url` varchar(100) DEFAULT NULL,
  `resolution_id` bigint DEFAULT NULL,
  `resolution_platform` varchar(100) DEFAULT NULL,
  `resolution_rank` bigint DEFAULT NULL,
  `resolution_response` varchar(5000) DEFAULT NULL,
  `solution_type` varchar(50) DEFAULT NULL,
  `samurai_rpa_id` bigint DEFAULT NULL,
  PRIMARY KEY (`samurai_analytica_id`),
  KEY `FKdwjrdfosu9sij0w79xpk44oon` (`samurai_rpa_id`),
  CONSTRAINT `FKdwjrdfosu9sij0w79xpk44oon` FOREIGN KEY (`samurai_rpa_id`) REFERENCES `samurai_rpa` (`samurai_rpa_id`)
);


