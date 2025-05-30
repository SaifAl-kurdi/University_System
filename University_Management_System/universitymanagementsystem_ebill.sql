CREATE DATABASE  IF NOT EXISTS `universitymanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `universitymanagementsystem`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: universitymanagementsystem
-- ------------------------------------------------------
-- Server version	5.6.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ebill`
--

DROP TABLE IF EXISTS `ebill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ebill` (
  `billID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `date_of_payment` date NOT NULL,
  `description` varchar(45) NOT NULL,
  `totalAmount` float NOT NULL,
  `semester` varchar(45) NOT NULL,
  `year` year(4) NOT NULL,
  `amountPaid` float NOT NULL,
  PRIMARY KEY (`billID`),
  KEY `fk_studentID_idx` (`studentID`),
  CONSTRAINT `fk_studentID_bill` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ebill`
--

LOCK TABLES `ebill` WRITE;
/*!40000 ALTER TABLE `ebill` DISABLE KEYS */;
INSERT INTO `ebill` VALUES (900000,1907894,'2013-07-07','sem 1',10000,'fall',2013,10000),(900001,1907894,'2014-05-05','sem 3',12000,'summer',2014,2000),(900002,1907895,'2013-07-25','sem 2',11250,'spring',2014,11250),(900003,1907896,'2012-07-23','sem 1',10050,'fall',2012,10000),(900004,1907897,'2012-07-16','sem 1',10050,'fall',2012,10050);
/*!40000 ALTER TABLE `ebill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-20 23:35:58
