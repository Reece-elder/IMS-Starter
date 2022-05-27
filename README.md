Coverage: 66%
# IMS_Starter Project

This is a simple application that an end user can interact with via the command line in order to to manage a local database of customers, products and orders. It allows the user to create, read, update and delete entries for each of these categories.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Software:

Java Runtime Environment 17
    https://docs.oracle.com/goldengate/1212/gg-winux/GDRAD/java.htm#BGBFHBEA

MySQL
    https://dev.mysql.com/downloads/

Eclipse (for testing environment)



### Installing


-Install the Java Runtime Environment onto your local machine.

-Install MySQL onto your local machine. When selecting a username and password choose root.

-Edit the system environmentvariables. On a Windows system search for 'system environment variables' and open the control panel link. Press 'Environment variables' at the bottom of the next window. In the following window, click 'New' under 'System variables' and enter a variable name of 'MYSQL_HOME' and a variable value of 'C:\Program Files\MySQL\MySQL Server 8.0' (or whichever version of MySQL you have running). Press OK. Scroll to the path variable, press edit, then new and enter '%MYSQL_HOME%\bin'. Press okay on all the open windows.


-Run MySQL through the command line with "mysql -u root -proot".

-Use the following lines to setup your database and tables:

    CREATE DATABASE `IMS_Starter`;

    USE `IMS_Starter` ;

    CREATE TABLE IF NOT EXISTS `IMS_Starter`.`customers` (
        `id` INT(11) NOT NULL AUTO_INCREMENT,
        `first_name` VARCHAR(40) NOT NULL,
        `surname` VARCHAR(40) NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `IMS_Starter`.`orders` (
        `order_id` INT(11) NOT NULL AUTO_INCREMENT,
        `customer_id` INT(11) NOT NULL,
        `date_ordered` DATE NOT NULL,
        PRIMARY KEY (`order_id`),
        FOREIGN KEY (`customer_id) references customers(`id`)
    );

    CREATE TABLE IF NOT EXISTS `IMS_Starter`.`products` (
        `product_id` INT(11) NOT NULL AUTO_INCREMENT,
        `price` FLOAT NOT NULL,
        `stock` INT(11) DEFAULT NULL,
        `product_name` VARCHAR(40) NOT NULL,
        PRIMARY KEY (`product_id`),
        FOREIGN KEY (`customer_id) references customers(`id`)
    );

    CREATE TABLE IF NOT EXISTS `IMS_Starter`.`order_info` (
        `order_info_id` INT(11) NOT NULL AUTO_INCREMENT,
        `order_id` INT(11) NOT NULL,
        `product_id` INT(11) NOT NULL,
        `quantity` INT(11) NOT NULL,
        `total_price` FLOAT NOT NULL,
        PRIMARY KEY (`order_info_id`),
        FOREIGN KEY (`order_id`) references orders(`id`),
        Foreign KEY (`product_id`) references products(`product_id`)
    );

-Run the .jar file though the command line by traversing to the directory it is in (YOUR_DIRECTORY/IMS_Starter) and using the command 'Java -jar ims-0.01-jar-with-dependencies.jar'

-Make your choices in the application by typing into the terminal as and when prompted. For example, when given the choice of CUSTOMERS, ITEMS, ORDERS and LEAVE, typing CUSTOMERS will lead to the CRUD menu where you may choose between CREATE, READ, UPDATE, DELETE and RETURN. Chooosing one of these options will allow you to directly interact with the MySQL database. 


## Running the tests

Import the repository into Eclipse as a Maven project. Run tests as JUnit tests. Both Unit tests and Integration tests will run.

### Unit Tests 

The Unit tests test the DAO (data access objects) methods for the Customer, Product and Order classes to ensure they run as intended and can access and change data entries in the databse.

### Integration Tests 

The integration testing focuses on the Controller methods for the Customer, Order and Product classes. It uses Mockito to ensure they run as intended without calling other methods the Controllers rely on to take in the user inputs and call the DAO methods.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
