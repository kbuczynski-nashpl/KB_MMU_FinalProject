-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 07, 2017 at 02:03 PM
-- Server version: 10.2.11-MariaDB-10.2.11+maria~xenial
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CRM`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `client_name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_company`
--

CREATE TABLE `client_company` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `company_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_company_address`
--

CREATE TABLE `client_company_address` (
  `id` int(11) NOT NULL,
  `client_company_id` int(11) NOT NULL,
  `client_company_address_line1` varchar(50) NOT NULL,
  `client_company_address_line2` varchar(50) DEFAULT NULL,
  `client_company_address_postcode` varchar(10) NOT NULL,
  `client_company_address_city` varchar(20) NOT NULL,
  `client_company_address_country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_company_email_address`
--

CREATE TABLE `client_company_email_address` (
  `id` int(11) NOT NULL,
  `client_company_id` int(11) NOT NULL,
  `client_company_emailAddress` text NOT NULL,
  `client_company_email_active` tinyint(1) NOT NULL,
  `client_company_email_type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_company_notes`
--

CREATE TABLE `client_company_notes` (
  `id` int(11) NOT NULL,
  `client_company_id` int(11) NOT NULL,
  `client_company_note` longtext NOT NULL,
  `client_company_note_by_id` int(11) NOT NULL,
  `client_company_note_by_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_company_phoneNo`
--

CREATE TABLE `client_company_phoneNo` (
  `id` int(11) NOT NULL,
  `client_company_id` int(11) NOT NULL,
  `client_company_phoneNo` int(20) NOT NULL,
  `client_company_phoneNo_prefix` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client_user`
--

CREATE TABLE `client_user` (
  `id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `client_username` text NOT NULL,
  `client_psw` text NOT NULL,
  `client_email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client_company`
--
ALTER TABLE `client_company`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- Indexes for table `client_company_address`
--
ALTER TABLE `client_company_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_company_id` (`client_company_id`);

--
-- Indexes for table `client_company_email_address`
--
ALTER TABLE `client_company_email_address`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `client_companies_id` (`client_company_id`);

--
-- Indexes for table `client_company_notes`
--
ALTER TABLE `client_company_notes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_company_id` (`client_company_id`),
  ADD KEY `client_company_by_id` (`client_company_note_by_id`);

--
-- Indexes for table `client_company_phoneNo`
--
ALTER TABLE `client_company_phoneNo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_companies_id` (`client_company_id`);

--
-- Indexes for table `client_user`
--
ALTER TABLE `client_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`client_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_company`
--
ALTER TABLE `client_company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_company_address`
--
ALTER TABLE `client_company_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_company_email_address`
--
ALTER TABLE `client_company_email_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_company_notes`
--
ALTER TABLE `client_company_notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_company_phoneNo`
--
ALTER TABLE `client_company_phoneNo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `client_user`
--
ALTER TABLE `client_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `client_company`
--
ALTER TABLE `client_company`
  ADD CONSTRAINT `client_company_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

--
-- Constraints for table `client_company_address`
--
ALTER TABLE `client_company_address`
  ADD CONSTRAINT `client_company_address_ibfk_1` FOREIGN KEY (`client_company_id`) REFERENCES `client_company` (`id`);

--
-- Constraints for table `client_company_email_address`
--
ALTER TABLE `client_company_email_address`
  ADD CONSTRAINT `client_company_email_address_ibfk_1` FOREIGN KEY (`client_company_id`) REFERENCES `client_company` (`id`);

--
-- Constraints for table `client_company_notes`
--
ALTER TABLE `client_company_notes`
  ADD CONSTRAINT `client_company_notes_ibfk_1` FOREIGN KEY (`client_company_id`) REFERENCES `client_company` (`id`),
  ADD CONSTRAINT `client_company_notes_ibfk_2` FOREIGN KEY (`client_company_note_by_id`) REFERENCES `client_user` (`id`);

--
-- Constraints for table `client_user`
--
ALTER TABLE `client_user`
  ADD CONSTRAINT `client_user_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
