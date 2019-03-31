# CRUDOperations with custom exception handling

CREATE SCHEMA `crud_operations`;

CREATE TABLE `crud_operations`.`contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` varchar(128) NOT NULL UNIQUE,
  `name` varchar(128) NOT NULL,
  `email` varchar(128) DEFAULT NULL,
  `phone` varchar(45)  NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1
