package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FOURNIT database table.
 * 
 */
@Embeddable
public class FournisseurProduitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_FOURNISSEUR", insertable=false, updatable=false)
	private long idFournisseur;

	@Column(name="ID_PRODUIT", insertable=false, updatable=false)
	private long idProduit;

	public FournisseurProduitPK() {
	}
	public long getIdFournisseur() {
		return this.idFournisseur;
	}
	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public long getIdProduit() {
		return this.idProduit;
	}
	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FournisseurProduitPK)) {
			return false;
		}
		FournisseurProduitPK castOther = (FournisseurProduitPK)other;
		return 
			(this.idFournisseur == castOther.idFournisseur)
			&& (this.idProduit == castOther.idProduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFournisseur ^ (this.idFournisseur >>> 32)));
		hash = hash * prime + ((int) (this.idProduit ^ (this.idProduit >>> 32)));
		
		return hash;
	}
}