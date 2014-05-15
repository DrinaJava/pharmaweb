package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CLIENT_VIEW database table.
 * 
 */
@Entity
@Table(name="CLIENT_VIEW")
@NamedQuery(name="ClientView.findAll", query="SELECT c FROM ClientView c")
public class ClientView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name="ADRESSE_ADRESSE")
	private String adresseAdresse;

	@Lob
	@Column(name="ALLERGIES_CONNUES_CLIENT")
	private String allergiesConnuesClient;

	@Column(name="CODE_POSTAL_ADRESSE")
	private BigDecimal codePostalAdresse;

	@Lob
	@Column(name="COMPLEMENT_ADRESSE")
	private String complementAdresse;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_NAISSANCE_CLIENT")
	private Date dateNaissanceClient;

	@Column(name="ID_ADRESSE")
	private BigDecimal idAdresse;

	@Column(name="ID_CENTRE_MUTUELLE")
	private BigDecimal idCentreMutuelle;

	@Id
	@Column(name="ID_CLIENT")
	private BigDecimal idClient;

	@Column(name="ID_COTISATION")
	private BigDecimal idCotisation;

	@Column(name="ID_MEDECIN")
	private BigDecimal idMedecin;

	@Column(name="ID_STATUT")
	private BigDecimal idStatut;

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
	private String numeroTelClient;

	@Lob
	@Column(name="PRENOM_CLIENT")
	private String prenomClient;

	@Lob
	@Column(name="VILLE_ADRESSE")
	private String villeAdresse;

	@Column(name="VISIBLE_CLIENT")
	private BigDecimal visibleClient;

	public ClientView() {
	}

	public String getAdresseAdresse() {
		return this.adresseAdresse;
	}

	public void setAdresseAdresse(String adresseAdresse) {
		this.adresseAdresse = adresseAdresse;
	}

	public String getAllergiesConnuesClient() {
		return this.allergiesConnuesClient;
	}

	public void setAllergiesConnuesClient(String allergiesConnuesClient) {
		this.allergiesConnuesClient = allergiesConnuesClient;
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

	public Date getDateNaissanceClient() {
		return this.dateNaissanceClient;
	}

	public void setDateNaissanceClient(Date dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}

	public BigDecimal getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(BigDecimal idAdresse) {
		this.idAdresse = idAdresse;
	}

	public BigDecimal getIdCentreMutuelle() {
		return this.idCentreMutuelle;
	}

	public void setIdCentreMutuelle(BigDecimal idCentreMutuelle) {
		this.idCentreMutuelle = idCentreMutuelle;
	}

	public BigDecimal getIdClient() {
		return this.idClient;
	}

	public void setIdClient(BigDecimal idClient) {
		this.idClient = idClient;
	}

	public BigDecimal getIdCotisation() {
		return this.idCotisation;
	}

	public void setIdCotisation(BigDecimal idCotisation) {
		this.idCotisation = idCotisation;
	}

	public BigDecimal getIdMedecin() {
		return this.idMedecin;
	}

	public void setIdMedecin(BigDecimal idMedecin) {
		this.idMedecin = idMedecin;
	}

	public BigDecimal getIdStatut() {
		return this.idStatut;
	}

	public void setIdStatut(BigDecimal idStatut) {
		this.idStatut = idStatut;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getMdpClient() {
		return this.mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNumeroAdherentMutuClient() {
		return this.numeroAdherentMutuClient;
	}

	public void setNumeroAdherentMutuClient(String numeroAdherentMutuClient) {
		this.numeroAdherentMutuClient = numeroAdherentMutuClient;
	}

	public String getNumeroClient() {
		return this.numeroClient;
	}

	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}

	public BigDecimal getNumeroSecuClient() {
		return this.numeroSecuClient;
	}

	public void setNumeroSecuClient(BigDecimal numeroSecuClient) {
		this.numeroSecuClient = numeroSecuClient;
	}

	public String getNumeroTelClient() {
		return this.numeroTelClient;
	}

	public void setNumeroTelClient(String numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getVilleAdresse() {
		return this.villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public BigDecimal getVisibleClient() {
		return this.visibleClient;
	}

	public void setVisibleClient(BigDecimal visibleClient) {
		this.visibleClient = visibleClient;
	}

}