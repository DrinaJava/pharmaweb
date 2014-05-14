package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ADRESSE database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ADRESSE")
	private long idAdresse;

	@Lob
	@Column(name="ADRESSE_ADRESSE")
	private String adresseAdresse;

	@Column(name="CODE_POSTAL_ADRESSE")
	private BigDecimal codePostalAdresse;

	@Lob
	@Column(name="COMPLEMENT_ADRESSE")
	private String complementAdresse;

	@Lob
	@Column(name="VILLE_ADRESSE")
	private String villeAdresse;

	//bi-directional many-to-one association to CentreMutuelle
	@OneToMany(mappedBy="adresse")
	private List<CentreMutuelle> centreMutuelles;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="adresse")
	private List<Client> clients;

	//bi-directional many-to-one association to CommandeClient
	@OneToMany(mappedBy="adresse")
	private List<CommandeClient> commandeClients;

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="adresse")
	private List<Fournisseur> fournisseurs;

	//bi-directional many-to-one association to Medecin
	@OneToMany(mappedBy="adresse")
	private List<Medecin> medecins;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="adresse")
	private List<Ordonnance> ordonnances;

	//bi-directional many-to-one association to Pharmacie
	@OneToMany(mappedBy="adresse")
	private List<Pharmacie> pharmacies;

	public Adresse() {
	}

	public long getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getAdresseAdresse() {
		return this.adresseAdresse;
	}

	public void setAdresseAdresse(String adresseAdresse) {
		this.adresseAdresse = adresseAdresse;
	}

	public BigDecimal getCodePostalAdresse() {
		return this.codePostalAdresse;
	}

	public void setCodePostalAdresse(BigDecimal codePostalAdresse) {
		this.codePostalAdresse = codePostalAdresse;
	}

	public String getComplementAdresse() {
		return this.complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getVilleAdresse() {
		return this.villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public List<CentreMutuelle> getCentreMutuelles() {
		return this.centreMutuelles;
	}

	public void setCentreMutuelles(List<CentreMutuelle> centreMutuelles) {
		this.centreMutuelles = centreMutuelles;
	}

	public CentreMutuelle addCentreMutuelle(CentreMutuelle centreMutuelle) {
		getCentreMutuelles().add(centreMutuelle);
		centreMutuelle.setAdresse(this);

		return centreMutuelle;
	}

	public CentreMutuelle removeCentreMutuelle(CentreMutuelle centreMutuelle) {
		getCentreMutuelles().remove(centreMutuelle);
		centreMutuelle.setAdresse(null);

		return centreMutuelle;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setAdresse(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setAdresse(null);

		return client;
	}

	public List<CommandeClient> getCommandeClients() {
		return this.commandeClients;
	}

	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

	public CommandeClient addCommandeClient(CommandeClient commandeClient) {
		getCommandeClients().add(commandeClient);
		commandeClient.setAdresse(this);

		return commandeClient;
	}

	public CommandeClient removeCommandeClient(CommandeClient commandeClient) {
		getCommandeClients().remove(commandeClient);
		commandeClient.setAdresse(null);

		return commandeClient;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		getFournisseurs().add(fournisseur);
		fournisseur.setAdresse(this);

		return fournisseur;
	}

	public Fournisseur removeFournisseur(Fournisseur fournisseur) {
		getFournisseurs().remove(fournisseur);
		fournisseur.setAdresse(null);

		return fournisseur;
	}

	public List<Medecin> getMedecins() {
		return this.medecins;
	}

	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}

	public Medecin addMedecin(Medecin medecin) {
		getMedecins().add(medecin);
		medecin.setAdresse(this);

		return medecin;
	}

	public Medecin removeMedecin(Medecin medecin) {
		getMedecins().remove(medecin);
		medecin.setAdresse(null);

		return medecin;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public Ordonnance addOrdonnance(Ordonnance ordonnance) {
		getOrdonnances().add(ordonnance);
		ordonnance.setAdresse(this);

		return ordonnance;
	}

	public Ordonnance removeOrdonnance(Ordonnance ordonnance) {
		getOrdonnances().remove(ordonnance);
		ordonnance.setAdresse(null);

		return ordonnance;
	}

	public List<Pharmacie> getPharmacies() {
		return this.pharmacies;
	}

	public void setPharmacies(List<Pharmacie> pharmacies) {
		this.pharmacies = pharmacies;
	}

	public Pharmacie addPharmacy(Pharmacie pharmacy) {
		getPharmacies().add(pharmacy);
		pharmacy.setAdresse(this);

		return pharmacy;
	}

	public Pharmacie removePharmacy(Pharmacie pharmacy) {
		getPharmacies().remove(pharmacy);
		pharmacy.setAdresse(null);

		return pharmacy;
	}

}