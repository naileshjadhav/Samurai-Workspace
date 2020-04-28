create schema if not exists samurai;
use samurai;
create schema if not exists samurai;
use samurai;
CREATE TABLE IF NOT EXISTS `samurai_rpa` (
    samurai_rpa_id BIGINT(10) NOT NULL AUTO_INCREMENT,
    zeva_request_id VARCHAR(20),
    user_name VARCHAR(20),
    user_email VARCHAR(20),
    request_date_time DATE,
    severity VARCHAR(10),
    impact VARCHAR(10),
    eform_id BIGINT(10),
    type_of_request VARCHAR(10),
    resolution_response  varchar(1000),
    resolution_platform varchar(50),
    solution_type varchar(50),
    eform_status_by_platform VARCHAR(20),
    eform_status_update_date DATE,
    platform_remarks VARCHAR(20),
    db_connection_url VARCHAR(50),
    PRIMARY KEY(samurai_rpa_id)
);

