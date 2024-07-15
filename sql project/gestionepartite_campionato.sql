CREATE DATABASE  IF NOT EXISTS `gestionepartite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestionepartite`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestionepartite
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `campionato`
--

DROP TABLE IF EXISTS `campionato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campionato` (
  `id_campionato` bigint NOT NULL AUTO_INCREMENT,
  `bandiera` mediumblob,
  `data_creazione` datetime(6) NOT NULL,
  `data_modifica` datetime(6) NOT NULL,
  `fine` datetime(6) DEFAULT NULL,
  `flg_cancellato` tinyint(1) NOT NULL DEFAULT '0',
  `inizio` datetime(6) DEFAULT NULL,
  `nazione` varchar(100) NOT NULL,
  `nome` varchar(70) NOT NULL,
  `stagione` date NOT NULL,
  `tot_giornate` int DEFAULT NULL,
  PRIMARY KEY (`id_campionato`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campionato`
--

LOCK TABLES `campionato` WRITE;
/*!40000 ALTER TABLE `campionato` DISABLE KEYS */;
INSERT INTO `campionato` VALUES (4,NULL,'2024-05-19 11:00:28.140927','2024-05-19 11:00:28.140927',NULL,0,NULL,'Italia','Serie A','2025-01-01',38),(5,NULL,'2024-05-19 11:00:51.721625','2024-05-19 11:00:51.721625',NULL,0,NULL,'Italia','Serie B','2025-01-01',38),(6,NULL,'2024-05-19 11:01:08.792763','2024-05-19 11:01:08.792763',NULL,0,NULL,'Inghilterra','Premier League','2025-01-01',38),(7,NULL,'2024-05-19 11:01:27.794604','2024-05-19 11:01:27.794604',NULL,0,NULL,'Germania','Bundesliga','2025-01-01',34),(8,NULL,'2024-05-19 11:01:41.951490','2024-05-19 11:01:41.951490',NULL,0,NULL,'Francia','Ligue 1','2025-01-01',34),(9,NULL,'2024-05-19 11:01:57.974011','2024-05-19 11:01:57.974011',NULL,0,NULL,'Spagna','LaLiga','2025-01-01',38);
/*!40000 ALTER TABLE `campionato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-15 22:21:32
