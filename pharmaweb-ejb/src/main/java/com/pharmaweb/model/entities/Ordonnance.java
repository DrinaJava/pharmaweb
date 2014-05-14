package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDONNANCE database table.
 * 
 */
@Entity
@NamedQuery(name="Ordonnance.findAll", query="SELECT o FROM Ordonnance o")
public class Ordonnance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ORDONNANCE")
	private long idOrdonnance;

	@Lob
	@Column(name="CHEMIN_ORDONNANCE")
	private String cheminOrdonnance;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ORDONNANCE")
	private Date dateOrdonnance;

	@Lob
	@Column(name="VALIDITE_ORDONNANCE")
	private String validiteOrdonnance;

	//bi-directional many-to-many association to CommandeClient
	@ManyToMany(mappedBy="ordonnances")
	private List<CommandeClient> commandeClients;

	//bi-directional many-to-one association to ContientOrdonnance
	@OneToMany(mappedBy="ordonnance")
	private List<ContientOrdonnance> contientOrdonnances;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="ID_MEDECIN")
	private Medecin medecin;

	public Ordonnance() {
	}

	public long getIdOrdonnance() {
		return this.idOrdonnance;
	}

	public void setIdOrdonnance(long idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public String getCheminOrdonnance() {
		return this.cheminOrdonnance;
	}

	public void setCheminOrdonnance(String cheminOrdonnance) {
		this.cheminOrdonnance = cheminOrdonnance;
	}

	public Date getDateOrdonnance() {
		return this.dateOrdonnance;
	}

	public void setDateOrdonnance(Date dateOrdonnance) {
		this.dateOrdonnance = dateOrdonnance;
	}

	public String getValiditeOrdonnance() {
		return this.validiteOrdonnance;
	}

	public void setValiditeOrdonnance(String validiteOrdonnance) {
		this.validiteOrdonnance = validiteOrdonnance;
	}

	public List<CommandeClient> getCommandeClients() {
		return this.commandeClients;
	}

	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

	public List<ContientOrdonnance> getContientOrdonnances() {
		return this.contientOrdonnances;
	}

	public void setContientOrdonnances(List<ContientOrdonnance> contientOrdonnances) {
		this.contientOrdonnances = contientOrdonnances;
	}

	public ContientOrdonnance addContientOrdonnance(ContientOrdonnance contientOrdonnance) {
		getContientOrdonnances().add(contientOrdonnance);
		contientOrdonnance.setOrdonnance(this);

		return contientOrdonnance;
	}

	public ContientOrdonnance removeContientOrdonnance(ContientOrdonnance contientOrdonnance) {
		getContientOrdonnances().remove(contientOrdonnance);
		contientOrdonnance.setOrdonnance(null);

		return contientOrdonnance;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

}