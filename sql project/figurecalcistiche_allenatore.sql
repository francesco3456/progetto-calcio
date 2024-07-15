CREATE DATABASE  IF NOT EXISTS `figurecalcistiche` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `figurecalcistiche`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: figurecalcistiche
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
-- Table structure for table `allenatore`
--

DROP TABLE IF EXISTS `allenatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allenatore` (
  `id_allenatore` bigint NOT NULL AUTO_INCREMENT,
  `altezza` double DEFAULT NULL,
  `cognome` varchar(70) NOT NULL,
  `data_creazione` datetime(6) NOT NULL,
  `data_modifica` datetime(6) NOT NULL,
  `età` int DEFAULT NULL,
  `flg_cancellato` tinyint(1) NOT NULL DEFAULT '0',
  `nazionalità` varchar(100) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `id_squadra` bigint DEFAULT NULL,
  PRIMARY KEY (`id_allenatore`),
  UNIQUE KEY `UK_422w3qclkc8uicuxpvgyk9iec` (`id_squadra`),
  CONSTRAINT `FK9xry3dybdig60wrc92sa0i48t` FOREIGN KEY (`id_squadra`) REFERENCES `squadra` (`id_squadra`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allenatore`
--

LOCK TABLES `allenatore` WRITE;
/*!40000 ALTER TABLE `allenatore` DISABLE KEYS */;
INSERT INTO `allenatore` VALUES (4,0,'rossi','2024-04-13 18:53:29.216582','2024-04-13 18:53:29.216582',0,0,NULL,'ciccio',0,5),(5,0,'teopippo','2024-04-24 18:56:32.425114','2024-04-24 18:56:32.425114',0,0,NULL,'franco',0,NULL);
/*!40000 ALTER TABLE `allenatore` ENABLE KEYS */;
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
