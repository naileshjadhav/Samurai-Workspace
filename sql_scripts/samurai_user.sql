CREATE TABLE if not exists `samurai_user` (
  `user_id` bigint(20) NOT NULL,
  `user_organization` varchar(50) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_mobile` varchar(50),
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_t668lsjdqws9vgt1evkxgcpgu` (`user_organization`),
  UNIQUE KEY `UK_nv8tuqytfkcs9jf4ghu4px5j4` (`user_email`),
  UNIQUE KEY `UK_8k9wb393ps9eyy9h2246ubd7u` (`user_name`)
) ;