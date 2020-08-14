package fr.ibformation.parkingvinci.managers;

import fr.ibformation.parkingvinci.beans.Parking;
import fr.ibformation.parkingvinci.beans.Voiture;

public interface ParkingManager {

	public double calculPaiement(Voiture voiture, int tarifBase, int tarifSupp, int minutesAvantSupp);
}
