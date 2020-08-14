package fr.ibformation.parkingvinci.beans;

import java.util.ArrayList;
import java.util.List;

import fr.ibformation.parkingvinci.managers.ParkingManager;
import fr.ibformation.parkingvinci.managers.ParkingManagerImpl;

public class Parking {

	private final int NOMBRE_PLACE_MAX = 5;
	private final int TARIF_BASE = 50;
	private final int MINUTES_AVANT_SUPPLEMENT = 10;
	private final int TARIF_SUPPLEMENTAIRE = 4;
	private List<Voiture> voitures = new ArrayList<>();
	
	public Parking() {
		// TODO Auto-generated constructor stub
	}

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public int getNOMBRE_PLACE_MAX() {
		return NOMBRE_PLACE_MAX;
	}

	public int getTARIF_BASE() {
		return TARIF_BASE;
	}

	public int getTARIF_SUPPLEMENTAIRE() {
		return TARIF_SUPPLEMENTAIRE;
	}
	
	
	public int getMINUTES_AVANT_SUPPLEMENT() {
		return MINUTES_AVANT_SUPPLEMENT;
	}

	public int getNombrePlacesRestantes(){
		return this.getNOMBRE_PLACE_MAX() - this.getVoitures().size();
	}

	public void ajouterVoiture(String immatriculation) {
		// si le parking n'est pas plein
		if(this.getVoitures().size() < this.getNOMBRE_PLACE_MAX()){
			// pour éviter les voitures avec la même plaque d'immatriculation
			if(!this.getVoitures().contains(new Voiture(immatriculation))){
				this.getVoitures().add(new Voiture(immatriculation));			
			}
		}

	}
	@Override
	public String toString() {
		return "Parking [NOMBRE_PLACE_MAX=" + NOMBRE_PLACE_MAX + ", TARIF_BASE=" + TARIF_BASE
				+ ", TARIF_SUPPLEMENTAIRE=" + TARIF_SUPPLEMENTAIRE + ", voitures=" + voitures + "]";
	}

	/**
	 * Retire la voiture de la liste et renvoie le prix à payer en euros
	 * @param immatriculation
	 * @return
	 */
	public double sortirVoiture(String immatriculation) {
		double prix = 0;
		ParkingManager parkingManager = new ParkingManagerImpl();
		int index = this.getVoitures().indexOf(new Voiture(immatriculation));
		// gérer le cas ou la voiture n'est pas dans la liste
		if(index != -1){
			prix = parkingManager.calculPaiement(this.getVoitures().get(index), this.TARIF_BASE,
					this.TARIF_SUPPLEMENTAIRE, this.MINUTES_AVANT_SUPPLEMENT);
			this.getVoitures().remove(index);			
		}
		return prix;
	}
	
	
}
