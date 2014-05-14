package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TAUX_REMBOURSEMENT_MUTUELLE database table.
 * 
 */
@Entity
@Table(name="TAUX_REMBOURSEMENT_MUTUELLE")
@NamedQuery(name="TauxRemboursementMutuelle.findAll", query="SELECT t FROM TauxRemboursementMutuelle t")
public class TauxRemboursementMutuelle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TAUX_REMBOURSEMENT_MUTUELLE")
	private long idTauxRemboursementMutuelle;

	@Column(name="TAUX_TAUX_REMB_MUTUELLE")
	private BigDecimal tauxTauxRembMutuelle;

	//bi-directional many-to-one association to Cotisation
	@ManyToOne
	@JoinColumn(name="ID_COTISATION")
	private Cotisation cotisation;

	//bi-directional many-to-one association to TypeDeRemboursement
	@ManyToOne
	@JoinColumn(name="ID_TYPE_DE_REMBOURSEMENT")
	private TypeDeRemboursement typeDeRemboursement;

	public TauxRemboursementMutuelle() {
	}

	public long getIdTauxRemboursementMutuelle() {
		return this.idTauxRemboursementMutuelle;
	}

	public void setIdTauxRemboursementMutuelle(long idTauxRemboursementMutuelle) {
		this.idTauxRemboursementMutuelle = idTauxRemboursementMutuelle;
	}

	public BigDecimal getTauxTauxRembMutuelle() {
		return this.tauxTauxRembMutuelle;
	}

	public void setTauxTauxRembMutuelle(BigDecimal tauxTauxRembMutuelle) {
		this.tauxTauxRembMutuelle = tauxTauxRembMutuelle;
	}

	public Cotisation getCotisation() {
		return this.cotisation;
	}

	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
	}

	public TypeDeRemboursement getTypeDeRemboursement() {
		return this.typeDeRemboursement;
	}

	public void setTypeDeRemboursement(TypeDeRemboursement typeDeRemboursement) {
		this.typeDeRemboursement = typeDeRemboursement;
	}

}