package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DISCUSSION database table.
 * 
 */
@Entity
@NamedQuery(name="Discussion.findAll", query="SELECT d FROM Discussion d")
public class Discussion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DISCUSSION")
	private long idDiscussion;

	@Lob
	@Column(name="QUESTION_DISCUSSION")
	private String questionDiscussion;

	@Lob
	@Column(name="REPONSE_DISCUSSION")
	private String reponseDiscussion;

	//bi-directional many-to-one association to CommandeClient
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE_CLIENT")
	private CommandeClient commandeClient;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="ID_EMPLOYE")
	private Employe employe;

	public Discussion() {
	}

	public long getIdDiscussion() {
		return this.idDiscussion;
	}

	public void setIdDiscussion(long idDiscussion) {
		this.idDiscussion = idDiscussion;
	}

	public String getQuestionDiscussion() {
		return this.questionDiscussion;
	}

	public void setQuestionDiscussion(String questionDiscussion) {
		this.questionDiscussion = questionDiscussion;
	}

	public String getReponseDiscussion() {
		return this.reponseDiscussion;
	}

	public void setReponseDiscussion(String reponseDiscussion) {
		this.reponseDiscussion = reponseDiscussion;
	}

	public CommandeClient getCommandeClient() {
		return this.commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}