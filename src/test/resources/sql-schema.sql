DROP TABLE IF EXISTS `customers`;

CREATE table IF NOT EXISTS `customers`(
`id` int auto_increment,
`firstName` varchar(30) ,
`lastName` varchar(30) ,
`username` varchar(30) ,
`password` varchar(30) ,
PRIMARY KEY(`id`));