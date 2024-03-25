/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - healthmonitoringiot
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `healthmonitoringiot`;

USE `healthmonitoringiot`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `patienttable` */

DROP TABLE IF EXISTS `patienttable`;

CREATE TABLE `patienttable` (
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `fullname` varchar(50) default NULL,
  `mobile` varchar(50) default NULL,
  `doctorname` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `patienttable` */

insert into `patienttable` (`username`,`password`,`fullname`,`mobile`,`doctorname`) values ('selva','java','selvakumar','9750999918','siva');
insert into `patienttable` (`username`,`password`,`fullname`,`mobile`,`doctorname`) values ('sss','sss','sss','9750999918','sss');

SET SQL_MODE=@OLD_SQL_MODE;