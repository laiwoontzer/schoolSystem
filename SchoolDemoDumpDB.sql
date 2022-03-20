-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: school
-- ------------------------------------------------------
-- Server version	5.7.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` varchar(40) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `course_name` varchar(200) DEFAULT NULL,
  `created_timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `UK_9dll001xc2cip6hug6axoab0p` (`course_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('4b587331-de04-4b78-b941-b4ef16252957',_binary '','PROGRAMMER','2022-03-21 01:42:06.624194'),('8fb31a40-f0ff-4881-9659-ffb81eee0caf',_binary '','ACCOUNT','2022-03-21 01:43:02.636181'),('9f42dbb3-5d0d-4fdc-9d9e-b961dcdb2c7d',_binary '','SOFTWARE DEVELOPER','2022-03-21 01:41:17.854349'),('a7147e74-2116-40ad-9ab7-8c0bef393bee',_binary '','GRAPHIC DESIGN','2022-03-21 01:42:12.135029'),('d3efeb67-8fd7-4c41-ac39-9624182d0cd0',_binary '','FASHION DESIGN','2022-03-21 01:41:34.031816');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `course_id` varchar(255) NOT NULL,
  `student_id` varchar(255) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES ('4b587331-de04-4b78-b941-b4ef16252957','04ba0cb0-46b5-450f-b985-ec9ace67762f'),('4b587331-de04-4b78-b941-b4ef16252957','066ee1df-3fc8-4a9d-8bf0-a86ee218abc6'),('8fb31a40-f0ff-4881-9659-ffb81eee0caf','553d5d51-9b0d-4989-9a49-a8d91b8a1b88'),('8fb31a40-f0ff-4881-9659-ffb81eee0caf','681c3053-9f30-4217-8e39-1fd5ee14de23'),('9f42dbb3-5d0d-4fdc-9d9e-b961dcdb2c7d','95f0736b-781d-4b4d-85b7-f377e121ffcf'),('9f42dbb3-5d0d-4fdc-9d9e-b961dcdb2c7d','ddb4b2f9-aa02-4b57-b6d3-36185d2db3d9'),('a7147e74-2116-40ad-9ab7-8c0bef393bee','04ba0cb0-46b5-450f-b985-ec9ace67762f'),('a7147e74-2116-40ad-9ab7-8c0bef393bee','066ee1df-3fc8-4a9d-8bf0-a86ee218abc6'),('d3efeb67-8fd7-4c41-ac39-9624182d0cd0','553d5d51-9b0d-4989-9a49-a8d91b8a1b88'),('d3efeb67-8fd7-4c41-ac39-9624182d0cd0','681c3053-9f30-4217-8e39-1fd5ee14de23');
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` varchar(40) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `created_timestamp` datetime(6) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `student_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('04ba0cb0-46b5-450f-b985-ec9ace67762f',_binary '','2022-03-21 01:39:49.039061','female','MARIA'),('066ee1df-3fc8-4a9d-8bf0-a86ee218abc6',_binary '','2022-03-21 01:40:08.944019','female','ELIZ'),('553d5d51-9b0d-4989-9a49-a8d91b8a1b88',_binary '','2022-03-21 01:39:37.829086','male','JORDAN'),('681c3053-9f30-4217-8e39-1fd5ee14de23',_binary '','2022-03-21 01:39:29.820540','male','JAMES'),('95f0736b-781d-4b4d-85b7-f377e121ffcf',_binary '','2022-03-21 01:40:20.731385','female','CURRY'),('ddb4b2f9-aa02-4b57-b6d3-36185d2db3d9',_binary '','2022-03-21 01:40:44.518400','male','LEBRON');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-21  1:50:44
