DROP SCHEMA if exists IMSTestProject;

CREATE SCHEMA IF NOT EXISTS `IMSTestProject`;

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

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `orders`(
    `id` int auto_increment,
    `customerid` int,
    `cost` float,
    PRIMARY KEY (`id`),
    FOREIGN KEY(`customerID`) REFERENCES `customers`(`id`) ON DELETE CASCADE ON UPDATE CASCADE);

DROP TABLE IF EXISTS `orderItems`;

CREATE table IF NOT EXISTS `orderItems`(
`orderID` int,
`ItemID` int,

FOREIGN KEY(`itemID`) REFERENCES `items`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(`orderID`) REFERENCES `orders`(`id`) ON DELETE CASCADE ON UPDATE CASCADE);