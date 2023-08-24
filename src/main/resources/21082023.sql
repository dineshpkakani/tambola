/*
SQLyog Ultimate v13.0.1 (64 bit)
MySQL - 8.0.32 : Database - housie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`housie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `housie`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `uid` int NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `category` */

/*Table structure for table `eventmaster` */

DROP TABLE IF EXISTS `eventmaster`;

CREATE TABLE `eventmaster` (
  `eventid` bigint NOT NULL AUTO_INCREMENT,
  `createddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delflag` int DEFAULT '0',
  `eventdate` date DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `maxtickets` int DEFAULT NULL,
  `noofusers` int DEFAULT NULL,
  `priceperticket` int DEFAULT NULL,
  `soldtickets` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createdby` bigint DEFAULT NULL,
  PRIMARY KEY (`eventid`),
  UNIQUE KEY `UK_kbmlbnklxu99n420qgx8l41um` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `eventmaster` */

insert  into `eventmaster`(`eventid`,`createddate`,`delflag`,`eventdate`,`name`,`maxtickets`,`noofusers`,`priceperticket`,`soldtickets`,`status`,`createdby`) values 
(1,'2023-08-19 00:00:00',0,'2023-08-20','26th jan 2023',5,0,20,0,'Not started',1),
(2,'2023-08-19 00:00:00',1,'2023-08-20','New Year 2023',5,0,20,0,'Not started',1),
(3,'2023-08-19 00:00:00',0,'2023-08-21','15th Aug 2023',5,0,20,0,'Not started',1);

/*Table structure for table `eventprizeconfigure` */

DROP TABLE IF EXISTS `eventprizeconfigure`;

CREATE TABLE `eventprizeconfigure` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `prizevalue` int DEFAULT NULL,
  `sequence` int DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `prize_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdn9c1hi7bgci1lby43vd89ab2` (`event_id`),
  KEY `FK2x667q4dg5c3lm3se78uikowg` (`prize_id`),
  CONSTRAINT `FK2x667q4dg5c3lm3se78uikowg` FOREIGN KEY (`prize_id`) REFERENCES `prizemaster` (`prizeid`),
  CONSTRAINT `FKdn9c1hi7bgci1lby43vd89ab2` FOREIGN KEY (`event_id`) REFERENCES `eventmaster` (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `eventprizeconfigure` */

insert  into `eventprizeconfigure`(`id`,`prizevalue`,`sequence`,`event_id`,`prize_id`) values 
(1,50,1,1,1),
(2,50,2,1,1),
(6,10,1,1,2);

/*Table structure for table `eventprizewinningdetail` */

DROP TABLE IF EXISTS `eventprizewinningdetail`;

CREATE TABLE `eventprizewinningdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `eventid` int NOT NULL,
  `prizedid` int NOT NULL,
  `prizeseq` int NOT NULL,
  `prizevalue` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `eventprizewinningdetail` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(1);

/*Table structure for table `prizemaster` */

DROP TABLE IF EXISTS `prizemaster`;

CREATE TABLE `prizemaster` (
  `prizeid` bigint NOT NULL AUTO_INCREMENT,
  `imagename` varchar(255) DEFAULT NULL,
  `prizename` varchar(255) DEFAULT NULL,
  `rules` varchar(255) DEFAULT NULL,
  `delflag` int DEFAULT '0',
  PRIMARY KEY (`prizeid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `prizemaster` */

insert  into `prizemaster`(`prizeid`,`imagename`,`prizename`,`rules`,`delflag`) values 
(1,'fullhouse_tambola.png','Full House','To get a full house award, you must check off every number on your ticket.\r\n\r\n',0),
(2,'topline_tambola.png','Top Line\r\n','To get the top line award, you must check off every number on the top line of your ticket.',0),
(3,'middleline_tambola.png','Middle Line\r\n','To get the middle line award, you must check off every number on the middle line of your ticket.',0),
(4,'bottomline_tambola.png','Bottom Line','To get the bottom line award, you must check off every number on the bottom line of your ticket.',0),
(5,'corners_tambola.png','Corners','To get the corners award, you must check off the first and last number of the top and bottom rows.',0),
(6,'early5_tambola.png','Early 5','To get the early 5 award, be the first person in the game to check off any 5 numbers on your ticket.',0),
(7,'breakfast_tambola.png','Breakfast','To get the breakfast award, you must check off every number in the left most 3 columns (columns 1, 2, and 3).',0),
(8,'lunch_tambola.png','Lunch','To get the lunch award, you must check off every number in the middle 3 columns (columns 4, 5, and 6).',0),
(9,'dinner_tambola.png','Dinner','To get the dinner award, you must check off every number in the right most 3 columns (columns 7, 8, and 9).',0),
(10,'bamboo_tambola.png','Bamboo','To get the bamboo (rod) award, you must check off the middle number in each column (3rd number in each column).',0),
(11,'major_tambola.png','Major','To get the Major award, you must CHECK off ALL higher number of 50.',0),
(12,'minor_tambola.png','Minor','To get the Major award, you must CHECK off ALL LOWER number of 50.',0),
(13,'pyramid_tambola.png','Pyramid','To get the Pyramid award, you must CHECK off, Top Row: 3rd Number; Middle Row: 2nd, 4th',0),
(14,'unlucky_tambola.png','Unlucky','To get the Unlucky award, you must NONE of CHECK off',0),
(15,'ladoo_tambola.png','Laddu','To get the Laddu award, you must CHECK off Middle ROW: 3rd Number',0),
(16,'odds_tambola.png','Odds','To get the Odds award, you must CHECK off ALL Odd numbers',0),
(17,'evens_tambola.png','Evens','To get the Odds award, you must CHECK off ALL Even numbers',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values 
(1,'USER');

/*Table structure for table `tickets` */

DROP TABLE IF EXISTS `tickets`;

CREATE TABLE `tickets` (
  `uid` int NOT NULL,
  `category` int NOT NULL,
  `currentticket` varchar(255) NOT NULL,
  `empcode` int NOT NULL,
  `generate_date` datetime NOT NULL,
  `orgticket` varchar(255) NOT NULL,
  `result` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tickets` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` bigint NOT NULL AUTO_INCREMENT,
  `enabled` tinyint(1) DEFAULT '1',
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users` */

insert  into `users`(`userid`,`enabled`,`password`,`roles`,`username`) values 
(1,1,'dinesh','ROLE_ADMIN','dinesh');

/*Table structure for table `winnerinfo` */

DROP TABLE IF EXISTS `winnerinfo`;

CREATE TABLE `winnerinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `eventid` int NOT NULL,
  `prizedid` int NOT NULL,
  `winnerid` int NOT NULL,
  `prizeseq` int NOT NULL,
  `prizevalue` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `winnerinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
