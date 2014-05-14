package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the A_EN_STOCK database table.
 * 
 */
@Embeddable
public class PharmacieStockPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_LOT_PRODUIT", insertable=false, updatable=false)
	private long idLotProduit;

	@Column(name="ID_PHARMACIE", insertable=false, updatable=false)
	private long idPharmacie;

	public PharmacieStockPK() {
	}
	public long getIdLotProduit() {
		return this.idLotProduit;
	}
	public void setIdLotProduit(long idLotProduit) {
		this.idLotProduit = idLotProduit;
	}
	public long getIdPharmacie() {
		return this.idPharmacie;
	}
	public void setIdPharmacie(long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PharmacieStockPK)) {
			return false;
		}
		PharmacieStockPK castOther = (PharmacieStockPK)other;
		return 
			(this.idLotProduit == castOther.idLotProduit)
			&& (this.idPharmacie == castOther.idPharmacie);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idLotProduit ^ (this.idLotProduit >>> 32)));
		hash = hash * prime + ((int) (this.idPharmacie ^ (this.idPharmacie >>> 32)));
		
		return hash;
	}
}