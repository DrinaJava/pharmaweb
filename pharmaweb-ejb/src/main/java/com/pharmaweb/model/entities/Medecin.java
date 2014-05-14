package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEDECIN database table.
 * 
 */
@Entity
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MEDECIN")
	private long idMedecin;

	@Lob
	@Column(name="NOM_MEDECIN")
	private String nomMedecin;

	@Lob
	@Column(name="NUMERO_AGREMENT_MEDECIN")
	private String numeroAgrementMedecin;

	@Lob
	@Column(name="PRENOM_MEDECIN")
	private String prenomMedecin;

	@Lob
	@Column(name="SPECIALITE_MEDECIN")
	private String specialiteMedecin;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="medecin")
	private List<Client> clients;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="medecin")
	private List<Ordonnance> ordonnances;

	public Medecin() {
	}

	public long getIdMedecin() {
		return this.idMedecin;
	}

	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getNomMedecin() {
		return this.nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getNumeroAgrementMedecin() {
		return this.numeroAgrementMedecin;
	}

	public void setNumeroAgrementMedecin(String numeroAgrementMedecin) {
		this.numeroAgrementMedecin = numeroAgrementMedecin;
	}

	public String getPrenomMedecin() {
		return this.prenomMedecin;
	}

	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}

	public String getSpecialiteMedecin() {
		return this.specialiteMedecin;
	}

	public void setSpecialiteMedecin(String specialiteMedecin) {
		this.specialiteMedecin = specialiteMedecin;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setMedecin(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setMedecin(null);

		return client;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public Ordonnance addOrdonnance(Ordonnance ordonnance) {
		getOrdonnances().add(ordonnance);
		ordonnance.setMedecin(this);

		return ordonnance;
	}

	public Ordonnance removeOrdonnance(Ordonnance ordonnance) {
		getOrdonnances().remove(ordonnance);
		ordonnance.setMedecin(null);

		return ordonnance;
	}

}