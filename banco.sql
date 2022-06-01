-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2022 a las 10:33:01
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

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
CREATE DATABASE IF NOT EXISTS `banco` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `banco`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bizum`
--

CREATE TABLE `bizum` (
  `id` int(11) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `móvil destinatario` int(9) NOT NULL,
  `fecha` datetime NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `central`
--

CREATE TABLE `central` (
  `nombre` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dirección` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `teléfono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta bancaria`
--

CREATE TABLE `cuenta bancaria` (
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `id` int(11) NOT NULL,
  `dirección` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre banco` varchar(15) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `Numero tarjeta` int(16) NOT NULL,
  `caducidad` date NOT NULL,
  `ccv` int(3) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transferencia`
--

CREATE TABLE `transferencia` (
  `id` int(11) NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IBAN destinatario` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fecha inicio` date NOT NULL,
  `fecha fin` date NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DNI` varchar(9) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre completo` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `IBAN` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dirección` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id sucursal` int(11) NOT NULL,
  `móvil` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Índices para tablas volcadas
--

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
  ADD KEY `nombre banco` (`nombre banco`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`Numero tarjeta`),
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
  ADD KEY `usuario_ibfk_2` (`id sucursal`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bizum`
--
ALTER TABLE `bizum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `transferencia`
--
ALTER TABLE `transferencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`nombre banco`) REFERENCES `central` (`nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
