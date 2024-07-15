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
-- Table structure for table `dettaglio_partita`
--

DROP TABLE IF EXISTS `dettaglio_partita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dettaglio_partita` (
  `id_dettaglio` bigint NOT NULL AUTO_INCREMENT,
  `cod_calciatore` varchar(10) NOT NULL,
  `data_creazione` datetime(6) NOT NULL,
  `data_modifica` datetime(6) NOT NULL,
  `event_ammonizione` tinyint(1) DEFAULT '0',
  `event_assist` tinyint(1) DEFAULT '0',
  `event_espulsione` tinyint(1) DEFAULT '0',
  `event_gol` tinyint(1) DEFAULT '0',
  `minuto_evento` varchar(3) DEFAULT NULL,
  `flg_cancellato` tinyint(1) NOT NULL DEFAULT '0',
  `id_partita` bigint NOT NULL,
  PRIMARY KEY (`id_dettaglio`),
  KEY `FKhbc3v81a96a5pnsx8ycyovyjx` (`id_partita`),
  CONSTRAINT `FKhbc3v81a96a5pnsx8ycyovyjx` FOREIGN KEY (`id_partita`) REFERENCES `partita` (`id_partita`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dettaglio_partita`
--

LOCK TABLES `dettaglio_partita` WRITE;
/*!40000 ALTER TABLE `dettaglio_partita` DISABLE KEYS */;
INSERT INTO `dettaglio_partita` VALUES (3,'Bastoni','2024-07-04 10:45:58.113488','2024-07-04 10:45:58.113988',0,0,0,1,'14\'',0,17),(4,'Bastoni','2024-07-04 10:46:52.554614','2024-07-04 10:46:52.554614',1,0,0,0,'18\'',0,17),(5,'Bastoni','2024-07-04 10:47:14.946202','2024-07-04 10:47:14.946202',1,0,0,0,'20\'',0,17);
/*!40000 ALTER TABLE `dettaglio_partita` ENABLE KEYS */;
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
