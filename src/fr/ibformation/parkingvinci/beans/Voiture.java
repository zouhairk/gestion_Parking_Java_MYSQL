package fr.ibformation.parkingvinci.beans;

import java.time.LocalDateTime;

public class Voiture {

	private String immatriculation;
	private LocalDateTime dateHeureEntree;
	
	public Voiture() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Fabrique une voiture en mettant la date et l'heure du système dans dateHeureEntree
	 * @param immatriculation
	 */
	public Voiture(String immatriculation) {
		this(immatriculation, LocalDateTime.now());
	}

	public Voiture(String immatriculation, LocalDateTime dateHeureEntree) {
		super();
		this.immatriculation = immatriculation;
		this.dateHeureEntree = dateHeureEntree;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public LocalDateTime getDateHeureEntree() {
		return dateHeureEntree;
	}

	public void setDateHeureEntree(LocalDateTime dateHeureEntree) {
		this.dateHeureEntree = dateHeureEntree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((immatriculation == null) ? 0 : immatriculation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voiture other = (Voiture) obj;
		if (immatriculation == null) {
			if (other.immatriculation != null)
				return false;
		} else if (!immatriculation.equals(other.immatriculation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voiture [immatriculation=" + immatriculation + ", dateHeureEntree=" + dateHeureEntree + "]";
	}
	
}
