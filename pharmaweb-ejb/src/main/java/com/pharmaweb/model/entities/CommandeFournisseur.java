package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the COMMANDE_FOURNISSEUR database table.
 * 
 */
@Entity
@Table(name="COMMANDE_FOURNISSEUR")
@NamedQuery(name="CommandeFournisseur.findAll", query="SELECT c FROM CommandeFournisseur c")
public class CommandeFournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_COMMANDE_FOURNISSEUR")
	private long idCommandeFournisseur;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_COMMANDE_FOURNISSEUR")
	private Date dateCommandeFournisseur;

	@Lob
	@Column(name="NUM_COMMANDE_FOURNISSEUR")
	private String numCommandeFournisseur;

	@Column(name="STATUT_COMMANDE_FOURNISSEUR")
	private String statutCommandeFournisseur;

	//bi-directional many-to-one association to Pharmacie
	@ManyToOne
	@JoinColumn(name="ID_PHARMACIE")
	private Pharmacie pharmacie;

	//bi-directional many-to-one association to CommandeFournisseurProduit
	@OneToMany(mappedBy="commandeFournisseur")
	private List<CommandeFournisseurProduit> estDansLaCommandeFous;

	public CommandeFournisseur() {
	}

	public long getIdCommandeFournisseur() {
		return this.idCommandeFournisseur;
	}

	public void setIdCommandeFournisseur(long idCommandeFournisseur) {
		this.idCommandeFournisseur = idCommandeFournisseur;
	}

	public Date getDateCommandeFournisseur() {
		return this.dateCommandeFournisseur;
	}

	public void setDateCommandeFournisseur(Date dateCommandeFournisseur) {
		this.dateCommandeFournisseur = dateCommandeFournisseur;
	}

	public String getNumCommandeFournisseur() {
		return this.numCommandeFournisseur;
	}

	public void setNumCommandeFournisseur(String numCommandeFournisseur) {
		this.numCommandeFournisseur = numCommandeFournisseur;
	}

	public String getStatutCommandeFournisseur() {
		return this.statutCommandeFournisseur;
	}

	public void setStatutCommandeFournisseur(String statutCommandeFournisseur) {
		this.statutCommandeFournisseur = statutCommandeFournisseur;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public List<CommandeFournisseurProduit> getEstDansLaCommandeFous() {
		return this.estDansLaCommandeFous;
	}

	public void setEstDansLaCommandeFous(List<CommandeFournisseurProduit> estDansLaCommandeFous) {
		this.estDansLaCommandeFous = estDansLaCommandeFous;
	}

	public CommandeFournisseurProduit addEstDansLaCommandeFous(CommandeFournisseurProduit estDansLaCommandeFous) {
		getEstDansLaCommandeFous().add(estDansLaCommandeFous);
		estDansLaCommandeFous.setCommandeFournisseur(this);

		return estDansLaCommandeFous;
	}

	public CommandeFournisseurProduit removeEstDansLaCommandeFous(CommandeFournisseurProduit estDansLaCommandeFous) {
		getEstDansLaCommandeFous().remove(estDansLaCommandeFous);
		estDansLaCommandeFous.setCommandeFournisseur(null);

		return estDansLaCommandeFous;
	}

}