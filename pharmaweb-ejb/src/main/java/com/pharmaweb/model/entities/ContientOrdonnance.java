package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONTIENT_ORDONNANCE database table.
 * 
 */
@Entity
@Table(name="CONTIENT_ORDONNANCE")
@NamedQuery(name="ContientOrdonnance.findAll", query="SELECT c FROM ContientOrdonnance c")
public class ContientOrdonnance implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContientOrdonnancePK id;

	@Lob
	private String posologie;

	@Column(name="QUANTITE_ORDONNANCE")
	private BigDecimal quantiteOrdonnance;

	//bi-directional many-to-one association to Ordonnance
	@ManyToOne
	@JoinColumn(name="ID_ORDONNANCE")
	private Ordonnance ordonnance;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="ID_PRODUIT")
	private Produit produit;

	public ContientOrdonnance() {
	}

	public ContientOrdonnancePK getId() {
		return this.id;
	}

	public void setId(ContientOrdonnancePK id) {
		this.id = id;
	}

	public String getPosologie() {
		return this.posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public BigDecimal getQuantiteOrdonnance() {
		return this.quantiteOrdonnance;
	}

	public void setQuantiteOrdonnance(BigDecimal quantiteOrdonnance) {
		this.quantiteOrdonnance = quantiteOrdonnance;
	}

	public Ordonnance getOrdonnance() {
		return this.ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}