-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 10, 2020 at 03:43 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sm-pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_catagory`
--

CREATE TABLE `tb_catagory` (
  `catagory_ID` int(11) NOT NULL,
  `catagory_Name` varchar(30) NOT NULL,
  `catagory_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_catagory`
--

INSERT INTO `tb_catagory` (`catagory_ID`, `catagory_Name`, `catagory_status`) VALUES
(1, 'water', 1),
(4, 'candy', 1),
(5, 'computer', 1),
(6, 'mobile', 1),
(7, 'food', 1),
(8, 'fruit', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_order`
--

CREATE TABLE `tb_order` (
  `order_ID` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_order`
--

INSERT INTO `tb_order` (`order_ID`, `date`) VALUES
(51, '2019-12-31 08:54:23'),
(52, '2019-12-31 08:59:23'),
(53, '2019-12-31 09:00:40'),
(54, '2019-12-31 09:02:30'),
(55, '2019-12-31 09:11:21'),
(56, '2020-01-01 18:36:09'),
(57, '2020-01-01 18:39:01'),
(58, '2020-01-08 13:43:09'),
(59, '2020-01-08 13:44:12'),
(60, '2020-01-08 15:03:30'),
(61, '2020-01-08 15:07:02'),
(62, '2020-01-08 15:08:12'),
(63, '2020-01-08 15:15:38'),
(64, '2020-01-08 15:18:19'),
(65, '2020-01-08 15:20:12'),
(66, '2020-01-08 15:21:10'),
(67, '2020-01-08 15:26:34'),
(68, '2020-01-08 15:29:53'),
(69, '2020-01-08 15:32:24'),
(70, '2020-01-09 13:29:54'),
(71, '2020-01-09 13:31:50'),
(72, '2020-01-09 13:34:01'),
(73, '2020-01-09 13:34:41'),
(74, '2020-01-09 15:12:59'),
(77, '2020-01-09 21:54:38'),
(78, '2020-01-09 21:59:18'),
(79, '2020-01-09 22:19:49'),
(80, '2020-01-09 22:26:09');

-- --------------------------------------------------------

--
-- Table structure for table `tb_order_detail`
--

CREATE TABLE `tb_order_detail` (
  `ID` int(11) NOT NULL,
  `order_ID` int(11) NOT NULL,
  `product_ID` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_order_detail`
--

INSERT INTO `tb_order_detail` (`ID`, `order_ID`, `product_ID`, `price`, `quantity`) VALUES
(104, 77, 9, 2000, 2),
(105, 77, 7, 40000, 3),
(106, 78, 9, 2000, 2),
(107, 78, 8, 70000, 8),
(108, 79, 9, 2000, 2),
(109, 79, 7, 40000, 4),
(110, 80, 9, 2000, 3),
(111, 80, 7, 40000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tb_product`
--

CREATE TABLE `tb_product` (
  `product_ID` int(11) NOT NULL,
  `barcode` varchar(250) NOT NULL,
  `product_Name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `catagory_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_product`
--

INSERT INTO `tb_product` (`product_ID`, `barcode`, `product_Name`, `price`, `quantity`, `catagory_ID`) VALUES
(7, '2222', 'mouse', 40000, 1975, 50),
(8, '4444', 'keyboard', 70000, 392, 38),
(9, '1111', 'ice', 2000, 281, 1),
(10, '5555', 'candy', 4000, 2997, 1),
(11, '9999', 'beer', 10000, 200, 1),
(12, '3333', 'medicine', 5000, 200, 8),
(13, '1234', 'iq', 30000, 200, 6),
(14, '12345', 'fanta', 3000, 200, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `user_ID` int(11) NOT NULL,
  `user_Name` varchar(50) NOT NULL,
  `user_Surname` varchar(50) NOT NULL,
  `password` int(11) NOT NULL,
  `user_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`user_ID`, `user_Name`, `user_Surname`, `password`, `user_role`) VALUES
(1, 'mangkone', 'phakonekham', 59771616, 1),
(3, 'sengxay', 'phakonekham', 59771616, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_catagory`
--
ALTER TABLE `tb_catagory`
  ADD PRIMARY KEY (`catagory_ID`);

--
-- Indexes for table `tb_order`
--
ALTER TABLE `tb_order`
  ADD PRIMARY KEY (`order_ID`);

--
-- Indexes for table `tb_order_detail`
--
ALTER TABLE `tb_order_detail`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `order_ID` (`order_ID`);

--
-- Indexes for table `tb_product`
--
ALTER TABLE `tb_product`
  ADD PRIMARY KEY (`product_ID`),
  ADD KEY `catagory_ID` (`catagory_ID`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`user_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_catagory`
--
ALTER TABLE `tb_catagory`
  MODIFY `catagory_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tb_order`
--
ALTER TABLE `tb_order`
  MODIFY `order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `tb_order_detail`
--
ALTER TABLE `tb_order_detail`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT for table `tb_product`
--
ALTER TABLE `tb_product`
  MODIFY `product_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `user_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
