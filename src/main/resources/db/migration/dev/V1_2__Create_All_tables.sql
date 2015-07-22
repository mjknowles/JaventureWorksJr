CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(50) NOT NULL,
  `address_line2` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `postal_code` varchar(10) NOT NULL,
  `state` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6449ovkajl8faucijt8aw1xq6` (`address`),
  CONSTRAINT `FK_6449ovkajl8faucijt8aw1xq6` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `store` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_mq0fehvwpue7rgxnjj8yt29tq` (`store`),
  CONSTRAINT `FK_mq0fehvwpue7rgxnjj8yt29tq` FOREIGN KEY (`store`) REFERENCES `store` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_birth` tinyblob NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `owner_store` (
  `persons_id` int(11) NOT NULL,
  `stores_id` int(11) NOT NULL,
  PRIMARY KEY (`persons_id`,`stores_id`),
  KEY `FK_8at4wrnfuext2ltov32yxykof` (`stores_id`),
  CONSTRAINT `FK_8at4wrnfuext2ltov32yxykof` FOREIGN KEY (`stores_id`) REFERENCES `store` (`id`),
  CONSTRAINT `FK_9swpb2caryn8u1cwcabc1ypwy` FOREIGN KEY (`persons_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
