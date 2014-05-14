package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TAUX_REMBOURSEMENT_SECU database table.
 * 
 */
@Entity
@Table(name="TAUX_REMBOURSEMENT_SECU")
@NamedQuery(name="TauxRemboursementSecu.findAll", query="SELECT t FROM TauxRemboursementSecu t")
public class TauxRemboursementSecu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TAUX_REMBOURSEMENT_SECU")
	private long idTauxRemboursementSecu;

	@Column(name="TAUX_REMBOURSEMENT_SECU")
	private BigDecimal tauxRemboursementSecu;

	@Column(name="TAUX_TAUX_REMBOURSEMENT_SECU")
	private BigDecimal tauxTauxRemboursementSecu;

	//bi-directional many-to-one association to Statut
	@ManyToOne
	@JoinColumn(name="ID_STATUT")
	private Statut statut;

	//bi-directional many-to-one association to TypeDeRemboursement
	@ManyToOne
	@JoinColumn(name="ID_TYPE_DE_REMBOURSEMENT")
	private TypeDeRemboursement typeDeRemboursement;

	public TauxRemboursementSecu() {
	}

	public long getIdTauxRemboursementSecu() {
		return this.idTauxRemboursementSecu;
	}

	public void setIdTauxRemboursementSecu(long idTauxRemboursementSecu) {
		this.idTauxRemboursementSecu = idTauxRemboursementSecu;
	}

	public BigDecimal getTauxRemboursementSecu() {
		return this.tauxRemboursementSecu;
	}

	public void setTauxRemboursementSecu(BigDecimal tauxRemboursementSecu) {
		this.tauxRemboursementSecu = tauxRemboursementSecu;
	}

	public BigDecimal getTauxTauxRemboursementSecu() {
		return this.tauxTauxRemboursementSecu;
	}

	public void setTauxTauxRemboursementSecu(BigDecimal tauxTauxRemboursementSecu) {
		this.tauxTauxRemboursementSecu = tauxTauxRemboursementSecu;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public TypeDeRemboursement getTypeDeRemboursement() {
		return this.typeDeRemboursement;
	}

	public void setTypeDeRemboursement(TypeDeRemboursement typeDeRemboursement) {
		this.typeDeRemboursement = typeDeRemboursement;
	}

}