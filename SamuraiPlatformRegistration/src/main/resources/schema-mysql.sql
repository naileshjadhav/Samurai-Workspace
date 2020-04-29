create schema if not exists samurai;
use samurai;
CREATE TABLE if not exists `samurai_user` (
  `user_id` bigint(50) NOT NULL,
  `user_password` varchar(500) NOT NULL,
  `user_organisation` varchar(100) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_mobile` varchar(20),
  `registration_date` datetime,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_t668lsjdqws9vgt1evkxgcpgu` (`user_organisation`),
  UNIQUE KEY `UK_nv8tuqytfkcs9jf4ghu4px5j4` (`user_email`),
  UNIQUE KEY `UK_8k9wb393ps9eyy9h2246ubd7u` (`user_name`)
) ;
