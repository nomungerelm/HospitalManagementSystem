-- MySQL dump 10.13  Distrib 8.0.40, for macos14 (x86_64)
--
-- Host: 127.0.0.1    Database: hospital_db
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `appointment_date` date DEFAULT NULL,
  `appointment_time` time DEFAULT NULL,
  `status` varchar(20) DEFAULT 'Scheduled',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`appointment_id`),
  KEY `patient_id` (`patient_id`),
  KEY `idx_doctor_id` (`doctor_id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `Doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (1,1,2,'2024-12-31','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(2,2,3,'2024-12-31','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(3,3,4,'2024-12-31','10:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(4,4,5,'2024-12-31','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(5,5,6,'2024-12-31','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(6,6,7,'2024-12-31','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(7,7,8,'2025-01-01','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(8,8,9,'2025-01-01','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(10,10,11,'2025-01-01','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(11,11,12,'2025-01-01','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(12,12,13,'2025-01-01','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(13,13,14,'2025-01-02','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(14,14,15,'2025-01-02','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(15,15,16,'2025-01-02','10:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(16,16,17,'2025-01-02','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(17,17,18,'2025-01-02','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(18,18,19,'2025-01-02','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(19,19,20,'2025-01-03','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(20,20,21,'2025-01-03','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(21,21,22,'2025-01-03','10:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(22,22,23,'2025-01-03','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(23,23,24,'2025-01-03','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(24,24,25,'2025-01-03','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(25,25,26,'2025-01-04','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(26,26,27,'2025-01-04','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(27,27,28,'2025-01-04','10:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(28,28,29,'2025-01-04','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(29,29,30,'2025-01-04','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(30,30,31,'2025-01-04','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(31,31,32,'2025-01-05','09:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(32,32,33,'2025-01-05','09:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(33,33,34,'2025-01-05','10:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(34,34,35,'2025-01-05','10:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(35,35,36,'2025-01-05','11:00:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39'),(36,36,37,'2025-01-05','11:30:00','Scheduled','2024-12-04 08:03:39','2024-12-04 08:03:39');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Doctor`
--

DROP TABLE IF EXISTS `Doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Doctor` (
  `doctor_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Specialty` varchar(100) DEFAULT NULL,
  `Hospital` varchar(255) DEFAULT NULL,
  `PhoneNumber` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `YearsOfExperience` int DEFAULT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `LicenseNumber` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Doctor`
--

LOCK TABLES `Doctor` WRITE;
/*!40000 ALTER TABLE `Doctor` DISABLE KEYS */;
INSERT INTO `Doctor` VALUES (1,'Dr. Matthew Smith','Oncology','Sons and Miller','555-345-6789','matthew.smith@hospital.com',15,'Cancer Treatment','XYZ12345'),(2,'Dr. Samantha Davies','Cardiology','Kim Inc','555-123-4567','samantha.davies@hospital.com',22,'Heart Diseases','ABC67890'),(3,'Dr. Tiffany Mitchell','Endocrinology','Cook PLC','555-234-5678','tiffany.mitchell@hospital.com',18,'Diabetes','XYZ23456'),(4,'Dr. Kevin Wells','Gastroenterology','Hernandez Rogers and Vang','555-456-7890','kevin.wells@hospital.com',20,'Stomach Disorders','DEF12345'),(5,'Dr. Kathleen Hanna','Nephrology','White-White','555-567-8901','kathleen.hanna@hospital.com',10,'Kidney Disease','GHI67890'),(6,'Dr. Taylor Newton','Neurology','Nunez-Humphrey','555-678-9012','taylor.newton@hospital.com',8,'Brain and Nerve','JKL23456'),(7,'Dr. Kelly Olson','Pulmonology','Group Middleton','555-789-0123','kelly.olson@hospital.com',12,'Lung Diseases','MNO56789'),(8,'Dr. Suzanne Thomas','Ophthalmology','Powell Robinson and Valdez','555-890-1234','suzanne.thomas@hospital.com',16,'Eye Care','PQR67890'),(9,'Dr. Daniel Ferguson','Orthopedics','Sons Rich and','555-901-2345','daniel.ferguson@hospital.com',24,'Bones and Joints','STU23456'),(10,'Dr. Heather Day','Pediatrics','Padilla-Walker','555-012-3456','heather.day@hospital.com',14,'Children Care','VWX34567'),(11,'Dr. John Duncan','Psychiatry','Schaefer-Porter','555-234-5678','john.duncan@hospital.com',19,'Mental Health','YZA67890'),(12,'Dr. Kenneth Fletcher','Surgery','Powers Miller, and Flores','555-345-6789','kenneth.fletcher@hospital.com',25,'General Surgery','BCD23456'),(13,'Dr. Angela Contreras','Infectious Disease','Garner-Bowman','555-456-7890','angela.contreras@hospital.com',13,'Infection Treatment','EFG56789'),(14,'Dr. Gina Perez','Dermatology','Ellis','555-567-8901','gina.perez@hospital.com',10,'Skin Conditions','HIJ23456'),(15,'Dr. Wendy Glenn','Geriatrics','Brown, and Jones Weaver','555-678-9012','wendy.glenn@hospital.com',17,'Elderly Care','KLM34567'),(16,'Dr. Dan Anderson','Anesthesiology','Miller','555-789-0123','dan.anderson@hospital.com',15,'Pain Management','NOP67890'),(17,'Dr. Stephanie Kramer','Pathology','Wilson Group','555-890-1234','stephanie.kramer@hospital.com',9,'Disease Analysis','QRS23456'),(18,'Dr. Angela Contreras','Gastroenterology','Garner-Bowman','555-901-2345','angela.contreras@hospital.com',12,'Digestive System','TUV23456'),(19,'Dr. Heather Jones','Pediatric Surgery','Williams-Davis','555-012-3456','heather.jones@hospital.com',11,'Child Surgery','WXY34567'),(20,'Dr. Linda Fox','Radiology','Rivera-Cooper','555-234-5678','linda.fox@hospital.com',8,'Imaging','XYZ34567'),(21,'Dr. Vanessa Newton','Cardiology','Clark-Mayo','555-345-6789','vanessa.newton@hospital.com',20,'Heart Diseases','BCD67890'),(22,'Dr. Gregory Smith','Orthopedic Surgery','Williams-Davis','555-456-7890','gregory.smith@hospital.com',22,'Bones and Joints','DEF23456'),(23,'Dr. Maria Dougherty','Infectious Disease','Cline-Williams','555-567-8901','maria.dougherty@hospital.com',19,'Infection Control','EFG67890'),(24,'Dr. Erica Spencer','Surgery','Cervantes-Wells','555-678-9012','erica.spencer@hospital.com',16,'General Surgery','HIJ23456'),(25,'Dr. Daniel Ferguson','Orthopedics','Hammond Ltd','555-789-0123','daniel.ferguson@hospital.com',14,'Bones and Joints','JKL34567'),(26,'Dr. Krista Smith','Neurology','Jones LLC','555-890-1234','krista.smith@hospital.com',10,'Brain Disorders','KLM45678'),(27,'Dr. Justin Kim','Cardiology','Torres, and Harrison Jones','555-901-2345','justin.kim@hospital.com',13,'Heart Diseases','MNO67890'),(28,'Dr. Vanessa Perez','Pediatrics','Tebow-Miller','555-234-5678','vanessa.perez@hospital.com',9,'Children Care','PQR23456'),(29,'Dr. Lisa Roberts','Geriatrics','Monroe-Smith','555-567-8901','lisa.roberts@hospital.com',18,'Elderly Care','STU34567'),(30,'Dr. Mike Turner','Psychiatry','Harrison-Williams','555-678-9012','mike.turner@hospital.com',11,'Mental Health','VWX45678'),(31,'Dr. Rachel Clark','Endocrinology','Miller-Herbert','555-789-0123','rachel.clark@hospital.com',15,'Diabetes and Hormonal Disorders','YZA23456'),(32,'Dr. Samuel Johnson','Nephrology','Rivera-Fleming','555-890-1234','samuel.johnson@hospital.com',20,'Kidney Care','BCD23456'),(33,'Dr. Ava Brown','Pulmonology','Smith-Keller','555-901-2345','ava.brown@hospital.com',22,'Lung Diseases','DEF34567'),(34,'Dr. Mia White','Surgery','Roberts-Smith','555-345-6789','mia.white@hospital.com',9,'General Surgery','EFG23456'),(35,'Dr. Noah Green','Orthopedics','Miller-Brown','555-456-7890','noah.green@hospital.com',16,'Bones and Joints','HIJ23456'),(36,'Dr. Ethan Scott','Cardiology','Williams-Jones','555-567-8901','ethan.scott@hospital.com',14,'Heart Diseases','JKL45678'),(37,'Dr. Lily Harris','Pediatric Surgery','Stone-Wilson','555-678-9012','lily.harris@hospital.com',11,'Child Surgery','KLM23456'),(38,'Dr. Oscar Hill','Anesthesiology','Tanner-Cline','555-789-0123','oscar.hill@hospital.com',21,'Pain Management','NOP56789'),(39,'Dr. Chloe Lee','Pathology','Cervantes-Lincoln','555-890-1234','chloe.lee@hospital.com',13,'Disease Analysis','PQR67890'),(40,'Dr. Sarah Adams','Radiology','Miller-Palmer','555-901-2345','sarah.adams@hospital.com',10,'Imaging','TUV67890'),(41,'Dr. Henry Davis','Surgery','Hernandez-Green','555-345-6789','henry.davis@hospital.com',18,'General Surgery','WXY34567'),(42,'Dr. Charlotte Kim','Psychiatry','Smith-Williams','555-456-7890','charlotte.kim@hospital.com',15,'Mental Health','ZAB23456'),(43,'Dr. Adam Lopez','Pediatrics','Valdez-Brown','555-567-8901','adam.lopez@hospital.com',14,'Children Care','CDE34567'),(44,'Dr. Julia Martinez','Endocrinology','Miller','555-678-9012','julia.martinez@hospital.com',12,'Diabetes','DEF45678'),(45,'Dr. Carlos Rivera','Pulmonology','Nelson-Rivera','555-789-0123','carlos.rivera@hospital.com',21,'Lung Care','GHI23456'),(46,'Dr. Max Turner','Orthopedic Surgery','Ritchie-Burns','555-890-1234','max.turner@hospital.com',23,'Bones and Joints','JKL34567'),(47,'Dr. William Evans','Surgery','Whitman-Todd','555-901-2345','william.evans@hospital.com',20,'General Surgery','MNO56789');
/*!40000 ALTER TABLE `Doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MedicalRecord`
--

DROP TABLE IF EXISTS `MedicalRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MedicalRecord` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `diagnosis` text,
  `treatment` text,
  `prescription` text,
  `record_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `patient_id` (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `medicalrecord_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`),
  CONSTRAINT `medicalrecord_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `Doctor` (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MedicalRecord`
--

LOCK TABLES `MedicalRecord` WRITE;
/*!40000 ALTER TABLE `MedicalRecord` DISABLE KEYS */;
INSERT INTO `MedicalRecord` VALUES (126,2,1,'Obesity','Diet and exercise','Ibuprofen','2019-08-20'),(127,3,2,'Obesity','Exercise and diet','Aspirin','2022-09-22'),(128,4,3,'Diabetes','Insulin therapy','Ibuprofen','2020-11-18'),(129,5,1,'Cancer','Chemotherapy','Penicillin','2022-09-19'),(130,6,2,'Asthma','Inhalers','Ibuprofen','2023-12-20'),(131,7,3,'Diabetes','Insulin injections','Aspirin','2020-11-03'),(132,8,1,'Cancer','Radiation therapy','Penicillin','2021-12-28'),(133,9,2,'Asthma','Inhalers','Lipitor','2020-07-01'),(134,10,3,'Cancer','Chemotherapy','Paracetamol','2021-05-23'),(135,11,1,'Cancer','Radiation','Paracetamol','2020-04-19'),(136,12,2,'Hypertension','Blood pressure medication','Aspirin','2023-08-13'),(137,13,3,'Diabetes','Insulin therapy','Paracetamol','2019-12-12'),(138,14,1,'Asthma','Bronchodilators','Lipitor','2020-05-22'),(139,15,2,'Cancer','Chemotherapy','Paracetamol','2021-10-08'),(140,16,3,'Obesity','Exercise','Aspirin','2023-01-01'),(141,17,1,'Arthritis','Anti-inflammatory drugs','Lipitor','2020-06-23'),(142,18,2,'Obesity','Weight loss surgery','Paracetamol','2020-03-08'),(143,19,3,'Hypertension','Blood pressure meds','Penicillin','2021-03-04'),(144,20,1,'Asthma','Inhalers','Iburprofen','2022-11-15'),(145,21,21,'Asthma','Aspirin','Aspirin','2024-12-12');
/*!40000 ALTER TABLE `MedicalRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `blood_type` enum('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
  `medical_condition` text,
  `date_of_admission` date DEFAULT NULL,
  `doctor_id` int DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  `hospital` varchar(100) DEFAULT NULL,
  `insurance_provider` varchar(100) DEFAULT NULL,
  `billing_amount` decimal(10,2) DEFAULT NULL,
  `room_number` varchar(10) DEFAULT NULL,
  `admission_type` enum('Emergency','Scheduled','Routine') NOT NULL,
  `discharge_date` date DEFAULT NULL,
  `medication` text,
  `test_results` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`patient_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `Doctor` (`doctor_id`),
  CONSTRAINT `age_check` CHECK ((`age` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (2,'Noge Terry',52,'Male','A+','Obesity','2019-08-20',2,'Samantha Davies','Kim Inc','Medicare',33643.33,'265','Emergency','2019-08-26','Ibuprofen','Inconclusive','2024-12-04 12:19:24','2024-12-09 19:35:53'),(3,'Danny Smith',76,'Female','A-','Obesity','2022-09-22',3,'Tiffany Mitchell','Cook PLC','Aetna',27955.10,'205','Emergency','2022-10-07','Aspirin','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(4,'Andrew Watts',28,'Female','O+','Diabetes','2020-11-18',4,'Kevin Wells','Hernandez Rogers and Vang','Medicare',37909.78,'450','Routine','2020-12-18','Ibuprofen',NULL,'2024-12-04 12:19:24','2024-12-09 06:03:30'),(5,'Adrienne Bell',43,'Female','AB+','Cancer','2022-09-19',5,'Kathleen Hanna','White-White','Aetna',14238.32,'458','Emergency','2022-10-09','Penicillin','Abnormal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(6,'Emily Johnson',36,'Male','A+','Asthma','2023-12-20',6,'Taylor Newton','Nunez-Humphrey','UnitedHealthcare',48145.11,'389','Scheduled','2023-12-24','Ibuprofen','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(7,'Edward Edwards',21,'Female','AB-','Diabetes','2020-11-03',7,'Kelly Olson','Group Middleton','Medicare',19580.87,'389','Emergency','2020-11-15','Paracetamol','Inconclusive','2024-12-04 12:19:24','2024-12-04 12:19:24'),(8,'Christina Martinez',20,'Female','A+','Cancer','2021-12-28',8,'Suzanne Thomas','Powell Robinson and Valdez','Cigna',45820.46,'277','Emergency','2022-01-07','Paracetamol','Inconclusive','2024-12-04 12:19:24','2024-12-04 12:19:24'),(9,'Jasmine Aguilar',82,'Male','AB+','Asthma','2020-07-01',9,'Daniel Ferguson','Sons Rich and','Cigna',50119.22,'316','Routine','2020-07-14','Aspirin','Abnormal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(10,'Christopher Berg',58,'Female','AB-','Cancer','2021-05-23',10,'Heather Day','Padilla-Walker','UnitedHealthcare',19784.63,'249','Routine','2021-06-22','Paracetamol','Inconclusive','2024-12-04 12:19:24','2024-12-04 12:19:24'),(11,'Michelle Daniels',72,'Male','O+','Cancer','2020-04-19',11,'John Duncan','Schaefer-Porter','Medicare',12576.80,'394','Emergency','2020-04-22','Paracetamol','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(12,'Aaron Martinez',38,'Female','A-','Hypertension','2023-08-13',12,'Douglas Mayo','Lyons-Blair','Medicare',7999.59,'288','Emergency','2023-09-05','Lipitor','Inconclusive','2024-12-04 12:19:24','2024-12-04 12:19:24'),(13,'Connor Hansen',75,'Female','A+','Diabetes','2019-12-12',13,'Kenneth Fletcher','Powers Miller, and Flores','Cigna',43282.28,'134','Emergency','2019-12-28','Penicillin','Abnormal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(14,'Robert Bauer',68,'Female','AB+','Asthma','2020-05-22',14,'Theresa Freeman','Rivera-Gutierrez','UnitedHealthcare',33207.71,'309','Scheduled','2020-06-19','Lipitor','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(15,'Brooke Brady',44,'Female','AB+','Cancer','2021-10-08',15,'Roberta Stewart','Morris-Arellano','UnitedHealthcare',40701.60,'182','Scheduled','2021-10-13','Paracetamol','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(16,'Ms. Natalie Gamble',46,'Female','AB-','Obesity','2023-01-01',16,'Maria Dougherty','Cline-Williams','Blue Cross',12263.36,'465','Routine','2023-01-11','Aspirin','Inconclusive','2024-12-04 12:19:24','2024-12-04 12:19:24'),(17,'Haley Perkins',63,'Female','A+','Arthritis','2020-06-23',17,'Erica Spencer','Cervantes-Wells','UnitedHealthcare',24499.85,'114','Emergency','2020-07-14','Paracetamol','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(18,'Mrs. Jamie Campbell',38,'Male','AB-','Obesity','2020-03-08',18,'Justin Kim','Torres, and Harrison Jones','Cigna',17440.47,'449','Emergency','2020-04-02','Paracetamol','Abnormal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(19,'Luke Burgess',34,'Female','A-','Hypertension','2021-03-04',19,'Justin Moore Jr.','Houston PLC','Blue Cross',18843.02,'260','Routine','2021-03-14','Aspirin','Abnormal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(20,'Daniel Schmidt',63,'Male','B+','Asthma','2022-11-15',20,'Denise Galloway','Hammond Ltd','Cigna',23762.20,'465','Emergency','2022-11-22','Penicillin','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(21,'Timothy Burns',67,'Female','A-','Asthma','2023-06-28',21,'Krista Smith','Jones LLC','Blue Cross',42.51,'115','Scheduled','2023-07-02','Aspirin','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(22,'Christopher Bright',48,'Male','B+','Asthma','2020-01-21',22,'Gregory Smith','Williams-Davis','Aetna',17695.91,'295','Emergency','2020-02-09','Lipitor','Normal','2024-12-04 12:19:24','2024-12-04 12:19:24'),(23,'Kathryn Noge',58,'Female','O+','Arthritis','2022-05-12',23,'Vanessa Newton','Clark-Mayo','Aetna',5998.10,'327','Emergency','2022-06-10','Lipitor','Inconclusive','2024-12-04 12:19:24','2024-12-10 01:46:07'),(30,'Noge Mijid',23,'Male','O+','Cold','2024-12-10',2,'Samantha Davies','City Hospital','HealthCare Inc',2009.08,'101','Emergency','2024-12-12','Iburprofen','Normal','2024-12-10 01:47:40','2024-12-10 01:47:40');
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PatientDoctor`
--

DROP TABLE IF EXISTS `PatientDoctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PatientDoctor` (
  `patient_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  PRIMARY KEY (`patient_id`,`doctor_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `patientdoctor_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `Patient` (`patient_id`),
  CONSTRAINT `patientdoctor_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `Doctor` (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PatientDoctor`
--

LOCK TABLES `PatientDoctor` WRITE;
/*!40000 ALTER TABLE `PatientDoctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `PatientDoctor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 16:14:28
