CREATE DATABASE  IF NOT EXISTS `bd_dsw2_ec1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_dsw2_ec1`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_dsw2_ec1
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `dlc`
--

DROP TABLE IF EXISTS `dlc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dlc` (
  `id_dlc` int(11) NOT NULL AUTO_INCREMENT,
  `contenido` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `id_videojuego` int(11) NOT NULL,
  PRIMARY KEY (`id_dlc`),
  KEY `FKq75al5iq3cg73t9bhppx1s63h` (`id_videojuego`),
  CONSTRAINT `FKq75al5iq3cg73t9bhppx1s63h` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id_videojuego`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlc`
--

LOCK TABLES `dlc` WRITE;
/*!40000 ALTER TABLE `dlc` DISABLE KEYS */;
INSERT INTO `dlc` VALUES (1,'\"Must go faster!\" Celebrate a time when dinosaurs ruled the Earth while scoring epoch-worthy goals with the Jurassic Jeep Wrangler. Also included: themed customization items, including a T. rex Goal Explosion! ',9.99,'EN EL JUEGO','Rocket League - Jurassic World Car Pack',1),(2,'The first downloadable content pack for Call of Duty®: Advanced Warfare, featuring the all-new Exo Zombies co-op experience, the all-new versatile AE4 directed energy assault rifle, the AE4 Widowmaker custom variant.',40,'EN EL JUEGO','Call of Duty: Advanced Warfare - Havoc Map Pack',3),(3,'The Call of Duty: Advanced Warfare Season Pass gives you access to four exciting DLC packs* at one great price**, each delivering a collection of new, thrilling multiplayer content, bonus weapons, and more.',130,'EN EL JUEGO','Call of Duty: Advanced Warfare - Season Pass',3),(4,'The Enter the Gungeon soundtrack by Doseone provided as high quality MP3 files.',20.95,'AUDIO','Enter the Gungeon - Soundtrack',2),(5,'Enter the Gungeon digital comic by Dayjob Studio. ',9.95,'IMGAGEN','Enter the Gungeon - Digital Comic',2);
/*!40000 ALTER TABLE `dlc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion_personal`
--

DROP TABLE IF EXISTS `informacion_personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_personal` (
  `id_info_personal` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `f_nacimiento` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `id_jugador` int(11) NOT NULL,
  PRIMARY KEY (`id_info_personal`),
  UNIQUE KEY `UK_3q1sa0b5nl5xvbst32cct9yok` (`id_jugador`),
  CONSTRAINT `FKmkjgbmugpuala2feo8675fjr8` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_personal`
--

LOCK TABLES `informacion_personal` WRITE;
/*!40000 ALTER TABLE `informacion_personal` DISABLE KEYS */;
INSERT INTO `informacion_personal` VALUES (1,'Cabos','123','manuel@gmail.com','2000-06-16','Manuel',1),(2,'Antonio','123','ricardo@gmail.com','1996-01-12','Ricardo',2),(3,'Pascual','123','ignacio@gmail.com','1995-11-27','Ignacio',3);
/*!40000 ALTER TABLE `informacion_personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `id_jugador` int(11) NOT NULL AUTO_INCREMENT,
  `horas_jugadas` int(11) DEFAULT NULL,
  `n_juegos` int(11) DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_jugador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,12,4,'Kboss'),(2,151,3,'RichMC'),(3,123,3,'Rubik');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores_vieojuegos`
--

DROP TABLE IF EXISTS `jugadores_vieojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores_vieojuegos` (
  `id_jugador` int(11) NOT NULL,
  `id_videojuego` int(11) NOT NULL,
  PRIMARY KEY (`id_jugador`,`id_videojuego`),
  KEY `FK1vtv2aqgdkey4nkmxygds8ysr` (`id_videojuego`),
  CONSTRAINT `FK1vtv2aqgdkey4nkmxygds8ysr` FOREIGN KEY (`id_videojuego`) REFERENCES `videojuegos` (`id_videojuego`),
  CONSTRAINT `FK8u1cbnxepv6q2njpe8dngmqkj` FOREIGN KEY (`id_jugador`) REFERENCES `jugadores` (`id_jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores_vieojuegos`
--

LOCK TABLES `jugadores_vieojuegos` WRITE;
/*!40000 ALTER TABLE `jugadores_vieojuegos` DISABLE KEYS */;
INSERT INTO `jugadores_vieojuegos` VALUES (1,1),(2,1),(3,1),(1,2),(2,2),(1,3),(3,3),(1,4),(2,4),(3,4);
/*!40000 ALTER TABLE `jugadores_vieojuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videojuegos` (
  `id_videojuego` int(11) NOT NULL AUTO_INCREMENT,
  `genero` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id_videojuego`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos`
--

LOCK TABLES `videojuegos` WRITE;
/*!40000 ALTER TABLE `videojuegos` DISABLE KEYS */;
INSERT INTO `videojuegos` VALUES (1,'Deporte, Autos','Rocket League 2',10),(2,'Dungeon Crawler','Enter the Gungeon',25.5),(3,'Shooter','Call of Duty Advance Warfare',159.99),(4,'Sandbox','Minecraft',96.25);
/*!40000 ALTER TABLE `videojuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_dsw2_ec1'
--

--
-- Dumping routines for database 'bd_dsw2_ec1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-20 19:13:48
