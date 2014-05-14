package com.pharmaweb.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EMPLOYE database table.
 * 
 */
@Entity
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_EMPLOYE")
	private long idEmploye;

	@Lob
	@Column(name="LOGIN_EMPLOYE")
	private String loginEmploye;

	@Lob
	@Column(name="MDP_EMPLOYE")
	private String mdpEmploye;

	@Column(name="STATUT_EMPLOYE")
	private BigDecimal statutEmploye;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="employe")
	private List<Discussion> discussions;

	//bi-directional many-to-one association to Pharmacie
	@ManyToOne
	@JoinColumn(name="ID_PHARMACIE")
	private Pharmacie pharmacie;

	public Employe() {
	}

	public long getIdEmploye() {
		return this.idEmploye;
	}

	public void setIdEmploye(long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getLoginEmploye() {
		return this.loginEmploye;
	}

	public void setLoginEmploye(String loginEmploye) {
		this.loginEmploye = loginEmploye;
	}

	public String getMdpEmploye() {
		return this.mdpEmploye;
	}

	public void setMdpEmploye(String mdpEmploye) {
		this.mdpEmploye = mdpEmploye;
	}

	public BigDecimal getStatutEmploye() {
		return this.statutEmploye;
	}

	public void setStatutEmploye(BigDecimal statutEmploye) {
		this.statutEmploye = statutEmploye;
	}

	public List<Discussion> getDiscussions() {
		return this.discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public Discussion addDiscussion(Discussion discussion) {
		getDiscussions().add(discussion);
		discussion.setEmploye(this);

		return discussion;
	}

	public Discussion removeDiscussion(Discussion discussion) {
		getDiscussions().remove(discussion);
		discussion.setEmploye(null);

		return discussion;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

}