-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for crud
CREATE DATABASE IF NOT EXISTS `crud` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `crud`;

-- Dumping structure for table crud.course
CREATE TABLE IF NOT EXISTS `course` (
  `course_id` varchar(255) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `FKs8aqr642dup1oio7xa51t5vw5` (`student_id`),
  KEY `FKsybhlxoejr4j3teomm5u2bx1n` (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table crud.course: 2 rows
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`course_id`, `course_name`, `student_id`, `teacher_id`) VALUES
	('1', 'CSIT', '2', '1'),
	('2', 'BCA', '1', '3');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table crud.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table crud.hibernate_sequence: 3 rows
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(9),
	(9),
	(9);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table crud.student
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` varchar(255) NOT NULL,
  `student_address` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `FK3mphcmldvs29jl1w40ssg300j` (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table crud.student: 2 rows
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`student_id`, `student_address`, `student_email`, `student_name`, `teacher_id`) VALUES
	('1', 'btl', 'mallik', 'deepali', NULL),
	('2', 'npj', 'mallik', 'niki', '3'),
	('3', 'npj', 'mallik', 'niki', '3'),
	('4', NULL, 'mallik', 'niki', NULL),
	('5', 'ktm', 'mallik', 'nikita', '3');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table crud.teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_id` varchar(255) NOT NULL,
  `teacher_address` varchar(255) DEFAULT NULL,
  `teacher_email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table crud.teacher: 4 rows
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`teacher_id`, `teacher_address`, `teacher_email`, `phone_number`, `teacher_name`) VALUES
	('2', 'KTM', 'derf@gmail.com', '000000000', 'Sudip'),
	('1', 'BTL', 'ghtr@gmail.com', '1111111111', 'Shrawan'),
	('3', 'BKT', 'hsfghs@gmail.com', '464654561', 'Digbijaya'),
	('5', 'adda', 'xasxas@gmail.com', '0148989589', 'Sxsaxsahrawan');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
