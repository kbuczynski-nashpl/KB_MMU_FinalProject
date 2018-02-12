-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 12, 2018 at 10:38 AM
-- Server version: 10.2.12-MariaDB-10.2.12+maria~xenial
-- PHP Version: 7.0.25-0ubuntu0.16.04.1

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
-- Table structure for table `CRM_company`
--

CREATE TABLE `CRM_company` (
  `id` int(11) NOT NULL,
  `CRM_user_master_id` int(11) NOT NULL,
  `company_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company`
--

INSERT INTO `CRM_company` (`id`, `CRM_user_master_id`, `company_name`) VALUES
(1, 1, 'Test Company 1');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_address`
--

CREATE TABLE `CRM_company_address` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_address_line1` varchar(50) NOT NULL,
  `company_address_line2` varchar(50) DEFAULT NULL,
  `company_address_postcode` varchar(10) NOT NULL,
  `company_address_city` varchar(20) NOT NULL,
  `company_address_country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_address`
--

INSERT INTO `CRM_company_address` (`id`, `company_id`, `company_address_line1`, `company_address_line2`, `company_address_postcode`, `company_address_city`, `company_address_country`) VALUES
(1, 1, 'Test Address 1', NULL, 'OL7 0AA', 'Manchester', 'United Kingdom');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_email_address`
--

CREATE TABLE `CRM_company_email_address` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_email_address` text NOT NULL,
  `company_email_active` tinyint(1) NOT NULL,
  `company_email_type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_email_address`
--

INSERT INTO `CRM_company_email_address` (`id`, `company_id`, `company_email_address`, `company_email_active`, `company_email_type`) VALUES
(1, 1, 'nash25pl@gmail.com', 1, 'Private email address');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_notes`
--

CREATE TABLE `CRM_company_notes` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_note` longtext NOT NULL,
  `company_note_by_id` int(11) NOT NULL,
  `company_note_by_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_notes`
--

INSERT INTO `CRM_company_notes` (`id`, `company_id`, `company_note`, `company_note_by_id`, `company_note_by_date`) VALUES
(1, 1, 'Note Test 1', 1, '2018-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_personnel`
--

CREATE TABLE `CRM_company_personnel` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_personnel_surname` varchar(25) NOT NULL,
  `company_personnel_forname` varchar(25) NOT NULL,
  `company_personnel_email` varchar(25) NOT NULL,
  `company_personnel_phoneNo` bigint(20) NOT NULL,
  `company_personnel_phoneNo_prefix` varchar(5) NOT NULL,
  `company_personnel_position` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_personnel`
--

INSERT INTO `CRM_company_personnel` (`id`, `company_id`, `company_personnel_surname`, `company_personnel_forname`, `company_personnel_email`, `company_personnel_phoneNo`, `company_personnel_phoneNo_prefix`, `company_personnel_position`) VALUES
(1, 1, 'Buczynski', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'CEO');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_phoneNo`
--

CREATE TABLE `CRM_company_phoneNo` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_phoneNo` bigint(20) NOT NULL,
  `company_phoneNo_prefix` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_phoneNo`
--

INSERT INTO `CRM_company_phoneNo` (`id`, `company_id`, `company_phoneNo`, `company_phoneNo_prefix`) VALUES
(1, 1, 7708873917, '+44');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_user`
--

CREATE TABLE `CRM_user` (
  `id` int(11) NOT NULL,
  `user_master_id` int(11) NOT NULL,
  `user_username` text NOT NULL,
  `user_psw` text NOT NULL,
  `user_email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_user`
--

INSERT INTO `CRM_user` (`id`, `user_master_id`, `user_username`, `user_psw`, `user_email`) VALUES
(1, 1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'nash25pl@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_user_information`
--

CREATE TABLE `CRM_user_information` (
  `id` int(11) NOT NULL,
  `user_master_id` int(11) NOT NULL,
  `user_surname` varchar(30) NOT NULL,
  `user_forname` varchar(30) NOT NULL,
  `user_dob` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_user_information`
--

INSERT INTO `CRM_user_information` (`id`, `user_master_id`, `user_surname`, `user_forname`, `user_dob`) VALUES
(1, 1, 'Buczynski', 'Krzysztof', '1995-07-20');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_user_master`
--

CREATE TABLE `CRM_user_master` (
  `id` int(11) NOT NULL,
  `user_company_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_user_master`
--

INSERT INTO `CRM_user_master` (`id`, `user_company_name`) VALUES
(1, 'KBuczynski Ltd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `CRM_company`
--
ALTER TABLE `CRM_company`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CRM_user_master_id` (`CRM_user_master_id`);

--
-- Indexes for table `CRM_company_address`
--
ALTER TABLE `CRM_company_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `CRM_company_email_address`
--
ALTER TABLE `CRM_company_email_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `CRM_company_notes`
--
ALTER TABLE `CRM_company_notes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`),
  ADD KEY `company_note_by_id` (`company_note_by_id`);

--
-- Indexes for table `CRM_company_personnel`
--
ALTER TABLE `CRM_company_personnel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `CRM_company_phoneNo`
--
ALTER TABLE `CRM_company_phoneNo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `company_id` (`company_id`);

--
-- Indexes for table `CRM_user`
--
ALTER TABLE `CRM_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`user_master_id`);

--
-- Indexes for table `CRM_user_information`
--
ALTER TABLE `CRM_user_information`
  ADD PRIMARY KEY (`id`),
  ADD KEY `client_id` (`user_master_id`);

--
-- Indexes for table `CRM_user_master`
--
ALTER TABLE `CRM_user_master`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CRM_company_personnel`
--
ALTER TABLE `CRM_company_personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CRM_user`
--
ALTER TABLE `CRM_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CRM_user_information`
--
ALTER TABLE `CRM_user_information`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `CRM_user_master`
--
ALTER TABLE `CRM_user_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `CRM_company`
--
ALTER TABLE `CRM_company`
  ADD CONSTRAINT `CRM_company_ibfk_1` FOREIGN KEY (`CRM_user_master_id`) REFERENCES `CRM_user_master` (`id`);

--
-- Constraints for table `CRM_company_address`
--
ALTER TABLE `CRM_company_address`
  ADD CONSTRAINT `CRM_company_address_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `CRM_company` (`id`);

--
-- Constraints for table `CRM_company_email_address`
--
ALTER TABLE `CRM_company_email_address`
  ADD CONSTRAINT `CRM_company_email_address_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `CRM_company` (`id`);

--
-- Constraints for table `CRM_company_notes`
--
ALTER TABLE `CRM_company_notes`
  ADD CONSTRAINT `CRM_company_notes_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `CRM_company` (`id`),
  ADD CONSTRAINT `CRM_company_notes_ibfk_2` FOREIGN KEY (`company_note_by_id`) REFERENCES `CRM_user` (`id`);

--
-- Constraints for table `CRM_company_personnel`
--
ALTER TABLE `CRM_company_personnel`
  ADD CONSTRAINT `CRM_company_personnel_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `CRM_company` (`id`);

--
-- Constraints for table `CRM_company_phoneNo`
--
ALTER TABLE `CRM_company_phoneNo`
  ADD CONSTRAINT `CRM_company_phoneNo_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `CRM_company` (`id`);

--
-- Constraints for table `CRM_user`
--
ALTER TABLE `CRM_user`
  ADD CONSTRAINT `CRM_user_ibfk_1` FOREIGN KEY (`user_master_id`) REFERENCES `CRM_user_master` (`id`);

--
-- Constraints for table `CRM_user_information`
--
ALTER TABLE `CRM_user_information`
  ADD CONSTRAINT `CRM_user_information_ibfk_1` FOREIGN KEY (`user_master_id`) REFERENCES `CRM_user_master` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
