DROP database if exists IMSTestProject;

CREATE database IF NOT EXISTS `IMSTestProject`;

USE `IMSTestProject`;

DROP TABLE IF EXISTS `customers`;

CREATE table IF NOT EXISTS `customers`(
`id` int auto_increment,
`firstName` varchar(30) ,
`lastName` varchar(30) ,
`username` varchar(30) ,
`password` varchar(30) ,
PRIMARY KEY(`id`));

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items`(
`id` int auto_increment,
`cost` float NOT NULL,
`name` varchar(45),
PRIMARY KEY(`id`));