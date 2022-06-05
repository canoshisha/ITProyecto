-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: banco
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bizum`
--

DROP TABLE IF EXISTS `bizum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bizum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `movil destinatario` int(9) NOT NULL,
  `fecha` datetime NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IBAN` (`IBAN`),
  CONSTRAINT `bizum_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bizum`
--

LOCK TABLES `bizum` WRITE;
/*!40000 ALTER TABLE `bizum` DISABLE KEYS */;
INSERT INTO `bizum` VALUES (22,'ES123456789',689541236,'2022-06-01 10:49:58',20);
/*!40000 ALTER TABLE `bizum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `central`
--

DROP TABLE IF EXISTS `central`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `central` (
  `nombre` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `central`
--

LOCK TABLES `central` WRITE;
/*!40000 ALTER TABLE `central` DISABLE KEYS */;
INSERT INTO `central` VALUES ('IberBank','Avenida Dinamarca numero 3','iberbank@gmail.com',654896324);
/*!40000 ALTER TABLE `central` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta bancaria`
--

DROP TABLE IF EXISTS `cuenta bancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta bancaria` (
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`IBAN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta bancaria`
--

LOCK TABLES `cuenta bancaria` WRITE;
/*!40000 ALTER TABLE `cuenta bancaria` DISABLE KEYS */;
INSERT INTO `cuenta bancaria` VALUES ('ES123456789',1500);
/*!40000 ALTER TABLE `cuenta bancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `inicio` date NOT NULL,
  `fin` date NOT NULL,
  `mensualidad` float NOT NULL,
  `hipoteca` tinyint(1) NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IBAN` (`IBAN`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (44,'ES123456789','2022-06-02','2026-06-02',300,1,15000);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre banco` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nombre banco` (`nombre banco`),
  CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`nombre banco`) REFERENCES `central` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=123456792 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (4,'Calle Rojo 5','IberBank'),(6,'Calle Verde 3','IberBank'),(9,'Calle Azul 9','IberBank');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `Numero tarjeta` int(16) NOT NULL,
  `caducidad` date NOT NULL,
  `ccv` int(3) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`Numero tarjeta`),
  KEY `IBAN` (`IBAN`),
  CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (658926547,'2026-06-02',586,'ES123456789');
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IBAN destinatario` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fecha inicio` date NOT NULL,
  `fecha fin` date NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IBAN` (`IBAN`),
  CONSTRAINT `transferencia_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`)
) ENGINE=InnoDB AUTO_INCREMENT=790 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencia`
--

LOCK TABLES `transferencia` WRITE;
/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
INSERT INTO `transferencia` VALUES (789,'ES123456789','ES987654321','2022-06-01','2022-06-02',250);
/*!40000 ALTER TABLE `transferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `DNI` varchar(9) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre completo` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` int(4) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id sucursal` int(11) NOT NULL,
  `movil` int(9) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `IBAN` (`IBAN`),
  KEY `usuario_ibfk_2` (`id sucursal`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id sucursal`) REFERENCES `sucursal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('22224568Y','Hilario de los Cementos',1234,'ES123456789','Calle Kirgyos 3',6,789654123);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-05 18:33:17
