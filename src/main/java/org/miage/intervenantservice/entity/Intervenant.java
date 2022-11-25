package org.miage.intervenantservice.entity;

import java.util.UUID;
import org.springframework.data.annotation.Id;

public class Intervenant { 

	@Id
	private UUID id;
	private String nom;		
	private String prenom;
	private String commune;
	private String codepostal; // to be changed into value object

	@Override
	public String toString() {
		return "Intervenant [codepostal=" + codepostal + ", commune=" + commune + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}

	public Intervenant(UUID id, String nom, String prenom, String commune, String codepostal) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.commune = commune;
		this.codepostal = codepostal;
	}

	public Intervenant() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codepostal == null) ? 0 : codepostal.hashCode());
		result = prime * result + ((commune == null) ? 0 : commune.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Intervenant other = (Intervenant) obj;
		if (codepostal == null) {
			if (other.codepostal != null)
				return false;
		} else if (!codepostal.equals(other.codepostal))
			return false;
		if (commune == null) {
			if (other.commune != null)
				return false;
		} else if (!commune.equals(other.commune))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}


}
