package fr.ibformation.parkingvinci.ihm;

import java.util.Scanner;

import fr.ibformation.parkingvinci.beans.Parking;
import fr.ibformation.parkingvinci.beans.Voiture;

public class Launcher {

	public static void main(String[] args) {

		Parking parking = new Parking();
		int saisie;
		String immatriculation;
		
		do {
			afficherMenu(parking);
			saisie = choixMenuUtilisateur();
			switch (saisie) {
			case 1:
				immatriculation = choixImatriculationUtilisateur();
				parking.ajouterVoiture(immatriculation);
				break;
			case 2 :
				immatriculation = choixImatriculationUtilisateur();
				double prix = parking.sortirVoiture(immatriculation);
				if(prix != 0){
					System.out.println("Vous devez payer " + prix + " euros.");					
				}
				break;
			case 3 :
				afficherVoiture(parking);
				break;
			}		
		} while(saisie !=4);
		
	}

	private static void afficherVoiture(Parking parking) {
		if(parking.getVoitures().isEmpty()){
			System.out.println("Le parking est vide");
		} else {
			for (Voiture voiture : parking.getVoitures()) {
				System.out.println(voiture);
			}
		}
		
	}

	private static String choixImatriculationUtilisateur() {
		System.out.println("Merci de saisir la plaque : ");
		Scanner sc = new Scanner(System.in);
		String immatriculation = sc.nextLine();
		return immatriculation;
	}

	private static int choixMenuUtilisateur() {
		Scanner sc = new Scanner(System.in);
		int saisie = sc.nextInt();
		return saisie;
	}

	private static void afficherMenu(Parking parking) {
		System.out.println("Bienvenue dans le parking VINCI - Places disponibles : " 
							+ parking.getNombrePlacesRestantes());
		System.out.println("1 - Ajouter une voiture");
		System.out.println("2 - Faire sortir une voiture");
		System.out.println("3 - Afficher la liste des voitures du parking");
		System.out.println("4 - Quitter");
	}

}
