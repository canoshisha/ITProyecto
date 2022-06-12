-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-06-2022 a las 20:39:01
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--
DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `banco`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `DNI` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_completo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `password` int(9) NOT NULL,
  `direccion` text COLLATE utf8_spanish2_ci NOT NULL,
  `movil` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`DNI`, `nombre_completo`, `password`, `direccion`, `movil`) VALUES
('20204545K', 'Federico Garcia Lorca', 55555, 'Calle Marqués de Toledo, 6', 695874321);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bizum`
--

CREATE TABLE `bizum` (
  `id` int(11) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `movil_destinatario` int(9) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` float NOT NULL,
  `concepto` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `bizum`
--

INSERT INTO `bizum` (`id`, `IBAN`, `movil_destinatario`, `fecha`, `cantidad`, `concepto`) VALUES
(28, 'ES123456789', 654745236, '2022-06-12', 10, 'Comida'),
(29, 'ES123456789', 654123698, '2022-06-12', 10, 'Bebida'),
(30, 'ES123456789', 658412365, '2022-06-12', 15, 'Camiseta nueva');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `central`
--

CREATE TABLE `central` (
  `nombre` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `central`
--

INSERT INTO `central` (`nombre`, `direccion`, `email`, `telefono`) VALUES
('IberBank', 'Avenida Dinamarca numero 3', 'iberbank@gmail.com', 654896324);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta bancaria`
--

CREATE TABLE `cuenta bancaria` (
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `cuenta bancaria`
--

INSERT INTO `cuenta bancaria` (`IBAN`, `cantidad`) VALUES
('ES123456789', 2985),
('ES5487963247', 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `inicio` date NOT NULL,
  `fin` date NOT NULL,
  `mensualidad` float NOT NULL,
  `hipoteca` tinyint(1) NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `IBAN`, `inicio`, `fin`, `mensualidad`, `hipoteca`, `cantidad`) VALUES
(44, 'ES123456789', '2022-06-02', '2026-06-02', 300, 1, 15000),
(45, 'ES123456789', '2022-06-12', '2025-05-27', 555, 0, 20000),
(46, 'ES123456789', '2022-06-12', '2025-05-27', 55, 0, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre_banco` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`id`, `direccion`, `nombre_banco`) VALUES
(4, 'Calle Rojo 5', 'IberBank'),
(6, 'Calle Verde 3', 'IberBank'),
(9, 'Calle Azul 9', 'IberBank');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `Numero_tarjeta` bigint(16) NOT NULL,
  `caducidad` date NOT NULL,
  `cvv` int(3) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`Numero_tarjeta`, `caducidad`, `cvv`, `IBAN`) VALUES
(7615478028201431, '2025-05-27', 210, 'ES123456789'),
(8371248462833732, '2025-05-27', 380, 'ES123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transferencia`
--

CREATE TABLE `transferencia` (
  `id` int(11) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IBAN_destinatario` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `cantidad` float NOT NULL,
  `concepto` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `transferencia`
--

INSERT INTO `transferencia` (`id`, `IBAN`, `IBAN_destinatario`, `fecha_inicio`, `fecha_fin`, `cantidad`, `concepto`) VALUES
(790, 'ES123456789', 'ES1236985478521456996356', '2022-06-12', '2022-06-15', 200, 'Prueba'),
(791, 'ES123456789', 'ES1236547896541236589741', '2022-06-12', '2022-06-15', 140, 'Letra coche');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DNI` varchar(9) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre_completo` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(9) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id_sucursal` int(11) NOT NULL,
  `movil` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`DNI`, `nombre_completo`, `password`, `IBAN`, `direccion`, `id_sucursal`, `movil`) VALUES
('22224568Y', 'Hilario de los Cementos', '12345', 'ES123456789', 'Calle Kirgyos 3', 6, 789654123);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `bizum`
--
ALTER TABLE `bizum`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IBAN` (`IBAN`);

--
-- Indices de la tabla `central`
--
ALTER TABLE `central`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `cuenta bancaria`
--
ALTER TABLE `cuenta bancaria`
  ADD PRIMARY KEY (`IBAN`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IBAN` (`IBAN`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nombre banco` (`nombre_banco`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`Numero_tarjeta`),
  ADD KEY `IBAN` (`IBAN`);

--
-- Indices de la tabla `transferencia`
--
ALTER TABLE `transferencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IBAN` (`IBAN`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `IBAN` (`IBAN`),
  ADD KEY `usuario_ibfk_2` (`id_sucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bizum`
--
ALTER TABLE `bizum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123456792;

--
-- AUTO_INCREMENT de la tabla `transferencia`
--
ALTER TABLE `transferencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=792;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bizum`
--
ALTER TABLE `bizum`
  ADD CONSTRAINT `bizum_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`);

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`nombre_banco`) REFERENCES `central` (`nombre`);

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `tarjeta_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`);

--
-- Filtros para la tabla `transferencia`
--
ALTER TABLE `transferencia`
  ADD CONSTRAINT `transferencia_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IBAN`) REFERENCES `cuenta bancaria` (`IBAN`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
