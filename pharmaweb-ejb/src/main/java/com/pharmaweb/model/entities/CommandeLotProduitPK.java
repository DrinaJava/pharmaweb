package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EST_DANS_LA_COMMANDE_CLIENT database table.
 * 
 */
@Embeddable
public class CommandeLotProduitPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_COMMANDE_CLIENT", insertable=false, updatable=false)
	private long idCommandeClient;

	@Column(name="ID_LOT_PRODUIT", insertable=false, updatable=false)
	private long idLotProduit;

	public CommandeLotProduitPK() {
	}
	public long getIdCommandeClient() {
		return this.idCommandeClient;
	}
	public void setIdCommandeClient(long idCommandeClient) {
		this.idCommandeClient = idCommandeClient;
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
		if (!(other instanceof CommandeLotProduitPK)) {
			return false;
		}
		CommandeLotProduitPK castOther = (CommandeLotProduitPK)other;
		return 
			(this.idCommandeClient == castOther.idCommandeClient)
			&& (this.idLotProduit == castOther.idLotProduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idCommandeClient ^ (this.idCommandeClient >>> 32)));
		hash = hash * prime + ((int) (this.idLotProduit ^ (this.idLotProduit >>> 32)));
		
		return hash;
	}
}