package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PHARMACIE database table.
 * 
 */
@Entity
@NamedQuery(name="Pharmacie.findAll", query="SELECT p FROM Pharmacie p")
public class Pharmacie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PHARMACIE")
	private long idPharmacie;

	@Lob
	@Column(name="MAIL_PHARMACIE")
	private String mailPharmacie;

	@Lob
	@Column(name="NOM_PHARMACIE")
	private String nomPharmacie;

	@Column(name="TELEPHONE_PHARMACIE")
	private String telephonePharmacie;

	//bi-directional many-to-one association to PharmacieStock
	@OneToMany(mappedBy="pharmacie")
	private List<PharmacieStock> AEnStocks;

	//bi-directional many-to-one association to CommandeClient
	@OneToMany(mappedBy="pharmacie")
	private List<CommandeClient> commandeClients;

	//bi-directional many-to-one association to CommandeFournisseur
	@OneToMany(mappedBy="pharmacie")
	private List<CommandeFournisseur> commandeFournisseurs;

	//bi-directional many-to-one association to Employe
	@OneToMany(mappedBy="pharmacie")
	private List<Employe> employes;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	public Pharmacie() {
	}

	public long getIdPharmacie() {
		return this.idPharmacie;
	}

	public void setIdPharmacie(long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public String getMailPharmacie() {
		return this.mailPharmacie;
	}

	public void setMailPharmacie(String mailPharmacie) {
		this.mailPharmacie = mailPharmacie;
	}

	public String getNomPharmacie() {
		return this.nomPharmacie;
	}

	public void setNomPharmacie(String nomPharmacie) {
		this.nomPharmacie = nomPharmacie;
	}

	public String getTelephonePharmacie() {
		return this.telephonePharmacie;
	}

	public void setTelephonePharmacie(String telephonePharmacie) {
		this.telephonePharmacie = telephonePharmacie;
	}

	public List<PharmacieStock> getAEnStocks() {
		return this.AEnStocks;
	}

	public void setAEnStocks(List<PharmacieStock> AEnStocks) {
		this.AEnStocks = AEnStocks;
	}

	public PharmacieStock addAEnStock(PharmacieStock AEnStock) {
		getAEnStocks().add(AEnStock);
		AEnStock.setPharmacie(this);

		return AEnStock;
	}

	public PharmacieStock removeAEnStock(PharmacieStock AEnStock) {
		getAEnStocks().remove(AEnStock);
		AEnStock.setPharmacie(null);

		return AEnStock;
	}

	public List<CommandeClient> getCommandeClients() {
		return this.commandeClients;
	}

	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

	public CommandeClient addCommandeClient(CommandeClient commandeClient) {
		getCommandeClients().add(commandeClient);
		commandeClient.setPharmacie(this);

		return commandeClient;
	}

	public CommandeClient removeCommandeClient(CommandeClient commandeClient) {
		getCommandeClients().remove(commandeClient);
		commandeClient.setPharmacie(null);

		return commandeClient;
	}

	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return this.commandeFournisseurs;
	}

	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}

	public CommandeFournisseur addCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		getCommandeFournisseurs().add(commandeFournisseur);
		commandeFournisseur.setPharmacie(this);

		return commandeFournisseur;
	}

	public CommandeFournisseur removeCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		getCommandeFournisseurs().remove(commandeFournisseur);
		commandeFournisseur.setPharmacie(null);

		return commandeFournisseur;
	}

	public List<Employe> getEmployes() {
		return this.employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe addEmploye(Employe employe) {
		getEmployes().add(employe);
		employe.setPharmacie(this);

		return employe;
	}

	public Employe removeEmploye(Employe employe) {
		getEmployes().remove(employe);
		employe.setPharmacie(null);

		return employe;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}