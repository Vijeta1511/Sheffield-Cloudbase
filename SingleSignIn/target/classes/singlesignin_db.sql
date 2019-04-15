CREATE DATABASE  IF NOT EXISTS `capp_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `capp_db`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `loginName` varchar(45) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT 'ROLE_USER',
  `loginStatus` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `loginName_UNIQUE` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Sanika Patil','07440166705','svpatil1@sheffield.ac.uk','Sheffield','sanika','KK/URwce654=','ROLE_ADMIN',1),(2,'Vijeta Agrawal','07856202172','vagrawal@sheffield.ac.uk,'Sheffield','Vijeta',KK/URwce654=','ROLE_ADMIN',1),(3,'Dilshan','07480323853','dilshan@sheffield.ac.uk,'Sheffield','Dilshan',KK/URwce654=','ROLE_ADMIN',1),(4,'Seham','07480573737','seham@sheffield.ac.uk,'Sheffield','Seham',KK/URwce654=','ROLE_ADMIN',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-24 21:32:48
