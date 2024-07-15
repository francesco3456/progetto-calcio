CREATE DATABASE  IF NOT EXISTS `classifiche` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `classifiche`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: classifiche
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
-- Table structure for table `stats_calciatore`
--

DROP TABLE IF EXISTS `stats_calciatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stats_calciatore` (
  `id_stats_calciatore` bigint NOT NULL AUTO_INCREMENT,
  `assist` int DEFAULT '0',
  `calciatore` varchar(150) NOT NULL,
  `data_creazione` datetime(6) NOT NULL,
  `data_modifica` datetime(6) NOT NULL,
  `flg_cancellato` tinyint(1) NOT NULL DEFAULT '0',
  `gol` int DEFAULT '0',
  `nazione` varchar(100) NOT NULL,
  `cod_squadra` varchar(3) DEFAULT NULL,
  `ammonizioni` int DEFAULT '0',
  `espulsioni` int DEFAULT '0',
  `cleansheet` int DEFAULT NULL,
  PRIMARY KEY (`id_stats_calciatore`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stats_calciatore`
--

LOCK TABLES `stats_calciatore` WRITE;
/*!40000 ALTER TABLE `stats_calciatore` DISABLE KEYS */;
INSERT INTO `stats_calciatore` VALUES (6,0,'Sommer','2024-06-11 22:07:38.276655','2024-06-11 22:07:38.276655',0,0,'Italia','INT',0,0,NULL),(7,0,'Bastoni','2024-06-11 22:07:52.570695','2024-06-11 22:07:52.570695',0,0,'Italia','INT',0,0,NULL),(8,0,'Pavard','2024-06-11 22:08:04.006168','2024-06-11 22:08:04.006168',0,0,'Italia','INT',0,0,NULL),(9,0,'Bisseck','2024-06-11 22:08:11.995494','2024-06-11 22:08:11.995494',0,0,'Italia','INT',0,0,NULL),(10,0,'DeVrij','2024-06-11 22:09:39.769468','2024-06-11 22:09:39.769468',0,0,'Italia','INT',0,0,NULL),(11,0,'Acerbi','2024-06-11 22:10:54.372949','2024-06-11 22:10:54.372949',0,0,'Italia','INT',0,0,NULL),(12,0,'Dimarco','2024-06-11 22:11:00.958888','2024-06-11 22:11:00.958888',0,0,'Italia','INT',0,0,NULL),(13,0,'Darmian','2024-06-11 22:11:14.441038','2024-06-11 22:11:14.441038',0,0,'Italia','INT',0,0,NULL),(14,0,'Calhanoglu','2024-06-11 22:11:23.485977','2024-06-11 22:11:23.485977',0,0,'Italia','INT',0,0,NULL),(15,0,'Asllani','2024-06-11 22:11:34.924717','2024-06-11 22:11:34.924717',0,0,'Italia','INT',0,0,NULL),(16,0,'Barella','2024-06-11 22:11:40.010371','2024-06-11 22:11:40.010371',0,0,'Italia','INT',0,0,NULL),(17,0,'Frattesi','2024-06-11 22:11:51.939440','2024-06-11 22:11:51.939440',0,0,'Italia','INT',0,0,NULL),(18,0,'Mkhi','2024-06-11 22:11:58.762445','2024-06-11 22:11:58.762445',0,0,'Italia','INT',0,0,NULL),(19,0,'CarAug','2024-06-11 22:12:12.822464','2024-06-11 22:12:12.822464',0,0,'Italia','INT',0,0,NULL),(20,0,'Lautaro','2024-06-11 22:12:22.899334','2024-06-11 22:12:22.899334',0,0,'Italia','INT',0,0,NULL),(21,0,'MarThu','2024-06-11 22:12:32.005956','2024-06-11 22:12:32.005956',0,0,'Italia','INT',0,0,NULL),(22,0,'Maignan','2024-06-12 10:52:00.527903','2024-06-12 10:52:00.527903',0,0,'Italia','MIL',0,0,NULL),(23,0,'Theo','2024-06-12 10:52:08.157955','2024-06-12 10:52:08.157955',0,0,'Italia','MIL',0,0,NULL),(24,0,'Sportiello','2024-06-12 10:52:13.923931','2024-06-12 10:52:13.923931',0,0,'Italia','MIL',0,0,NULL),(25,0,'Tomori','2024-06-12 10:52:18.968540','2024-06-12 10:52:18.969045',0,0,'Italia','MIL',0,0,NULL),(26,0,'Kalulu','2024-06-12 10:52:24.333925','2024-06-12 10:52:24.333925',0,0,'Italia','MIL',0,0,NULL),(27,0,'Thiaw','2024-06-12 10:52:28.851942','2024-06-12 10:52:28.851942',0,0,'Italia','MIL',0,0,NULL),(28,0,'Calabria','2024-06-12 10:52:34.026292','2024-06-12 10:52:34.026292',0,0,'Italia','MIL',0,0,NULL),(29,0,'Adli','2024-06-12 10:52:41.982719','2024-06-12 10:52:41.982719',0,0,'Italia','MIL',0,0,NULL),(30,0,'Reijnders','2024-06-12 10:52:48.386406','2024-06-12 10:52:48.386406',0,0,'Italia','MIL',0,0,NULL),(31,0,'Loftus','2024-06-12 10:52:53.679958','2024-06-12 10:52:53.679958',0,0,'Italia','MIL',0,0,NULL),(32,0,'Bennacer','2024-06-12 10:53:00.696275','2024-06-12 10:53:00.696275',0,0,'Italia','MIL',0,0,NULL),(33,0,'Musah','2024-06-12 10:53:07.178527','2024-06-12 10:53:07.178527',0,0,'Italia','MIL',0,0,NULL),(34,0,'Pobega','2024-06-12 10:53:24.786342','2024-06-12 10:53:24.786342',0,0,'Italia','MIL',0,0,NULL),(35,0,'Leao','2024-06-12 10:53:29.365542','2024-06-12 10:53:29.365542',0,0,'Italia','MIL',0,0,NULL),(36,0,'Pulisic','2024-06-12 10:53:34.534220','2024-06-12 10:53:34.534220',0,0,'Italia','MIL',0,0,NULL),(37,0,'Chukwueze','2024-06-12 10:53:40.408948','2024-06-12 10:53:40.408948',0,0,'Italia','MIL',0,0,NULL),(38,0,'Okafor','2024-06-12 10:53:45.089742','2024-06-12 10:53:45.089742',0,0,'Italia','MIL',0,0,NULL),(39,0,'Pinsoglio','2024-06-12 11:22:07.342141','2024-06-12 11:22:07.342141',0,0,'Italia','JUV',0,0,NULL),(40,0,'Bremer','2024-06-12 11:23:32.925755','2024-06-12 11:23:32.925755',0,0,'Italia','JUV',0,0,NULL),(41,0,'Gatti','2024-06-12 11:24:29.115343','2024-06-12 11:24:29.115343',0,0,'Italia','JUV',0,0,NULL),(42,0,'Djalo','2024-06-12 11:50:43.989087','2024-06-12 11:50:43.989087',0,0,'Italia','JUV',0,0,NULL),(43,0,'Danilo','2024-06-12 11:51:39.108220','2024-06-12 11:51:39.108220',0,0,'Italia','JUV',0,0,NULL),(44,0,'Rugani','2024-06-12 11:52:31.510961','2024-06-12 11:52:31.510961',0,0,'Italia','JUV',0,0,NULL),(45,0,'Cambiaso','2024-06-12 11:52:48.235612','2024-06-12 11:52:48.235612',0,0,'Italia','JUV',0,0,NULL),(46,0,'DeSciglio','2024-06-12 11:58:58.010761','2024-06-12 11:58:58.011231',0,0,'Italia','JUV',0,0,NULL),(47,0,'Locatelli','2024-06-12 11:59:13.837363','2024-06-12 11:59:13.837363',0,0,'Italia','JUV',0,0,NULL),(48,0,'Fagioli','2024-06-12 12:00:48.387410','2024-06-12 12:00:48.387410',0,0,'Italia','JUV',0,0,NULL),(49,0,'Weah','2024-06-12 12:01:09.497516','2024-06-12 12:01:09.498287',0,0,'Italia','JUV',0,0,NULL),(50,0,'Yildiz','2024-06-12 12:03:15.726533','2024-06-12 12:03:15.726533',0,0,'Italia','JUV',0,0,NULL),(51,0,'Vlahovic','2024-06-12 12:03:32.080417','2024-06-12 12:03:32.080417',0,0,'Italia','JUV',0,0,NULL),(52,0,'Carnesecch','2024-06-12 14:01:47.907969','2024-06-12 14:01:47.907969',0,0,'Italia','ATA',0,0,NULL),(53,0,'Musso','2024-06-12 14:02:16.701629','2024-06-12 14:02:16.701629',0,0,'Italia','ATA',0,0,NULL),(54,0,'Scalvini','2024-06-12 14:03:39.121021','2024-06-12 14:03:39.121021',0,0,'Italia','ATA',0,0,NULL),(55,0,'Hien','2024-06-12 14:03:52.755136','2024-06-12 14:03:52.755136',0,0,'Italia','ATA',0,0,NULL),(56,0,'Djimsiti','2024-06-12 14:05:38.590514','2024-06-12 14:05:38.590514',0,0,'Italia','ATA',0,0,NULL),(57,0,'Kolasinac','2024-06-12 14:05:56.968323','2024-06-12 14:05:56.968323',0,0,'Italia','ATA',0,0,NULL),(58,0,'Toloi','2024-06-12 14:07:52.425376','2024-06-12 14:07:52.425376',0,0,'Italia','ATA',0,0,NULL),(59,0,'DeRoon','2024-06-12 14:08:25.141913','2024-06-12 14:08:25.141913',0,0,'Italia','ATA',0,0,NULL),(60,0,'EdeAta','2024-06-12 14:12:34.015047','2024-06-12 14:12:34.015047',0,0,'Italia','ATA',0,0,NULL),(61,0,'Pasalic','2024-06-12 14:12:47.243057','2024-06-12 14:12:47.243057',0,0,'Italia','ATA',0,0,NULL),(62,0,'Zappacosta','2024-06-12 14:14:20.462250','2024-06-12 14:14:20.462250',0,0,'Italia','ATA',0,0,NULL),(63,0,'Hateboer','2024-06-12 14:14:37.654673','2024-06-12 14:14:37.654673',0,0,'Italia','ATA',0,0,NULL),(64,0,'Ruggeri','2024-06-12 14:15:50.059137','2024-06-12 14:15:50.059137',0,0,'Italia','ATA',0,0,NULL),(65,0,'Miranchuk','2024-06-12 14:16:35.944960','2024-06-12 14:16:35.944960',0,0,'Italia','ATA',0,0,NULL),(66,0,'Lookman','2024-06-12 14:18:05.390671','2024-06-12 14:18:05.390671',0,0,'Italia','ATA',0,0,NULL),(67,0,'Scamacca','2024-06-12 14:18:22.092897','2024-06-12 14:18:22.092897',0,0,'Italia','ATA',0,0,NULL),(68,0,'ElBiToure','2024-06-12 14:20:10.703202','2024-06-12 14:20:10.703202',0,0,'Italia','ATA',0,0,NULL),(69,0,'Skorupski','2024-06-12 14:21:28.570667','2024-06-12 14:21:28.570667',0,0,'Italia','BOL',0,0,NULL),(70,0,'Ravaglia','2024-06-12 14:23:11.825469','2024-06-12 14:23:11.825469',0,0,'Italia','BOL',0,0,NULL),(71,0,'Beukema','2024-06-12 14:23:46.240760','2024-06-12 14:23:46.240760',0,0,'Italia','BOL',0,0,NULL),(72,0,'Lucumi','2024-06-12 14:25:18.333890','2024-06-12 14:25:18.333890',0,0,'Italia','BOL',0,0,NULL),(73,0,'Lykog','2024-06-12 14:26:13.681262','2024-06-12 14:26:13.681262',0,0,'Italia','BOL',0,0,NULL),(74,0,'Posch','2024-06-12 14:27:53.442323','2024-06-12 14:27:53.442323',0,0,'Italia','BOL',0,0,NULL),(75,0,'Moro','2024-06-12 14:28:13.473320','2024-06-12 14:28:13.473320',0,0,'Italia','BOL',0,0,NULL),(76,0,'ElAzzouzi','2024-06-12 14:30:09.831651','2024-06-12 14:30:09.832144',0,0,'Italia','BOL',0,0,NULL),(77,0,'Aebischer','2024-06-12 14:30:31.321862','2024-06-12 14:30:31.321862',0,0,'Italia','BOL',0,0,NULL),(78,0,'Urbanski','2024-06-12 14:32:31.658433','2024-06-12 14:32:31.658433',0,0,'Italia','BOL',0,0,NULL),(79,0,'Ferguson','2024-06-12 14:33:16.602459','2024-06-12 14:33:16.602459',0,0,'Italia','BOL',0,0,NULL),(80,0,'Karlsson','2024-06-12 14:34:56.649696','2024-06-12 14:34:56.649696',0,0,'Italia','BOL',0,0,NULL),(81,0,'Orsolini','2024-06-12 14:35:54.791603','2024-06-12 14:35:54.791603',0,0,'Italia','BOL',0,0,NULL),(82,0,'Ndoye','2024-06-12 14:37:21.209458','2024-06-12 14:37:21.209458',0,0,'Italia','BOL',0,0,NULL),(83,0,'SanCastro','2024-06-12 14:37:53.179581','2024-06-12 14:37:53.179581',0,0,'Italia','BOL',0,0,NULL),(84,0,'Odgaard','2024-06-12 14:38:59.481208','2024-06-12 14:38:59.481208',0,0,'Italia','BOL',0,0,NULL);
/*!40000 ALTER TABLE `stats_calciatore` ENABLE KEYS */;
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