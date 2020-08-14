package fr.ibformation.parkingvinci.managers;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import fr.ibformation.parkingvinci.beans.Voiture;

public class ParkingManagerImpl implements ParkingManager {

	@Override
	/**
	 * Le prix est en euros
	 */
	public double calculPaiement(Voiture voiture, int tarifBase, int tarifSupp, int minutesAvantSupp) {
		double prix = tarifBase;
		double minutesVoitureDansParking = 
				ChronoUnit.MINUTES.between(voiture.getDateHeureEntree(), LocalDateTime.now());
		if(minutesVoitureDansParking > minutesAvantSupp){
			prix += (minutesVoitureDansParking - minutesAvantSupp) * tarifSupp;
		}
		
		return prix / 100;
	}
	

}
