CREATE DATABASE  IF NOT EXISTS `quiz` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quiz`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: quiz
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
-- Table structure for table `ques`
--

DROP TABLE IF EXISTS `ques`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ques` (
  `qid` int(11) DEFAULT NULL,
  `q` varchar(1000) DEFAULT NULL,
  `a` varchar(100) DEFAULT NULL,
  `b` varchar(100) DEFAULT NULL,
  `c` varchar(100) DEFAULT NULL,
  `d` varchar(100) DEFAULT NULL,
  `r` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ques`
--

LOCK TABLES `ques` WRITE;
/*!40000 ALTER TABLE `ques` DISABLE KEYS */;
INSERT INTO `ques` VALUES (1,'An ice cube is placed over a wooden block and over a metal block. The cube will melt faster on-','Wooden Block','Metal Block','Same time','Depends on external temperature','b'),(2,'Magnet when falls through a copper pipe','Accelerates at rate = g','Accelerates at rate < g','Accelerates at rate > g','Falls with constant velocity','b'),(3,'Multicolor reflections as seen on oil films are due to','Diffraction','Dispersion','Refraction','Interference','d'),(4,'You do not fall on sides while riding a bicycle due to','Stability due to velocity','Same Air pressure on both sides','Gyroscopic precession','Alignment of Centre of mass','c'),(5,'Astronauts feel weightless in International Space Station (ISS) because ','There is no gravity there','They are in continuous free fall','Very high speed of ISS','None of these','b'),(6,'The force of gravitation between earth and moon is greater on ','Earth','Moon','Same on both','Can’t be predicted','c'),(7,'4G (aka LTE) is the new cool, what does LTE stands for','Long Transmission Evolution','Long Term Evolution','Long Transfer Equipment','Long Term Equipment','b'),(8,'Often use .pdf files for print outs? Do you know what PDF stands for?','Portable Data Format','Printable Data Format','Portable Document Format','Printable Document Format','c'),(9,'Night Vision Cameras are awesome, aren’t they? They work using','Infrared Waves','NV Technology','Ultraviolet Light','Microwaves','a'),(10,'Your phone most probably has something named “Snapdragon”. What is it?','A CPU','A GPU','A SoC','None','c'),(11,'20 x86 appears frequently for advanced computer users, what is it?','Architecture of CPU','Programming Language','A version of Windows','RAM Management Algorithm','a'),(12,'Which of the following is not an extension for image (photograph) file?','.raw','.png','.tif','.img','d'),(13,'FAT is the file system you format your pendrive in every now and then, what does this stand for?','File Allocation Table','Formatted Allocation Technology ','Formatted Allocation Table','File Allocation Technology','a'),(14,'“Page File” in Windows operating system acts as','Cache Memory','Virtual RAM','Virtual Hard Disk','Windows Database','b'),(15,'How long will it take to download a 16 MB file on an 8 Mbps Broadband Connection (approx.)?','16 Seconds','2 Seconds','Can’t be predicted','20 Seconds','a'),(16,'Why do seasons happen to be?','Elliptical orbit of earth','Distance of sun from earth','Due to Atmosphere','Tilted axis of earth','d'),(17,'A red rose in blue light will appear _____.','Red','Black','Green','Blue','b'),(18,'Which of the following upgradations will help LEAST in decreasing the startup time of a computer.','Processor from Pentium to i7','HDD to SSD ','RAM from 8 GB to 16 GB','Cannot be predicted','c'),(19,'Which of the of the following is not an gaming console?','Wii','Play Station','Xbox 360','Ngage','d'),(20,'Which of the following feature allows the phone to act as USB host?','USB OTG','USB tethering','USB hub','MHL','a'),(21,'Blood is red due to which one of the following','Lymph','Plasma','RNA','Hemoglobin','d'),(22,'Buoyant force due to liquid on a metal ball compared to a plastic ball of same volume will be','Higher','Lower','Equal','Depends on Liquid','c'),(23,'MS-DOS is a well-known Microsoft product, do you know what it stands for?','Disc optimum system','Disc operating system','Drive operation system','Drive Operational System','b'),(24,'Which of the following is not a web browser','Dolphin','Maxathon','Netscape','Thunderbird','d'),(25,'What can you use to share and save the places you visit on your smartphone?','Zomato','Four Square','Ixigo','Tango','b'),(26,'Following are the names of some well-known CEOs except?','Jeff Bezos','Larry Page','Sergey Brin','Marrisa Mayer','c'),(27,'We cannot live without torrents. Which of the following is not a torrent website?','Bittorrent','Bitsnoop','Kickass','isohunt','a'),(28,'Choose the odd one out','HSDPA','LTE','GPS','WCDMA','c'),(29,'Choose the odd one out','ISS','GPS','GLONASS','IRNSS','a'),(30,'Which of the following is not associated with Android One?','Micromax','Karbonn','Spice','Lava','d'),(31,'Which company acquired the famous on-line shopping portal ‘myntra’?','Snapdeal','Amazon','shopclues','Flipkart','d'),(32,'If we place a switched on refrigerator with its door open in a closed room, the overall temperature of room will','Depends on season','Remain same','Increase','Decrease','c'),(33,'Aqueous Humor is found in which part of the body','Ears','Nose','Eyes','Brain','c'),(34,'Which of the following parasite is found in human stomach?','Ringworm','Leech','Earthworm','Tapeworm','d'),(35,'Program Files (x86) folder is found in','64-bit Operating Systems','32-bit Operating systems','Both 32-bit and 64-bit','Macintosh OS','a'),(36,'What does “S” in “HTTPS” stands for?','Schema','Simple','Security','Secure','d'),(37,'Which of the following is not a technology used for developing websites?','.NET','DHTML','Java','PHP','c'),(38,'Skype is owned by','Facebook','Microsoft','Google','It is Autonomous','b'),(39,'Fastest storage class in C programming language is','Automatic','Register','Static','Global','b'),(40,'Which of the following is the only Indian IM application?','Kik Messenger','Line','Wechat','Hike','d');
/*!40000 ALTER TABLE `ques` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `start`
--

DROP TABLE IF EXISTS `start`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `start` (
  `value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `start`
--

LOCK TABLES `start` WRITE;
/*!40000 ALTER TABLE `start` DISABLE KEYS */;
INSERT INTO `start` VALUES (1);
/*!40000 ALTER TABLE `start` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `name` varchar(30) DEFAULT NULL,
  `points` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES ('spinner',83),('MJ',193),('Trail Blazers',166),('Explogrammers',419),('Dynamites',208),('abhishek,nitin',105),('HAIDER',306),('chaos',70);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-10-24 15:01:16
