-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: j9b309.p.ssafy.io    Database: i9
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `invest_account`
--

DROP TABLE IF EXISTS `invest_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invest_account` (
  `account_number` varchar(36) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `firm_code` varchar(255) DEFAULT NULL,
  `is_consent` tinyint(1) DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `account_type` varchar(100) DEFAULT NULL,
  `issue_date` datetime DEFAULT NULL,
  `is_tax_benefits` tinyint(1) DEFAULT NULL,
  `remain_amt` double NOT NULL,
  PRIMARY KEY (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invest_account`
--

LOCK TABLES `invest_account` WRITE;
/*!40000 ALTER TABLE `invest_account` DISABLE KEYS */;
INSERT INTO `invest_account` VALUES ('C1AABR0000-76348-01464-77','acrow0330@naver.com','C1AABR0000',0,'키움증권83','101','2023-09-27 13:50:03',0,10000000),('C1AABR0000-98782-75154-70','abc@gmail.com','C1AABR0000',0,'키움증권77','101','2023-10-04 13:53:53',0,10000000),('C1AACU0000-87615-17036-35','abc@gmail.com','C1AACU0000',0,'미래에셋증권56','101','2023-10-04 13:53:54',0,10000000),('C1AADF0000-33081-15573-02','acrow0330@naver.com','C1AADF0000',0,'신한금융투자㈜16','101','2023-09-27 13:50:02',0,10000000),('C1AADF0000-80698-10440-95','detail','C1AADF0000',0,'신한금융투자70','101','2023-10-01 09:32:57',0,10000000),('C1AAEY0000-12649-52426-17','acrow0330@naver.com','C1AAEY0000',0,'삼성증권79','101','2023-09-27 13:50:00',0,10000000),('C1AAEY0000-99653-10436-52','acrow0330@naver.com','C1AAEY0000',0,'삼성증권2','101','2023-09-27 13:49:59',0,10000000),('C1AAHW0000-83206-96061-67','detail','C1AAHW0000',0,'토스증권14','101','2023-10-01 09:32:57',0,10000000);
/*!40000 ALTER TABLE `invest_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-06  2:12:11
