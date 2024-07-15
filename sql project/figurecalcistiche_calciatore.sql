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
-- Table structure for table `calciatore`
--

DROP TABLE IF EXISTS `calciatore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calciatore` (
  `id_calciatore` bigint NOT NULL AUTO_INCREMENT,
  `altezza` double DEFAULT NULL,
  `cognome` varchar(70) NOT NULL,
  `data_creazione` datetime(6) NOT NULL,
  `data_modifica` datetime(6) NOT NULL,
  `età` int DEFAULT NULL,
  `flg_cancellato` tinyint(1) NOT NULL DEFAULT '0',
  `nazionalità` varchar(100) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `ruolo` varchar(5) DEFAULT NULL,
  `id_squadra` bigint DEFAULT NULL,
  `cod_calciatore` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_calciatore`),
  KEY `FK5agc20mlaem8v1ryqwy4j0wo3` (`id_squadra`),
  CONSTRAINT `FK5agc20mlaem8v1ryqwy4j0wo3` FOREIGN KEY (`id_squadra`) REFERENCES `squadra` (`id_squadra`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calciatore`
--

LOCK TABLES `calciatore` WRITE;
/*!40000 ALTER TABLE `calciatore` DISABLE KEYS */;
INSERT INTO `calciatore` VALUES (4,183,'Sommer','2024-06-11 12:35:59.982828','2024-06-11 12:35:59.982828',35,0,'Svizzera','Yann',0,'POR',1,'Sommer'),(5,190,'Bastoni','2024-06-11 12:37:33.930865','2024-06-11 12:37:33.930865',25,0,'Italia','Alessandro',0,'DIF',1,'Bastoni'),(6,186,'Pavard','2024-06-11 12:38:35.895368','2024-06-11 12:38:35.895368',28,0,'Francia','Benjamin',0,'DIF',1,'Pavard'),(7,196,'Bisseck','2024-06-11 12:39:38.921977','2024-06-11 12:39:38.921977',23,0,'Germania','Yann',0,'DIF',1,'Bisseck'),(8,189,'De Vrij','2024-06-11 12:40:31.182825','2024-06-11 12:40:31.182825',32,0,'Olanda','Stefan',0,'DIF',1,'DeVrij'),(9,192,'Acerbi','2024-06-11 12:44:24.856568','2024-06-11 12:44:24.856568',36,0,'Italia','Francesco',0,'DIF',1,'Acerbi'),(10,175,'Dimarco','2024-06-11 12:45:14.511912','2024-06-11 12:45:14.511912',26,0,'Italia','Federico',0,'DIF',1,'Dimarco'),(11,183,'Darmian','2024-06-11 12:46:03.095127','2024-06-11 12:46:03.095127',34,0,'Italia','Matteo',0,'DIF',1,'Darmian'),(12,178,'Calhanoglu','2024-06-11 12:47:03.889121','2024-06-11 12:47:03.889121',30,0,'Turchia','Hakan',0,'CEN',1,'Calhanoglu'),(13,175,'Asllani','2024-06-11 12:48:07.895446','2024-06-11 12:48:07.895446',22,0,'Albania','Kristjan',0,'CEN',1,'Asllani'),(14,175,'Barella','2024-06-11 12:48:50.972642','2024-06-11 12:48:50.972642',27,0,'Italia','Nicolò',0,'CEN',1,'Barella'),(15,178,'Frattesi','2024-06-11 12:49:30.460833','2024-06-11 12:49:30.460833',24,0,'Italia','Davide',0,'CEN',1,'Frattesi'),(16,177,'Mkhitaryan','2024-06-11 12:50:32.206278','2024-06-11 12:50:32.206278',35,0,'Armenia','Henrikh',0,'CEN',1,'Mkhi'),(17,184,'Augusto','2024-06-11 12:52:05.331379','2024-06-11 12:52:05.331379',25,0,'Brasile','Carlos',0,'DIF',1,'CarAug'),(18,174,'Martinez','2024-06-11 12:52:56.997166','2024-06-11 12:52:56.997166',26,0,'Argentina','Lautaro',0,'ATT',1,'Lautaro'),(19,192,'Thuram','2024-06-11 12:53:48.164713','2024-06-11 12:53:48.164713',26,0,'Francia','Marcus',0,'ATT',1,'MarThu'),(20,191,'Maignan','2024-06-12 10:16:01.614430','2024-06-12 10:16:01.614430',28,0,'Francia','Mike',0,'POR',5,'Maignan'),(21,192,'Sportiello','2024-06-12 10:17:11.664259','2024-06-12 10:17:11.664259',32,0,'Italia','Marco',0,'POR',5,'Sportiello'),(22,185,'Tomori','2024-06-12 10:18:26.880399','2024-06-12 10:18:26.880399',26,0,'Inghilterra','Fikayo',0,'DIF',5,'Tomori'),(23,194,'Thiaw','2024-06-12 10:19:28.403086','2024-06-12 10:19:28.403086',22,0,'Germania','Malick',0,'DIF',5,'Thiaw'),(24,182,'Kalulu','2024-06-12 10:20:15.803351','2024-06-12 10:20:15.803351',24,0,'Francia','Pierre',0,'DIF',5,'Kalulu'),(25,184,'Hernandez','2024-06-12 10:21:01.998917','2024-06-12 10:21:01.998917',26,0,'Francia','Theo',0,'DIF',5,'Theo'),(26,176,'Calabria','2024-06-12 10:21:39.105242','2024-06-12 10:21:39.105242',27,0,'Italia','Davide',0,'DIF',5,'Calabria'),(27,175,'Bennacer','2024-06-12 10:22:26.778871','2024-06-12 10:22:26.778871',26,0,'Algeria','Ismael',0,'CEN',5,'Bennacer'),(28,186,'Adli','2024-06-12 10:23:18.194534','2024-06-12 10:23:18.194534',23,0,'Francia','Yacine',0,'CEN',5,'Adli'),(29,185,'Reijnders','2024-06-12 10:24:01.963811','2024-06-12 10:24:01.963811',25,0,'Olanda','Tijjani',0,'CEN',5,'Reijnders'),(30,191,'Loftus-Cheek','2024-06-12 10:24:53.694654','2024-06-12 10:24:53.694654',28,0,'Inghilterra','Ruben',0,'CEN',5,'Loftus'),(31,178,'Musah','2024-06-12 10:25:42.607477','2024-06-12 10:25:42.607477',21,0,'Stati Uniti','Yunus',0,'CEN',5,'Musah'),(32,188,'Pobega','2024-06-12 10:26:23.338388','2024-06-12 10:26:23.338388',24,0,'Italia','Tommaso',0,'CEN',5,'Pobega'),(33,188,'Leao','2024-06-12 10:27:09.168714','2024-06-12 10:27:09.168714',25,0,'Portogallo','Rafael',0,'ATT',5,'Leao'),(34,185,'Okafor','2024-06-12 10:27:50.676296','2024-06-12 10:27:50.676296',24,0,'Svizzera','Noah',0,'ATT',5,'Okafor'),(35,177,'Pulisic','2024-06-12 10:28:32.811537','2024-06-12 10:28:32.811537',25,0,'Stati Uniti','Christian',0,'ATT',5,'Pulisic'),(36,172,'Chukwueze','2024-06-12 10:29:21.759572','2024-06-12 10:29:21.759572',25,0,'Nigeria','Samuel',0,'ATT',5,'Chukwueze'),(37,194,'Pinsoglio','2024-06-12 11:21:55.641493','2024-06-12 11:21:55.641493',34,0,'Italia','Carlo',0,'POR',7,'Pinsoglio'),(38,188,'Bremer','2024-06-12 11:23:08.856066','2024-06-12 11:23:08.856066',27,0,'Brasile','',0,'DIF',7,'Bremer'),(39,190,'Gatti','2024-06-12 11:24:22.682152','2024-06-12 11:24:22.682152',25,0,'Italia','Federico',0,'DIF',7,'Gatti'),(40,190,'Djalò','2024-06-12 11:50:33.701926','2024-06-12 11:50:33.701926',24,0,'Portogallo','Tiago',0,'DIF',7,'Djalo'),(41,184,'Danilo','2024-06-12 11:51:31.167956','2024-06-12 11:51:31.167956',32,0,'Brasile','',0,'DIF',7,'Danilo'),(42,190,'Rugani','2024-06-12 11:52:21.509127','2024-06-12 11:52:21.509127',29,0,'Italia','Daniele',0,'DIF',7,'Rugani'),(43,182,'Cambiaso','2024-06-12 11:57:17.682694','2024-06-12 11:57:17.683710',24,0,'Italia','Andrea',0,'DIF',7,'Cambiaso'),(44,183,'De Sciglio','2024-06-12 11:58:47.290816','2024-06-12 11:58:47.290816',31,0,'Italia','Mattia',0,'DIF',7,'DeSciglio'),(45,185,'Locatelli','2024-06-12 11:59:54.246255','2024-06-12 11:59:54.247231',26,0,'Italia','Manuel',0,'CEN',7,'Locatelli'),(46,178,'Fagioli','2024-06-12 12:00:39.788818','2024-06-12 12:00:39.788818',23,0,'Italia','Nicolò',0,'CEN',7,'Fagioli'),(47,183,'Weah','2024-06-12 12:01:52.442820','2024-06-12 12:01:52.442820',24,0,'Stati Uniti','Timothy',0,'CEN',7,'Weah'),(48,187,'Yildiz','2024-06-12 12:03:09.676030','2024-06-12 12:03:09.676030',19,0,'Turchia','Kenan',0,'ATT',7,'Yildiz'),(49,190,'Vlahovic','2024-06-12 12:04:02.554574','2024-06-12 12:04:02.554574',24,0,'Serbia','Dusan',0,'ATT',7,'Vlahovic'),(50,191,'Carnesecchi','2024-06-12 14:01:20.465324','2024-06-12 14:01:20.465324',23,0,'Italia','Marco',0,'POR',8,'Carnesecch'),(51,191,'Musso','2024-06-12 14:02:50.069082','2024-06-12 14:02:50.069082',30,0,'Argentina','Juan',0,'POR',8,'Musso'),(52,194,'Scalvini','2024-06-12 14:03:32.669673','2024-06-12 14:03:32.669673',20,0,'Italia','Giorgio',0,'DIF',8,'Scalvini'),(53,191,'Hien','2024-06-12 14:04:21.494910','2024-06-12 14:04:21.495406',25,0,'Svezia','Isak',0,'DIF',8,'Hien'),(54,190,'Djimsiti','2024-06-12 14:05:32.162191','2024-06-12 14:05:32.162191',31,0,'Albania','Berat',0,'DIF',8,'Djimsiti'),(55,183,'Kolasinac','2024-06-12 14:06:36.805337','2024-06-12 14:06:36.805337',30,0,'Bosnia Erzegovina','Sead',0,'DIF',8,'Kolasinac'),(56,185,'Toloi','2024-06-12 14:07:47.025415','2024-06-12 14:07:47.025415',33,0,'Italia','Rafael',0,'DIF',8,'Toloi'),(57,185,'De Roon','2024-06-12 14:09:24.046910','2024-06-12 14:09:24.046910',33,0,'Olanda','Marten',0,'CEN',8,'DeRoon'),(58,183,'Ederson','2024-06-12 14:12:25.320505','2024-06-12 14:12:25.320505',24,0,'Brasile','',0,'CEN',8,'EdeAta'),(59,188,'Pasalic','2024-06-12 14:13:18.008786','2024-06-12 14:13:18.008786',29,0,'Croazia','Mario',0,'CEN',8,'Pasalic'),(60,182,'Zappacosta','2024-06-12 14:14:14.552802','2024-06-12 14:14:14.552802',32,0,'Italia','Davide',0,'DIF',8,'Zappacosta'),(61,185,'Hateboer','2024-06-12 14:15:08.291625','2024-06-12 14:15:08.291625',30,0,'Olanda','Hans',0,'DIF',8,'Hateboer'),(62,187,'Ruggeri','2024-06-12 14:15:44.604039','2024-06-12 14:15:44.604039',21,0,'Italia','Matteo',0,'DIF',8,'Ruggeri'),(63,182,'Miranchuk','2024-06-12 14:17:11.222491','2024-06-12 14:17:11.222491',28,0,'Russia','Aleksey',0,'CEN',8,'Miranchuk'),(64,174,'Lookman','2024-06-12 14:18:00.017639','2024-06-12 14:18:00.017639',26,0,'Nigeria','Ademola',0,'ATT',8,'Lookman'),(65,195,'Scamacca','2024-06-12 14:18:59.172937','2024-06-12 14:18:59.172937',25,0,'Italia','Gianluca',0,'ATT',8,'Scamacca'),(66,185,'Tourè','2024-06-12 14:20:03.464682','2024-06-12 14:20:03.464682',22,0,'Mali','El Bilal',0,'ATT',8,'ElBiToure'),(67,188,'Skorupski','2024-06-12 14:22:22.524502','2024-06-12 14:22:22.524502',33,0,'Polonia','Lukasz',0,'POR',11,'Skorupski'),(68,196,'Ravaglia','2024-06-12 14:23:06.313700','2024-06-12 14:23:06.313700',24,0,'Italia','Federico',0,'POR',11,'Ravaglia'),(69,188,'Beukema','2024-06-12 14:24:20.683925','2024-06-12 14:24:20.683925',25,0,'Olanda','Sam',0,'DIF',11,'Beukema'),(70,187,'Lucumì','2024-06-12 14:25:09.410780','2024-06-12 14:25:09.410780',25,0,'Colombia','Jhon',0,'DIF',11,'Lucumi'),(71,191,'Lykogiannis','2024-06-12 14:26:56.487426','2024-06-12 14:26:56.487426',30,0,'Grecia','Charalampos',0,'DIF',11,'Lykog'),(72,190,'Posch','2024-06-12 14:27:47.705537','2024-06-12 14:27:47.705537',27,0,'Austria','Stefan',0,'DIF',11,'Posch'),(73,184,'Moro','2024-06-12 14:28:50.406980','2024-06-12 14:28:50.406980',26,0,'Croazia','Nikola',0,'CEN',11,'Moro'),(74,189,'EL Azzouzi','2024-06-12 14:30:03.780201','2024-06-12 14:30:03.780201',23,0,'Marocco','Oussama',0,'CEN',11,'ElAzzouzi'),(75,183,'Aebischer','2024-06-12 14:31:35.297606','2024-06-12 14:31:35.297606',27,0,'Svizzera','Michel',0,'CEN',11,'Aebischer'),(76,183,'Urbanski','2024-06-12 14:32:23.426594','2024-06-12 14:32:23.426594',19,0,'Polonia','Kacper',0,'CEN',11,'Urbanski'),(77,181,'Ferguson','2024-06-12 14:33:46.830019','2024-06-12 14:33:46.830019',24,0,'Scozia','Lewis',0,'CEN',11,'Ferguson'),(78,179,'Karlsson','2024-06-12 14:34:44.547803','2024-06-12 14:34:44.547803',25,0,'Svezia','Jesper',0,'ATT',11,'Karlsson'),(79,183,'Orsolini','2024-06-12 14:36:24.543597','2024-06-12 14:36:24.543597',27,0,'Italia','Riccardo',0,'ATT',11,'Orsolini'),(80,184,'Ndoye','2024-06-12 14:37:15.757565','2024-06-12 14:37:15.757565',23,0,'Svizzera','Dan',0,'CEN',11,'Ndoye'),(81,179,'Castro','2024-06-12 14:38:41.328410','2024-06-12 14:38:41.328410',19,0,'Argentina','Santiago',0,'ATT',11,'Castro'),(82,188,'Odgaard','2024-06-12 14:39:47.798962','2024-06-12 14:39:47.798962',25,0,'Danimarca','Jens',0,'ATT',11,'Odgaard');
/*!40000 ALTER TABLE `calciatore` ENABLE KEYS */;
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
