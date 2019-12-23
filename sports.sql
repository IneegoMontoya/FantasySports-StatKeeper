-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: sports
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fantasy_league`
--

DROP TABLE IF EXISTS `fantasy_league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fantasy_league` (
  `idfantasy_league` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `owner` int(11) DEFAULT NULL,
  `type` varchar(3) NOT NULL,
  PRIMARY KEY (`idfantasy_league`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `owner_idx` (`owner`),
  KEY `type_idx` (`type`),
  CONSTRAINT `owner` FOREIGN KEY (`owner`) REFERENCES `user` (`iduser`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `type` FOREIGN KEY (`type`) REFERENCES `league` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fantasy_league`
--

LOCK TABLES `fantasy_league` WRITE;
/*!40000 ALTER TABLE `fantasy_league` DISABLE KEYS */;
INSERT INTO `fantasy_league` VALUES (1,'Rocket League',1,'NFL'),(2,'Braggin Rights',1,'NFL'),(3,'Great Ones',2,'NFL');
/*!40000 ALTER TABLE `fantasy_league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fantasy_player_team`
--

DROP TABLE IF EXISTS `fantasy_player_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fantasy_player_team` (
  `fteam_id` int(11) NOT NULL,
  `player_id` int(11) NOT NULL,
  PRIMARY KEY (`fteam_id`,`player_id`),
  KEY `iduser_idx` (`player_id`),
  CONSTRAINT `fteam_id` FOREIGN KEY (`fteam_id`) REFERENCES `fantasy_team` (`idfantasy_team`),
  CONSTRAINT `player_id` FOREIGN KEY (`player_id`) REFERENCES `user` (`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fantasy_player_team`
--

LOCK TABLES `fantasy_player_team` WRITE;
/*!40000 ALTER TABLE `fantasy_player_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `fantasy_player_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fantasy_team`
--

DROP TABLE IF EXISTS `fantasy_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fantasy_team` (
  `idfantasy_team` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `fantasy_league_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`idfantasy_team`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `owner_idx` (`owner_id`),
  KEY `league_idx` (`fantasy_league_id`),
  CONSTRAINT `fantasy_league_id` FOREIGN KEY (`fantasy_league_id`) REFERENCES `fantasy_league` (`idfantasy_league`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `user` (`iduser`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fantasy_team`
--

LOCK TABLES `fantasy_team` WRITE;
/*!40000 ALTER TABLE `fantasy_team` DISABLE KEYS */;
INSERT INTO `fantasy_team` VALUES (1,1,'Lanisters',1),(2,2,'Baratheons',1),(3,NULL,'Targaryans',1),(4,4,'Starks',1),(5,1,'Goofy',2),(6,2,'Ducks',2),(7,NULL,'Kings',2),(8,4,'Jesters',2),(9,1,'Avengers',3),(10,2,'Justice League',3);
/*!40000 ALTER TABLE `fantasy_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `league`
--

DROP TABLE IF EXISTS `league`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `league` (
  `name` varchar(3) NOT NULL,
  `sport` varchar(13) DEFAULT NULL,
  `num_teams` int(11) DEFAULT NULL,
  `length_of_season` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `league`
--

LOCK TABLES `league` WRITE;
/*!40000 ALTER TABLE `league` DISABLE KEYS */;
INSERT INTO `league` VALUES ('MLB','Baseball',30,162),('NFL','Football',32,16),('NHL','Hockey',31,82);
/*!40000 ALTER TABLE `league` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `players` (
  `playerid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `jersey_number` int(11) DEFAULT NULL,
  `position` varchar(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`playerid`),
  KEY `team_id_idx` (`team_id`),
  CONSTRAINT `team_id` FOREIGN KEY (`team_id`) REFERENCES `teams` (`idteam`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,'Aaron','Rodgers',2,12,'QB',32),(2,'Patrick','Mahomes',1,14,'QB',23),(3,'Kareem','Hunt',1,14,'RB',24),(4,'Sammy','Watkins',1,81,'WR',26),(5,'Tyreek','Hill',1,14,'WR',22),(6,'Travis','Kelce',1,82,'TE',27),(7,'Devonte','Adams',2,84,'WR',24),(8,'Randall','Cobb',2,18,'WR',28),(9,'Jimmy','Graham',2,80,'TE',29),(10,'Aaron','Jones',2,34,'RB',24),(11,'Greg','Olsen',3,88,'TE',30),(12,'DJ','Moore',3,81,'WR',21),(13,'Christian','McCaffry',3,32,'RB',23),(14,'Cam','Newton',3,1,'QB',28),(15,'Vladamir','Taresenko',5,91,'LW',27),(16,'Braden','Schenn',5,10,'C',28),(17,'Yadier','Molina',4,8,'C',34),(18,'Matt','Carpenter',4,19,'FB',31);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stats`
--

DROP TABLE IF EXISTS `stats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stats` (
  `player` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `stat_type` varchar(25) NOT NULL,
  `stat_value` double DEFAULT NULL,
  PRIMARY KEY (`player`,`year`,`stat_type`),
  CONSTRAINT `player` FOREIGN KEY (`player`) REFERENCES `players` (`playerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stats`
--

LOCK TABLES `stats` WRITE;
/*!40000 ALTER TABLE `stats` DISABLE KEYS */;
INSERT INTO `stats` VALUES (1,2015,'Passing_TD',45),(1,2015,'Passing_Yards',4789),(1,2015,'Rushing_TD',4),(1,2015,'Rushing_Yards',811),(1,2016,'Passing_TD',41),(1,2016,'Passing_Yards',4811),(1,2016,'Rushing_TD',5),(1,2016,'Rushing_Yards',221),(1,2017,'Passing_TD',12),(1,2017,'Passing_Yards',1318),(1,2017,'Rushing_TD',1),(1,2017,'Rushing_Yards',41),(1,2018,'Passing_TD',20),(1,2018,'Passing_Yards',3233),(1,2018,'Rushing_TD',3),(2,2017,'Passing_TD',2),(2,2017,'Passing_Yards',279),(2,2017,'Rushing_TD',0),(2,2017,'Rushing_Yards',24),(2,2018,'Passing_TD',31),(2,2018,'Passing_Yards',3130),(2,2018,'Rushing_TD',6),(2,2018,'Rushing_Yards',278),(4,2016,'Receiving_Yards',2),(4,2016,'Recieving_Yards',887),(4,2017,'Receiving_Yards',912),(4,2018,'Receiving_TD',4),(4,2018,'Receiving_Yards',233),(8,2015,'Receiving_Yards',877),(8,2015,'Rushing_Yards',7),(8,2016,'Receiving_Yards',741),(8,2018,'Receiving_TD',3),(8,2018,'Receiving_Yards',111),(9,2018,'Receiving_TD',8),(9,2018,'Receiving_Yards',534),(11,2015,'Receiving_Yards',1200),(11,2016,'Receiving_Yards',1141),(11,2017,'Receiving_Yards',233),(11,2018,'Receiving_TD',4),(11,2018,'Receiving_Yards',733),(14,2015,'Passing_TD',21),(14,2015,'Passing_Yards',4002),(14,2016,'Passing_TD',36),(14,2016,'Passing_Yards',3951),(14,2016,'Rushing_Yards',412),(14,2017,'Passing_TD',33),(14,2017,'Passing_Yards',3711),(14,2017,'Rushing_Yards',433),(14,2018,'Passing_TD',21),(14,2018,'Passing_Yards',2151),(14,2018,'Rushing_TD',5),(14,2018,'Rushing_Yards',444);
/*!40000 ALTER TABLE `stats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teams` (
  `idteam` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(18) DEFAULT NULL COMMENT 'Name of the sporting team',
  `city` varchar(45) DEFAULT NULL COMMENT 'city in which the team plays',
  `state` varchar(2) DEFAULT NULL,
  `league` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idteam`),
  KEY `league_idx` (`league`),
  CONSTRAINT `league` FOREIGN KEY (`league`) REFERENCES `league` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Cheifs','Kansas City','MO','NFL'),(2,'Packers','Green Bay','WI','NFL'),(3,'Panthers','Charlotte','NC','NFL'),(4,'Cardinals','St Louis','MO','MLB'),(5,'Blues','St Louis','MO','NHL');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `user_name_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Byron','Hammann','bjha43@mail.missouri.edu','password','bjha43'),(2,'Austen','Ibeh','austen@MUemal.com','password','austen'),(4,'Kevin','Stanson','mojo@mojo.net','password','MagicMojo'),(7,'Brett','Nelson','brett@nelson.com','password','brettnelson'),(8,'alex','aaaa','alex@email','password','fail');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-06 15:16:04
