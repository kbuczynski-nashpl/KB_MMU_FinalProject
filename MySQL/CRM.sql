-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 30, 2018 at 09:52 PM
-- Server version: 10.2.14-MariaDB-10.2.14+maria~xenial
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

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
(1, 1, 'Test Company 1'),
(2, 1, 'Test Company 2'),
(3, 1, 'Test Company 3'),
(69, 1, 'Test Company 4'),
(70, 1, 'Test Company 5'),
(71, 1, 'Test Company 112'),
(72, 1, 'TEST'),
(73, 1, 'TEST'),
(74, 1, 'TEST'),
(75, 1, 'Test company sajfnda');

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
  `company_address_country` varchar(20) NOT NULL,
  `company_address_active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_address`
--

INSERT INTO `CRM_company_address` (`id`, `company_id`, `company_address_line1`, `company_address_line2`, `company_address_postcode`, `company_address_city`, `company_address_country`, `company_address_active`) VALUES
(3, 1, 'TEST 1111', 'TEST Line2', 'null', 'TEST CITY', 'TEST COUNTRY', 1),
(11, 69, 'Line 1', 'Line 2', 'M12 2SE', 'Manchester', 'United Kingdom', 1),
(12, 70, 'Line 1', 'Line 2', 'M12 3AR', 'Manchester', 'United', 1),
(13, 71, 'Line1', '', 'OL12sd', 'sader', 'earfq', 1),
(14, 72, 'TEST', 'TEST', '1TEs', 'TEST', 'TEST', 1),
(15, 73, 'test', 'test', 'test', 'test', 'test', 1),
(16, 74, 'TEST', '', 'tEST', 'teas', 'teasd', 1),
(17, 75, 'Test Line 1', '', 'OL7 0AA', 'TEST', 'TEST', 1),
(18, 1, 'TEST LINE11231', 'TEST Line2', 'ol70aa', 'TEST CITY', 'TEST COUNTRY', 0),
(21, 71, '12, Unit 1', 'Lane End Road', 'M19 1TU', 'Manchester', 'United Kingdom', 0);

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
(1, 1, 'nash25pl@gmail.com', 0, 'Private email address'),
(15, 69, 'test@outlook.com', 1, 'outlook private'),
(16, 70, 'outlook@outlook.omc', 1, 'type'),
(17, 71, 'sadaS@asad.com', 1, 'aerqs'),
(18, 72, 'TEST@TEST.com', 1, 'TEST'),
(19, 73, 'test@test.com', 1, 'test'),
(20, 74, 'asde', 1, 'wqdas'),
(21, 75, 'test@outlook.com', 1, 'test email'),
(22, 1, 'test@test.com', 1, 'test EMAIL ENTRY');

-- --------------------------------------------------------

--
-- Table structure for table `CRM_company_notes`
--

CREATE TABLE `CRM_company_notes` (
  `id` int(11) NOT NULL,
  `company_id` int(11) NOT NULL,
  `company_note_title` text NOT NULL,
  `company_note` text NOT NULL,
  `company_note_by_id` int(11) NOT NULL,
  `company_note_by_date` datetime NOT NULL,
  `company_note_assigned_user` int(11) NOT NULL,
  `company_note_status` text NOT NULL,
  `company_note_duein` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_company_notes`
--

INSERT INTO `CRM_company_notes` (`id`, `company_id`, `company_note_title`, `company_note`, `company_note_by_id`, `company_note_by_date`, `company_note_assigned_user`, `company_note_status`, `company_note_duein`) VALUES
(6, 1, 'test', 'test', 1, '2018-03-26 12:54:00', 1, 'IN REVIEW', '2018-03-19 12:54:00'),
(7, 1, 'test', 'test', 1, '2018-03-19 14:22:00', 1, 'OPEN', '2018-03-19 12:12:00'),
(8, 73, 'TEST FOR NEW LAYOUT', 'TESTING', 1, '2018-03-30 00:37:00', 1, 'REQUIRE RESPONSE', '2018-03-15 16:00:00'),
(9, 73, 'Test Longer', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 1, '2018-03-26 19:04:00', 1, 'OPEN', '2018-03-26 20:07:00');

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
(1, 1, 'Buczynskiss', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'CEO'),
(2, 1, 'Subject1', 'Test', 'testsubject1@gmail.com', 1234567, '+44', 'test subject'),
(3, 1, 'Buczynski', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'TEST'),
(4, 2, 'Buczynski', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'TEST'),
(5, 3, 'Buczynski', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'TEST'),
(7, 71, 'Bu', 'KRZ', 'nash25@outlook.com', 770887361, '+22', 'CHEF'),
(8, 73, 'Buczynski', 'Krzysztof', 'nash25pl@gmail.com', 7708873917, '+44', 'CEO');

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
(1, 1, 7708873917, '+44'),
(5, 1, 77088712, '+44'),
(12, 69, 1234513, '+22'),
(13, 70, 213456123, '+43'),
(14, 71, 123141231, '+22'),
(15, 72, 12313, '+12'),
(16, 73, 12314123, '+22'),
(17, 74, 123123, '21'),
(18, 75, 317182731, '+22');

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
  `user_id` int(11) NOT NULL,
  `user_surname` varchar(30) NOT NULL,
  `user_forname` varchar(30) NOT NULL,
  `user_dob` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `CRM_user_information`
--

INSERT INTO `CRM_user_information` (`id`, `user_id`, `user_surname`, `user_forname`, `user_dob`) VALUES
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
  ADD KEY `company_note_by_id` (`company_note_by_id`),
  ADD KEY `company_note_assigned_user` (`company_note_assigned_user`);

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
  ADD KEY `client_id` (`user_id`);

--
-- Indexes for table `CRM_user_master`
--
ALTER TABLE `CRM_user_master`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `CRM_company`
--
ALTER TABLE `CRM_company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;
--
-- AUTO_INCREMENT for table `CRM_company_address`
--
ALTER TABLE `CRM_company_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `CRM_company_email_address`
--
ALTER TABLE `CRM_company_email_address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `CRM_company_notes`
--
ALTER TABLE `CRM_company_notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `CRM_company_personnel`
--
ALTER TABLE `CRM_company_personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `CRM_company_phoneNo`
--
ALTER TABLE `CRM_company_phoneNo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
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
  ADD CONSTRAINT `CRM_user_information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `CRM_user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
