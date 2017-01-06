CREATE DATABASE  IF NOT EXISTS `crossover_test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `online_quiz`;
-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: online_quiz
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `choice_master`
--

DROP TABLE IF EXISTS `choice_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choice_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) DEFAULT NULL,
  `text` varchar(45) DEFAULT NULL,
  `isCorrect` tinyint(4) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_choice_master_1_idx` (`question_id`),
  CONSTRAINT `fk_choice_master_1` FOREIGN KEY (`question_id`) REFERENCES `question_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choice_master`
--

LOCK TABLES `choice_master` WRITE;
/*!40000 ALTER TABLE `choice_master` DISABLE KEYS */;
INSERT INTO `choice_master` VALUES (1,1,'True',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(2,1,'False',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(3,2,'-128 to 127',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(4,2,'-(215) to (215) ',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(5,2,'0 to 65535',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(6,2,'0 to 32767',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(7,3,'4 bits',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(8,3,'7 bits',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(9,3,'8 bits',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(10,3,'16 bits',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(11,4,'True',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(12,4,'False',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(13,5,'length',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(14,5,'size()',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(15,5,'fullLength()',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(16,5,'none of above',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(17,6,'Arraylist is synchronized',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(18,6,'ArrayList is used for fast retrival purpose',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(19,6,'ArrayList size is dynamic growable by 100%',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(20,6,'none of the above',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(21,7,'java.util.Comparable',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(22,7,'java.map.Comparable',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(23,7,'java.lang.Comparable',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(24,7,'none of the above',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(25,8,'int [] myArray = {\"5\", \"6\", \"7\"};',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(26,8,'int [] myArray = (5, 8, 2);',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(27,8,'int myArray [] [] = {1,2,3,4};',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(28,8,'int myArray [] = {4, 3, 7};',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(29,9,'public static int main(char args[])',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(30,9,'public static void main(String args[])',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(31,9,'public static void MAIN(String args[])',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(32,9,'public static void main(String args)',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(33,10,'An empty memory space is returned so that the',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(34,10,'void is not supported in Java',0,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(35,10,'void returns no data type',1,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(36,10,'none of above',0,'2016-01-30 18:30:00','2016-01-30 18:30:00');
/*!40000 ALTER TABLE `choice_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_master`
--

DROP TABLE IF EXISTS `exam_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` text,
  `active` tinyint(4) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL COMMENT 'This value should be in millis',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_master`
--

LOCK TABLES `exam_master` WRITE;
/*!40000 ALTER TABLE `exam_master` DISABLE KEYS */;
INSERT INTO `exam_master` VALUES (1,'Java Online Test','This Java Online Test simulates a real online certification exams. You will be presented Multiple Choice Questions (MCQs) based on Core Java Concepts, where you will be given four options. You will select the best suitable answer for the question and then proceed to the next question without wasting given time. You will get your online test score after finishing the complete test.',1,3600,'2016-01-30 18:30:00','2016-01-30 18:30:00');
/*!40000 ALTER TABLE `exam_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question_master`
--

DROP TABLE IF EXISTS `question_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_master` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `exam_id` bigint(20) DEFAULT NULL,
  `text` text,
  `point` int(11) DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_master_1_idx` (`exam_id`),
  CONSTRAINT `fk_question_master_1` FOREIGN KEY (`exam_id`) REFERENCES `exam_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_master`
--

LOCK TABLES `question_master` WRITE;
/*!40000 ALTER TABLE `question_master` DISABLE KEYS */;
INSERT INTO `question_master` VALUES (1,1,'A class can be transient ?',10,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(2,1,'What is the numerical range of a char?',10,'2016-01-30 18:30:00','2016-01-30 18:30:00'),(3,1,'What is the size of a Char?',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(4,1,'An abstract class can have non-abstract methods',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(5,1,'Which method is  in thread class',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(6,1,'which is true about ArrayList',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(7,1,'Which package contain Comparable interface	',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(8,1,'Which will legally declare, construct, and initialize an array',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(9,1,'Which declaration of the main method below would allow a class to be started as a standalone program.',10,'2016-02-06 06:14:18','2016-02-06 06:14:18'),(10,1,'What is the meaning of the return data type void?',10,'2016-02-06 06:14:18','2016-02-06 06:14:18');
/*!40000 ALTER TABLE `question_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Test','User','test@test.com','test','2016-02-01 18:30:00','2016-02-01 18:30:00');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_exam`
--

DROP TABLE IF EXISTS `user_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `exam_id` bigint(20) NOT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `percentage` bigint(20) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_exam_1_idx` (`user_id`),
  KEY `fk_user_exam_2_idx` (`exam_id`),
  CONSTRAINT `fk_user_exam_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_exam_2` FOREIGN KEY (`exam_id`) REFERENCES `exam_master` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_exam`
--

LOCK TABLES `user_exam` WRITE;
/*!40000 ALTER TABLE `user_exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_question_answer`
--

DROP TABLE IF EXISTS `user_question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_question_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question_id` bigint(20) DEFAULT NULL,
  `choice_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_question_answer_1_idx` (`choice_id`),
  KEY `fk_user_question_answer_2_idx` (`question_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_question_answer_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question_master` (`id`),
  CONSTRAINT `user_question_answer_ibfk_2` FOREIGN KEY (`choice_id`) REFERENCES `choice_master` (`id`),
  CONSTRAINT `user_question_answer_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_question_answer`
--

LOCK TABLES `user_question_answer` WRITE;
/*!40000 ALTER TABLE `user_question_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_question_answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

