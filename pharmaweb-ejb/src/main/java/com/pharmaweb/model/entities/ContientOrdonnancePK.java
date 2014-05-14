package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONTIENT_ORDONNANCE database table.
 * 
 */
@Embeddable
public class ContientOrdonnancePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_ORDONNANCE", insertable=false, updatable=false)
	private long idOrdonnance;

	@Column(name="ID_PRODUIT", insertable=false, updatable=false)
	private long idProduit;

	public ContientOrdonnancePK() {
	}
	public long getIdOrdonnance() {
		return this.idOrdonnance;
	}
	public void setIdOrdonnance(long idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
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
		if (!(other instanceof ContientOrdonnancePK)) {
			return false;
		}
		ContientOrdonnancePK castOther = (ContientOrdonnancePK)other;
		return 
			(this.idOrdonnance == castOther.idOrdonnance)
			&& (this.idProduit == castOther.idProduit);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idOrdonnance ^ (this.idOrdonnance >>> 32)));
		hash = hash * prime + ((int) (this.idProduit ^ (this.idProduit >>> 32)));
		
		return hash;
	}
}