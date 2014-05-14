package com.pharmaweb.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CLIENT")
	private long idClient;

	@Lob
	@Column(name="ALLERGIES_CONNUES_CLIENT")
	private String allergiesConnuesClient;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE_CLIENT")
	private Date dateNaissanceClient;

	@Lob
	@Column(name="MAIL_CLIENT")
	private String mailClient;

	@Lob
	@Column(name="MDP_CLIENT")
	private String mdpClient;

	@Lob
	@Column(name="NOM_CLIENT")
	private String nomClient;

	@Lob
	@Column(name="NUMERO_ADHERENT_MUTU_CLIENT")
	private String numeroAdherentMutuClient;

	@Lob
	@Column(name="NUMERO_CLIENT")
	private String numeroClient;

	@Column(name="NUMERO_SECU_CLIENT")
	private BigDecimal numeroSecuClient;

	@Column(name="NUMERO_TEL_CLIENT")
	private BigDecimal numeroTelClient;

	@Lob
	@Column(name="PRENOM_CLIENT")
	private String prenomClient;

	@Column(name="VISIBLE_CLIENT")
	private BigDecimal visibleClient;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="ID_MEDECIN")
	private Medecin medecin;

	//bi-directional many-to-one association to Statut
	@ManyToOne
	@JoinColumn(name="ID_STATUT")
	private Statut statut;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="ID_ADRESSE")
	private Adresse adresse;

	//bi-directional many-to-one association to CentreMutuelle
	@ManyToOne
	@JoinColumn(name="ID_CENTRE_MUTUELLE")
	private CentreMutuelle centreMutuelle;

	//bi-directional many-to-one association to Cotisation
	@ManyToOne
	@JoinColumn(name="ID_COTISATION")
	private Cotisation cotisation;

	//bi-directional many-to-one association to CommandeClient
	@OneToMany(mappedBy="client")
	private List<CommandeClient> commandeClients;

	//bi-directional many-to-one association to Ordonnance
	@OneToMany(mappedBy="client")
	private List<Ordonnance> ordonnances;

	public Client() {
	}

	public long getIdClient() {
		return this.idClient;
	}

	public void setIdClient(final long idClient) {
		this.idClient = idClient;
	}

	public String getAllergiesConnuesClient() {
		return this.allergiesConnuesClient;
	}

	public void setAllergiesConnuesClient(final String allergiesConnuesClient) {
		this.allergiesConnuesClient = allergiesConnuesClient;
	}

	public Date getDateNaissanceClient() {
		return this.dateNaissanceClient;
	}

	public void setDateNaissanceClient(final Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(final String mailClient) {
		this.mailClient = mailClient;
	}

	public String getMdpClient() {
		return this.mdpClient;
	}

	public void setMdpClient(final String mdpClient) {
		this.mdpClient = mdpClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(final String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNumeroAdherentMutuClient() {
		return this.numeroAdherentMutuClient;
	}

	public void setNumeroAdherentMutuClient(final String numeroAdherentMutuClient) {
		this.numeroAdherentMutuClient = numeroAdherentMutuClient;
	}

	public String getNumeroClient() {
		return this.numeroClient;
	}

	public void setNumeroClient(final String numeroClient) {
		this.numeroClient = numeroClient;
	}

	public BigDecimal getNumeroSecuClient() {
		return this.numeroSecuClient;
	}

	public void setNumeroSecuClient(final BigDecimal numeroSecuClient) {
		this.numeroSecuClient = numeroSecuClient;
	}

	public BigDecimal getNumeroTelClient() {
		return this.numeroTelClient;
	}

	public void setNumeroTelClient(final BigDecimal numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(final String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public BigDecimal getVisibleClient() {
		return this.visibleClient;
	}

	public void setVisibleClient(final BigDecimal visibleClient) {
		this.visibleClient = visibleClient;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(final Medecin medecin) {
		this.medecin = medecin;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(final Statut statut) {
		this.statut = statut;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(final Adresse adresse) {
		this.adresse = adresse;
	}

	public CentreMutuelle getCentreMutuelle() {
		return this.centreMutuelle;
	}

	public void setCentreMutuelle(final CentreMutuelle centreMutuelle) {
		this.centreMutuelle = centreMutuelle;
	}

	public Cotisation getCotisation() {
		return this.cotisation;
	}

	public void setCotisation(final Cotisation cotisation) {
		this.cotisation = cotisation;
	}

	public List<CommandeClient> getCommandeClients() {
		return this.commandeClients;
	}

	public void setCommandeClients(final List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}

	public CommandeClient addCommandeClient(final CommandeClient commandeClient) {
		this.getCommandeClients().add(commandeClient);
		commandeClient.setClient(this);

		return commandeClient;
	}

	public CommandeClient removeCommandeClient(final CommandeClient commandeClient) {
		this.getCommandeClients().remove(commandeClient);
		commandeClient.setClient(null);

		return commandeClient;
	}

	public List<Ordonnance> getOrdonnances() {
		return this.ordonnances;
	}

	public void setOrdonnances(final List<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	public Ordonnance addOrdonnance(final Ordonnance ordonnance) {
		this.getOrdonnances().add(ordonnance);
		ordonnance.setClient(this);

		return ordonnance;
	}

	public Ordonnance removeOrdonnance(final Ordonnance ordonnance) {
		this.getOrdonnances().remove(ordonnance);
		ordonnance.setClient(null);

		return ordonnance;
	}

}