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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `card_id` bigint NOT NULL AUTO_INCREMENT,
  `card_member` int DEFAULT NULL,
  `card_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `card_num` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `card_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_consent` bit(1) DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,1,'삼성','3079********3741','02',_binary '','abc'),(2,1,'비씨','5494********8654','01',_binary '','abc'),(3,1,'롯데','4064********3307','01',_binary '','abc'),(4,2,'비씨','5125********5708','01',_binary '','abc'),(5,1,'우리','7345********8887','02',_binary '','abc'),(6,1,'하나','4515********1124','02',_binary '','abc'),(7,1,'신한','4882********0945','01',_binary '','abc'),(8,1,'삼성','5353********7868','03',_binary '','abc'),(9,1,'비씨','9394********4991','01',_binary '','abc'),(10,1,'비씨','3404********2032','01',_binary '','abc'),(11,1,'신한','5699********6853','03',_binary '','abcd'),(12,1,'우리','4604********4110','03',_binary '','abcd'),(13,1,'비씨','7335********9480','01',_binary '','abcd'),(14,1,'비씨','6273********6433','02',_binary '','abcd'),(15,1,'삼성','6482********0863','03',_binary '','abcd'),(16,1,'롯데','5142********3838','02',_binary '','abcd'),(17,2,'현대','1752********8110','03',_binary '','abcde'),(18,1,'비씨','5055********7800','01',_binary '','abcde'),(19,1,'롯데','3575********9228','02',_binary '','abcde'),(20,1,'KB국민','2709********8953','03',_binary '','abcde'),(21,1,'삼성','5396********6705','03',_binary '','abcde'),(22,1,'롯데','2418********6169','02',_binary '','abcde'),(23,1,'롯데','3848********6558','02',_binary '','abcde'),(24,1,'우리','9538********4104','03',_binary '','abcdef'),(25,1,'롯데','7009********3732','02',_binary '','abcdef'),(26,2,'KB국민','4049********3748','02',_binary '','abcdef'),(27,1,'하나','8781********4333','02',_binary '','abcdef'),(28,1,'현대','5496********9381','01',_binary '','abcdef'),(29,1,'하나','7616********1887','03',_binary '','abcdef'),(30,1,'롯데','6538********7590','03',_binary '','abcdefg'),(31,1,'롯데','2082********1056','03',_binary '','abcdefg'),(32,1,'삼성','5032********1082','02',_binary '','abcdefg'),(33,1,'삼성','9201********6239','02',_binary '','abcdefg'),(34,1,'KB국민','1184********1333','01',_binary '','abcdefg'),(35,1,'신한','4274********9128','03',_binary '','abcdefg'),(36,1,'현대','4231********5449','03',_binary '','abcdefg'),(37,1,'비씨','5664********7902','03',_binary '','abcdefgh'),(38,1,'하나','8964********1647','03',_binary '','abcdefgh'),(39,1,'하나','3308********5953','01',_binary '','abcdefgh'),(40,1,'현대','4737********0281','03',_binary '','abcdefgh'),(41,1,'현대','4589********9471','03',_binary '','abcdefgh'),(42,1,'하나','2648********9470','03',_binary '','abcdefgh'),(43,1,'삼성','1629********0396','03',_binary '','abcdefgh'),(44,1,'신한','5451********9066','01',_binary '','abcdefgh'),(45,1,'비씨','6919********3136','01',_binary '','abcdefgh'),(46,2,'롯데','2642********5254','01',_binary '','abcdefghi'),(47,1,'비씨','2703********2784','01',_binary '','abcdefghi'),(48,1,'우리','1040********9656','03',_binary '','abcdefghi'),(49,1,'현대','1828********4044','01',_binary '','abcdefghi'),(50,1,'현대','8174********9131','02',_binary '','abcdefghi'),(51,1,'KB국민','1730********5886','02',_binary '','abcdefghi'),(52,1,'삼성','5014********7421','03',_binary '','abcdefghi'),(53,1,'롯데','6299********8220','01',_binary '','abcdefghij'),(54,1,'KB국민','2874********5875','01',_binary '','abcdefghij'),(55,1,'현대','8197********0217','03',_binary '','abcdefghij'),(56,1,'신한','3665********2374','02',_binary '','abcdefghij'),(57,1,'KB국민','6331********5640','02',_binary '','abcdefghij'),(58,1,'우리','1410********9973','02',_binary '','abcdefghij'),(59,1,'신한','3440********4341','01',_binary '','abcdefghij'),(60,1,'현대','964336******677006','01',_binary '','acrow0330@naver.com'),(61,1,'하나','831466******318505','01',_binary '','acrow0330@naver.com'),(62,1,'우리','571731******635338','02',_binary '','acrow0330@naver.com'),(63,1,'KB국민','896977******560593','01',_binary '','shoot_1@naver.com'),(64,1,'KB국민','180286******710460','03',_binary '','shoot_1@naver.com'),(65,1,'KB국민','662804******469377','03',_binary '','shoot_1@naver.com'),(66,1,'현대','485788******588158','02',_binary '','shoot_1@naver.com'),(67,1,'현대','683653******447411','02',_binary '','gusrhs4560@gmail.com'),(68,2,'현대','264235******952770','01',_binary '','gusrhs4560@gmail.com'),(69,1,'신한','640126******824007','01',_binary '','gusrhs4560@gmail.com'),(70,1,'삼성','528537******192113','01',_binary '','gusrhs4560@gmail.com'),(71,1,'롯데','292229******922180','01',_binary '','gusrhs4560@gmail.com'),(72,1,'롯데','602953******112558','03',_binary '','gusrhs4560@gmail.com'),(73,1,'신한','286184******848276','02',_binary '','gusrhs4560@gmail.com'),(74,1,'현대','416143******313117','03',_binary '','gusrhs4560@gmail.com'),(75,1,'삼성','902347******273153','01',_binary '','gusrhs4560@gmail.com'),(76,1,'비씨','105866******580747','01',_binary '','wjd5126@naver.com'),(77,1,'하나','896474******539623','01',_binary '','wjd5126@naver.com'),(78,2,'삼성','887048******616729','01',_binary '','wjd5126@naver.com'),(79,1,'우리','634949******263448','02',_binary '','wjd5126@naver.com'),(80,1,'우리','225161******573315','01',_binary '','haha990691@gmail.com'),(81,2,'비씨','874251******704652','01',_binary '','haha990691@gmail.com'),(82,1,'우리','563735******590739','03',_binary '','haha990691@gmail.com'),(83,1,'롯데','5277********7813','01',_binary '','giyeonkwon013@gmail.com'),(84,2,'현대','9016********4853','01',_binary '','giyeonkwon013@gmail.com'),(85,1,'삼성','7320********4325','03',_binary '','giyeonkwon013@gmail.com'),(86,1,'KB국민','1502********9163','02',_binary '','giyeonkwon013@gmail.com');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
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
