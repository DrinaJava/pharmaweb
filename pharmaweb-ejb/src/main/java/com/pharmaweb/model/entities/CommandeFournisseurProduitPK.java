package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EST_DANS_LA_COMMANDE_FOU database table.
 * 
 */
@Embeddable
public class CommandeFournisseurProduitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_COMMANDE_FOURNISSEUR", insertable=false, updatable=false)
	private long idCommandeFournisseur;

	@Column(name="ID_LOT_PRODUIT", insertable=false, updatable=false)
	private long idLotProduit;

	public CommandeFournisseurProduitPK() {
	}
	public long getIdCommandeFournisseur() {
		return this.idCommandeFournisseur;
	}
	public void setIdCommandeFournisseur(long idCommandeFournisseur) {
		this.idCommandeFournisseur = idCommandeFournisseur;
	}
	public long getIdLotProduit() {
		return this.idLotProduit;
	}
	public void setIdLotProduit(long idLotProduit) {
		this.idLotProduit = idLotProduit;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommandeFournisseurProduitPK)) {
			return false;
		}
		CommandeFournisseurProduitPK castOther = (CommandeFournisseurProduitPK)other;
		return 
			(this.idCommandeFournisseur == castOther.idCommandeFournisseur)
			&& (this.idLotProduit == castOther.idLotProduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idCommandeFournisseur ^ (this.idCommandeFournisseur >>> 32)));
		hash = hash * prime + ((int) (this.idLotProduit ^ (this.idLotProduit >>> 32)));
		
		return hash;
	}
}