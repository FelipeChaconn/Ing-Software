-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2019 a las 02:07:52
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `watchband_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Bands'),
(2, 'Watch'),
(3, 'Accessories');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `SKU` varchar(11) NOT NULL,
  `nameP` varchar(50) NOT NULL,
  `descP` varchar(50) NOT NULL,
  `imgP` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `stockP` int(10) NOT NULL,
  `priceP` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`SKU`, `nameP`, `descP`, `imgP`, `category_id`, `stockP`, `priceP`) VALUES
('1c', 'Metal Band', 'Metal band for apple watch  Series 1,2,3,4,5', 'https://images-na.ssl-images-amazon.com/images/I/71L6rH9G3mL._SL1500_.jpg', 1, 10, 20),
('1D', 'Charger base', 'wood charger base', 'https://www.woodcessories.com/media/image/product/1187/lg/applewatch-accessories-charging-station-.jpg', 3, 3, 50),
('1E', 'Silicon Band', 'Color: Red  Size: 38mm SMALL ', 'https://i5.walmartimages.com/asr/9e7323e7-d748-4c1d-846c-3e85b9886aea_1.44033622bab9df2cca93245590925915.jpeg', 1, 4, 18),
('1T', 'Apple Watch', 'Series 5', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MWUX2_VW_34FR+watch-44-alum-spacegray-nc-5s_VW_34FR_WF_CO?wid=750&hei=712&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1566419677721,1569365638987', 2, 3, 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `description` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `description`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tel_number` int(10) NOT NULL,
  `direction` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `last_name`, `password`, `tel_number`, `direction`, `email`, `id_role`) VALUES
(12345678, 'Bladimir', 'Arroyo', 'e99a18c428cb38d5f260853678922e03', 86270130, 'San Carlos', 'b@arroyo.utn.ac.cr', 2),
(87654321, 'Monica', 'Zamora Rojas', 'e99a18c428cb38d5f260853678922e03', 83627435, 'Cedral, Ciudad Quesada', 'moni@gmail.com', 2),
(305130343, 'Luis Felipe', 'Chacon Navarro', '21232f297a57a5a743894a0e4a801fc3', 85789420, 'San Carlos', 'luis.felipe16981460@gmail.com', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`SKU`),
  ADD KEY `category_id` (`category_id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_user_Roles` (`id_role`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_user_Roles` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
