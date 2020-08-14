package fr.ibformation.parkingvinci.managers;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import fr.ibformation.parkingvinci.beans.Voiture;

public class ParkingManagerImplTest {

	@Test
	public void testCalculPaiementTarifBase() {
		// GIVEN - WHEN - THEN

		// GIVEN
		ParkingManager parkingManager = new ParkingManagerImpl();

		int tarifBase = 50;
		int tarifSupp = 4;
		int minutesAvantSupp = 10;

		Voiture voiture = new Voiture();
		voiture.setDateHeureEntree(LocalDateTime.now().minusMinutes(5));
		// WHEN
		double prix = parkingManager.calculPaiement(voiture, tarifBase, tarifSupp, minutesAvantSupp);

		// THEN
		assertEquals(0.50, prix, 0);

	}

	@Test
	public void testCalculPaiementTarifSup() {
		// GIVEN - WHEN - THEN

		// GIVEN
		ParkingManager parkingManager = new ParkingManagerImpl();

		int tarifBase = 50;
		int tarifSupp = 4;
		int minutesAvantSupp = 10;

		Voiture voiture = new Voiture();
		voiture.setDateHeureEntree(LocalDateTime.now().minusMinutes(13));
		// WHEN
		double prix = parkingManager.calculPaiement(voiture, tarifBase, tarifSupp, minutesAvantSupp);

		// THEN
		assertEquals(0.62, prix, 0);
	}

	@Test
	public void testCalculPaiementVoitureEntranteSortante() {
		// GIVEN - WHEN - THEN

		// GIVEN
		ParkingManager parkingManager = new ParkingManagerImpl();

		int tarifBase = 50;
		int tarifSupp = 4;
		int minutesAvantSupp = 10;

		Voiture voiture = new Voiture();
		voiture.setDateHeureEntree(LocalDateTime.now());
		// WHEN
		double prix = parkingManager.calculPaiement(voiture, tarifBase, tarifSupp, minutesAvantSupp);

		// THEN
		assertEquals(0.50, prix, 0);
	}

	@Test
	public void testCalculPaiementVoitureDepuis3Jours() {
		// GIVEN - WHEN - THEN

		// GIVEN
		ParkingManager parkingManager = new ParkingManagerImpl();

		int tarifBase = 50;
		int tarifSupp = 4;
		int minutesAvantSupp = 10;

		Voiture voiture = new Voiture();
		voiture.setDateHeureEntree(LocalDateTime.now().minusDays(3));
		// WHEN
		double prix = parkingManager.calculPaiement(voiture, tarifBase, tarifSupp, minutesAvantSupp);

		// THEN
		assertEquals(172.9, prix, 0);
	}

}
