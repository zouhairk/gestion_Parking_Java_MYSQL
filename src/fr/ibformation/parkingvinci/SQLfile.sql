CREATE DATABASE IF NOT EXISTS BDD_Parking;
USE
  BDD_Parking;
CREATE TABLE IF NOT EXISTS Voiture(
  id INT PRIMARY KEY AUTO_INCREMENT,
  immatriculation VARCHAR(20) NOT NULL UNIQUE,
  dateHeureEntree TIMESTAMP 
);
SELECT
  *
FROM
  Voiture;