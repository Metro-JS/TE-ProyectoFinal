-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.41 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.10.0.7000
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para temasfinal
DROP DATABASE IF EXISTS `temasfinal`;
CREATE DATABASE IF NOT EXISTS `temasfinal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `temasfinal`;

-- Volcando estructura para tabla temasfinal.boleto
DROP TABLE IF EXISTS `boleto`;
CREATE TABLE IF NOT EXISTS `boleto` (
  `idboleto` int NOT NULL AUTO_INCREMENT,
  `anyo` int NOT NULL,
  `lote` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `folio` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idtipo` int NOT NULL,
  `urlfoto` varchar(255) NOT NULL,
  `numero` int NOT NULL DEFAULT (0),
  PRIMARY KEY (`idboleto`),
  KEY `idtipo` (`idtipo`),
  CONSTRAINT `boleto_ibfk_1` FOREIGN KEY (`idtipo`) REFERENCES `tipoboleto` (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla temasfinal.boleto: ~2 rows (aproximadamente)
DELETE FROM `boleto`;
INSERT INTO `boleto` (`idboleto`, `anyo`, `lote`, `folio`, `idtipo`, `urlfoto`, `numero`) VALUES
	(7, 1973, 'RW-I', '814759', 1, 'https://mxc.com.mx/wp-content/uploads/2019/08/boleto-conmemorativo-metro-.jpg', 5);

-- Volcando estructura para tabla temasfinal.tipoboleto
DROP TABLE IF EXISTS `tipoboleto`;
CREATE TABLE IF NOT EXISTS `tipoboleto` (
  `idtipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`idtipo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla temasfinal.tipoboleto: ~1 rows (aproximadamente)
DELETE FROM `tipoboleto`;
INSERT INTO `tipoboleto` (`idtipo`, `nombre`, `descripcion`) VALUES
	(1, 'Boleto ordinario', 'Boleto normalito');
	
	
	CREATE TABLE `dinosaurio` (
    `id_dinosaurio` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(25) NOT NULL,
    `locomocion` varchar(20) NOT NULL,
    `peso` int(10),
    `dieta` varchar(20) NOT NULL,
    `periodo` varchar(20),
    `url_foto` varchar(300) NOT NULL,
    PRIMARY KEY (`id_dinosaurio`)
);

INSERT INTO dinosaurio(nombre, locomocion, peso, dieta, periodo, url_foto) VALUES
('Tiranosaurus Rex','Bípedo',9000,'Carnivoro','Cretácico','https://content.nationalgeographic.com.es/medio/2022/03/30/tiranosaurio_9feb7e5c.jpg'),
('Triceratops','Cuadrúpedo',6000,'Herbívoro','Cretácico','https://static.wikia.nocookie.net/jurassicpark/images/0/00/15cc09a608484fa57ee97725655bbfdc.png'),
('Velociraptor','Bípedo',15,'Carnívoro','Cretácico','https://dinosaurland.es/wp-content/uploads/elementor/thumbs/21-Velociraptor-qm421jell36au7cpwrr6zmgpv9z0qsar3g7wc2nx1c.jpeg'),
('Stegosaurus','Cuadrúpedo',3100,'Herbívoro','Jurásico','https://dinosaurland.es/wp-content/uploads/elementor/thumbs/dinosaurio-stegosaurus-dinosaurland-r1n5jvppvyq7ahgc8fksp9wkzqen5sq9cnu2l3cav4.jpg'),
('Brachiosaurus','Cuadrúpedo',56000,'Herbívoro','Jurásico','https://inaturalist-open-data.s3.amazonaws.com/photos/6981304/medium.jpg'),
('Spinosaurus','Bípedo',9500,'Carnívoro','Cretácico','https://images.dinosaurpictures.org/spinosaurus_2710.jpg');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
