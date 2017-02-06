-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema OYOSERVICE
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `OYOSERVICE` ;

-- -----------------------------------------------------
-- Schema OYOSERVICE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OYOSERVICE` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema oyoservice
-- -----------------------------------------------------
SHOW WARNINGS;
USE `OYOSERVICE` ;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`CustomerDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`CustomerDetail` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`CustomerDetail` (
  `id` INT NOT NULL COMMENT '',
  `firstname` VARCHAR(45) NULL COMMENT '',
  `lastname` VARCHAR(45) NULL COMMENT '',
  `emailid` VARCHAR(45) NULL COMMENT '',
  `contactno` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`servicecenter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`servicecenter` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`servicecenter` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `houseno` VARCHAR(45) NULL COMMENT '',
  `street` VARCHAR(45) NULL COMMENT '',
  `place` VARCHAR(45) NULL COMMENT '',
  `city` VARCHAR(45) NULL COMMENT '',
  `state` VARCHAR(45) NULL COMMENT '',
  `pincode` VARCHAR(45) NULL COMMENT '',
  `emailid` VARCHAR(45) NULL COMMENT '',
  `mobileno` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`vehicaltype`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`vehicaltype` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`vehicaltype` (
  `id` INT NOT NULL COMMENT '',
  `type` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`manufacture`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`manufacture` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`manufacture` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `logo` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`modal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`modal` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`modal` (
  `id` INT NOT NULL COMMENT '',
  `modalname` VARCHAR(45) NULL COMMENT '',
  `image` VARCHAR(45) NULL COMMENT '',
  `manufacture_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `manufacture_id`)  COMMENT '',
  INDEX `fk_modal_manufacture1_idx` (`manufacture_id` ASC)  COMMENT '',
  CONSTRAINT `fk_modal_manufacture1`
    FOREIGN KEY (`manufacture_id`)
    REFERENCES `OYOSERVICE`.`manufacture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`variant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`variant` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`variant` (
  `id` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  `modal_id` INT NOT NULL COMMENT '',
  `modal_manufacture_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `modal_id`, `modal_manufacture_id`)  COMMENT '',
  INDEX `fk_variant_modal1_idx` (`modal_id` ASC, `modal_manufacture_id` ASC)  COMMENT '',
  CONSTRAINT `fk_variant_modal1`
    FOREIGN KEY (`modal_id` , `modal_manufacture_id`)
    REFERENCES `OYOSERVICE`.`modal` (`id` , `manufacture_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`service_feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`service_feedback` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`service_feedback` (
  `id` INT NOT NULL COMMENT '',
  `serviceid` VARCHAR(45) NULL COMMENT '',
  `rating` INT NULL COMMENT '',
  `comments` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`deal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`deal` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`deal` (
  `id` INT NOT NULL COMMENT '',
  `dealtype` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  `image` VARCHAR(45) NULL COMMENT '',
  `startdate` DATE NULL COMMENT '',
  `enddate` DATE NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`bookservice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`bookservice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`bookservice` (
  `id` INT NOT NULL COMMENT '',
  `bookingId` VARCHAR(45) NULL COMMENT '',
  `manufacture_id` VARCHAR(45) NULL COMMENT '',
  `vechicleType` VARCHAR(45) NULL COMMENT '',
  `model` VARCHAR(45) NULL COMMENT '',
  `variant` VARCHAR(45) NULL COMMENT '',
  `bookingdate` VARCHAR(45) NULL COMMENT '',
  `status` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  `estdeliveryTime` VARCHAR(45) NULL COMMENT '',
  `service_feedback_id` INT NOT NULL COMMENT '',
  `deal_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`, `service_feedback_id`, `deal_id`)  COMMENT '',
  INDEX `fk_bookservice_service_feedback1_idx` (`service_feedback_id` ASC)  COMMENT '',
  INDEX `fk_bookservice_deal1_idx` (`deal_id` ASC)  COMMENT '',
  CONSTRAINT `fk_bookservice_service_feedback1`
    FOREIGN KEY (`service_feedback_id`)
    REFERENCES `OYOSERVICE`.`service_feedback` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookservice_deal1`
    FOREIGN KEY (`deal_id`)
    REFERENCES `OYOSERVICE`.`deal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`serviceType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`serviceType` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`serviceType` (
  `id` INT NOT NULL COMMENT '',
  `serviceType` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`servercenterDetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`servercenterDetails` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`servercenterDetails` (
  `image` VARCHAR(45) NULL COMMENT '',
  `status` TINYINT(1) NULL COMMENT '',
  `servercenter_id` INT NOT NULL COMMENT '',
  INDEX `fk_servercenterDetails_servicecenter1_idx` (`servercenter_id` ASC)  COMMENT '',
  PRIMARY KEY (`servercenter_id`)  COMMENT '',
  CONSTRAINT `fk_servercenterDetails_servicecenter1`
    FOREIGN KEY (`servercenter_id`)
    REFERENCES `OYOSERVICE`.`servicecenter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`vehicaltype_has_servicecenter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`vehicaltype_has_servicecenter` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`vehicaltype_has_servicecenter` (
  `vehicaltype_id` INT NOT NULL COMMENT '',
  `servicecenter_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`vehicaltype_id`, `servicecenter_id`)  COMMENT '',
  INDEX `fk_vehicaltype_has_servicecenter_servicecenter1_idx` (`servicecenter_id` ASC)  COMMENT '',
  INDEX `fk_vehicaltype_has_servicecenter_vehicaltype1_idx` (`vehicaltype_id` ASC)  COMMENT '',
  CONSTRAINT `fk_vehicaltype_has_servicecenter_vehicaltype1`
    FOREIGN KEY (`vehicaltype_id`)
    REFERENCES `OYOSERVICE`.`vehicaltype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicaltype_has_servicecenter_servicecenter1`
    FOREIGN KEY (`servicecenter_id`)
    REFERENCES `OYOSERVICE`.`servicecenter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`servicecenter_has_serviceType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`servicecenter_has_serviceType` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`servicecenter_has_serviceType` (
  `servicecenter_id` INT NOT NULL COMMENT '',
  `serviceType_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`servicecenter_id`, `serviceType_id`)  COMMENT '',
  INDEX `fk_servicecenter_has_serviceType_serviceType1_idx` (`serviceType_id` ASC)  COMMENT '',
  INDEX `fk_servicecenter_has_serviceType_servicecenter1_idx` (`servicecenter_id` ASC)  COMMENT '',
  CONSTRAINT `fk_servicecenter_has_serviceType_servicecenter1`
    FOREIGN KEY (`servicecenter_id`)
    REFERENCES `OYOSERVICE`.`servicecenter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicecenter_has_serviceType_serviceType1`
    FOREIGN KEY (`serviceType_id`)
    REFERENCES `OYOSERVICE`.`serviceType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`servicecenter_has_deal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`servicecenter_has_deal` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`servicecenter_has_deal` (
  `servicecenter_id` INT NOT NULL COMMENT '',
  `deal_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`servicecenter_id`, `deal_id`)  COMMENT '',
  INDEX `fk_servicecenter_has_deal_deal1_idx` (`deal_id` ASC)  COMMENT '',
  INDEX `fk_servicecenter_has_deal_servicecenter1_idx` (`servicecenter_id` ASC)  COMMENT '',
  CONSTRAINT `fk_servicecenter_has_deal_servicecenter1`
    FOREIGN KEY (`servicecenter_id`)
    REFERENCES `OYOSERVICE`.`servicecenter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicecenter_has_deal_deal1`
    FOREIGN KEY (`deal_id`)
    REFERENCES `OYOSERVICE`.`deal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`servicecenter_has_bookservice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`servicecenter_has_bookservice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`servicecenter_has_bookservice` (
  `servicecenter_id` INT NOT NULL COMMENT '',
  `bookservice_id` INT NOT NULL COMMENT '',
  `bookservice_service_feedback_id` INT NOT NULL COMMENT '',
  `bookservice_deal_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`servicecenter_id`, `bookservice_id`, `bookservice_service_feedback_id`, `bookservice_deal_id`)  COMMENT '',
  INDEX `fk_servicecenter_has_bookservice_bookservice1_idx` (`bookservice_id` ASC, `bookservice_service_feedback_id` ASC, `bookservice_deal_id` ASC)  COMMENT '',
  INDEX `fk_servicecenter_has_bookservice_servicecenter1_idx` (`servicecenter_id` ASC)  COMMENT '',
  CONSTRAINT `fk_servicecenter_has_bookservice_servicecenter1`
    FOREIGN KEY (`servicecenter_id`)
    REFERENCES `OYOSERVICE`.`servicecenter` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicecenter_has_bookservice_bookservice1`
    FOREIGN KEY (`bookservice_id` , `bookservice_service_feedback_id` , `bookservice_deal_id`)
    REFERENCES `OYOSERVICE`.`bookservice` (`id` , `service_feedback_id` , `deal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `OYOSERVICE`.`bookservice_has_CustomerDetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OYOSERVICE`.`bookservice_has_CustomerDetail` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`bookservice_has_CustomerDetail` (
  `bookservice_id` INT NOT NULL COMMENT '',
  `bookservice_service_feedback_id` INT NOT NULL COMMENT '',
  `bookservice_deal_id` INT NOT NULL COMMENT '',
  `CustomerDetail_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`bookservice_id`, `bookservice_service_feedback_id`, `bookservice_deal_id`, `CustomerDetail_id`)  COMMENT '',
  INDEX `fk_bookservice_has_CustomerDetail_CustomerDetail1_idx` (`CustomerDetail_id` ASC)  COMMENT '',
  INDEX `fk_bookservice_has_CustomerDetail_bookservice1_idx` (`bookservice_id` ASC, `bookservice_service_feedback_id` ASC, `bookservice_deal_id` ASC)  COMMENT '',
  CONSTRAINT `fk_bookservice_has_CustomerDetail_bookservice1`
    FOREIGN KEY (`bookservice_id` , `bookservice_service_feedback_id` , `bookservice_deal_id`)
    REFERENCES `OYOSERVICE`.`bookservice` (`id` , `service_feedback_id` , `deal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bookservice_has_CustomerDetail_CustomerDetail1`
    FOREIGN KEY (`CustomerDetail_id`)
    REFERENCES `OYOSERVICE`.`CustomerDetail` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


DROP TABLE IF EXISTS `OYOSERVICE`.`servicecenter_has_bookservice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `OYOSERVICE`.`vehicaltype_has_manufacture` (
  `vehicaltype_id` INT NOT NULL COMMENT '',
  `manufacture_id` INT NOT NULL COMMENT '')
ENGINE = InnoDB;

COMMIT;

INSERT INTO `oyoservice`.`customerdetail` (`id`, `firstname`, `lastname`, `emailid`, `contactno`) VALUES ('1', 'SAURABH', 'SHARMA', 'SAURABH.FIND@GMAIL.COM', '1234567890');
INSERT INTO `oyoservice`.`customerdetail` (`id`, `firstname`, `lastname`, `emailid`, `contactno`) VALUES ('2', 'RAHUL', 'SHARMA', 'RAHUL@GMAIL.COM', '1234567890');


INSERT INTO `oyoservice`.`manufacture` (`id`, `name`) VALUES ('1', 'Maruti');
INSERT INTO `oyoservice`.`manufacture` (`id`, `name`) VALUES ('2', 'Hero');
INSERT INTO `oyoservice`.`manufacture` (`id`, `name`) VALUES ('3', 'Honda');
INSERT INTO `oyoservice`.`manufacture` (`id`, `name`) VALUES ('4', 'Hyundi');
INSERT INTO `oyoservice`.`manufacture` (`id`, `name`) VALUES ('5', ' Bajaj');

INSERT INTO `oyoservice`.`modal` (`id`, `modalname`, `manufacture_id`) VALUES ('1', 'shift', '1');
INSERT INTO `oyoservice`.`modal` (`id`, `modalname`, `manufacture_id`) VALUES ('2', 'k 10', '1');
INSERT INTO `oyoservice`.`modal` (`id`, `modalname`, `manufacture_id`) VALUES ('3', 'wagan R', '1');

INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('1', 'Petrol', '1', '1');
INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('2', 'Disel', '1', '1');
INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('3', 'Petrol', '2', '1');
INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('4', 'Petrol', '3', '1');
INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('5', 'LPG', '3', '1');
INSERT INTO `oyoservice`.`variant` (`id`, `name`, `modal_id`, `modal_manufacture_id`) VALUES ('6', 'CNG', '3', '1');

INSERT INTO `oyoservice`.`vehicaltype` (`id`, `type`, `name`) VALUES ('1', 'Two Wheeler', 'Two Wheeler');
INSERT INTO `oyoservice`.`vehicaltype` (`id`, `type`, `name`) VALUES ('2', 'Three Wheeler', 'Three Wheeler');
INSERT INTO `oyoservice`.`vehicaltype` (`id`, `type`, `name`) VALUES ('3', 'Four Wheeler', 'Four Wheeler');

INSERT INTO `oyoservice`.`servicetype` (`id`, `serviceType`) VALUES ('1', 'Clean & Wash');
INSERT INTO `oyoservice`.`servicetype` (`id`, `serviceType`) VALUES ('2', 'Oil Filter');
INSERT INTO `oyoservice`.`servicetype` (`id`, `serviceType`) VALUES ('3', 'Dryclean');

INSERT INTO `oyoservice`.`servicecenter` (`id`, `name`, `houseno`, `street`, `place`, `city`, `state`, `pincode`, `emailid`, `mobileno`) VALUES ('1', 'Wheel Care', '107', 'shiv nager', 'jaipur', 'jaipur', 'Rajasthan', '302013', 'wheelcare@gmail.com', '1234567890');
INSERT INTO `oyoservice`.`servicecenter` (`id`, `name`, `houseno`, `street`, `place`, `city`, `state`, `pincode`, `emailid`, `mobileno`) VALUES ('2', 'GoodsCare', '290', 'New Khera', 'Bikaner', 'Bikaner', 'Rajsthan', '302011', 'goods@gmail.com', '123412341');

INSERT INTO `oyoservice`.`servicecenter_has_servicetype` (`servicecenter_id`, `serviceType_id`) VALUES ('1', '1');
INSERT INTO `oyoservice`.`servicecenter_has_servicetype` (`servicecenter_id`, `serviceType_id`) VALUES ('1', '2');
INSERT INTO `oyoservice`.`servicecenter_has_servicetype` (`servicecenter_id`, `serviceType_id`) VALUES ('1', '3');

INSERT INTO `oyoservice`.`vehicaltype_has_servicecenter` (`vehicaltype_id`, `servicecenter_id`) VALUES ('1', '1');
INSERT INTO `oyoservice`.`vehicaltype_has_servicecenter` (`vehicaltype_id`, `servicecenter_id`) VALUES ('3', '1');

INSERT INTO `oyoservice`.`service_feedback` (`id`, `serviceid`) VALUES ('1', '101');

INSERT INTO `oyoservice`.`bookservice` (`id`, `bookingId`, `manufacture_id`, `vechicleType`, `model`, `variant`, `bookingdate`, `status`, `estdeliveryTime`, `service_feedback_id`, `deal_id`) VALUES ('1', '1001', '1', '3', '1', '1', '2017-01-28 12:11:00', 'NA', '2017-01-29 12:11:00', '1', '1');

INSERT INTO `oyoservice`.`bookservice_has_customerdetail` (`bookservice_id`, `bookservice_service_feedback_id`, `bookservice_deal_id`, `CustomerDetail_id`) VALUES ('1', '1', '1', '1');


INSERT INTO `oyoservice`.`deal` (`id`, `dealtype`, `startdate`, `enddate`) VALUES ('1', '10% Discount', '2017-01-28 14:46:37', '2017-01-30 14:46:37');

INSERT INTO `oyoservice`.`servicecenter_has_deal` (`servicecenter_id`, `deal_id`) VALUES ('1', '1');


INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (1,2);
INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (1,3);
INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (1,5);

INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (2,5);

INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (3,1);
INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (3,3);
INSERT INTO `oyoservice`.`vehicaltype_has_manufacture`(`vehicaltype_id`, `manufacture_id`) VALUES (3,4);

create table user_accounts(
			id int,
			email varchar(45),
			first_name varchar(45),
			last_name varchar(45),
			password varchar(45),
			role varchar(20),
			sign_in_provider varchar(20));

INSERT INTO `oyoservice`.`user_accounts`
(`id`,
`email`,
`first_name`,
`last_name`,
`password`,
`role`,
`sign_in_provider`)
VALUES
(1,
'saurabh.find@gmail.com',
'saurabh',
'sharma',
'XXXX',
'1',
'0');

ALTER TABLE `oyoservice`.`user_accounts` 
ADD COLUMN `creation_time` DATETIME NULL COMMENT '' AFTER `sign_in_provider`,
ADD COLUMN `modification_time` DATETIME NULL COMMENT '' AFTER `creation_time`;


  
CREATE INDEX user_account_email ON user_accounts (email);

CREATE TABLE `user_role` (
  `id` INT NOT NULL COMMENT '',
  `email` VARCHAR(45) NULL COMMENT '',
  `role` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `role_email_UNIQUE` (role, email)  COMMENT '',
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `oyoservice`.`user_accounts` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
INSERT INTO `oyoservice`.`user_role` (`id`, `email`, `role`) VALUES ('1', 'saurabh.find@gmail.com', 'ADMIN');


/*All User's gets stored in APP_USER table*/
create table APP_USER (
   id BIGINT NOT NULL AUTO_INCREMENT,
   sso_id VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   email VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (sso_id)
);
   
/* USER_PROFILE table contains all possible roles */ 
create table USER_PROFILE(
   id BIGINT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
   
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_USER_PROFILE (
    user_id BIGINT NOT NULL,
    user_profile_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);
  
/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
  
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
  
INSERT INTO USER_PROFILE(type)
VALUES ('DBA');
  
  
/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email)
VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');
  
  
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM app_user user, user_profile profile
  where user.sso_id='sam' and profile.type='ADMIN';
 
/* Create persistent_logins Table used to store rememberme related stuff*/
CREATE TABLE persistent_logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);
