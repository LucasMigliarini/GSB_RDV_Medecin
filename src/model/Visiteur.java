package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VISITEUR database table.
 * 
 */
@Entity
@Table(name="VISITEUR")
@NamedQuery(name="Visiteur.findAll", query="SELECT v FROM Visiteur v")
public class Visiteur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VisiteurId")
	private int VisiteurId;

	@Column(name="VisiteurMail")
	private String visiteurMail;

	@Column(name="VisiteurNom")
	private String visiteurNom;

	@Column(name="VisiteurNumere")
	private int visiteurNumere;

	@Column(name="VisiteurPassword")
	private String visiteurPassword;

	@Column(name="VisiteurPrenom")
	private String visiteurPrenom;


	public Visiteur() {
	}
	
	public int getVisiteurId() {
		return this.VisiteurId;
	}

	public void setVisiteurId(int VisiteurId) {
		this.VisiteurId = VisiteurId;
	}

	public String getVisiteurMail() {
		return this.visiteurMail;
	}

	public void setVisiteurMail(String visiteurMail) {
		this.visiteurMail = visiteurMail;
	}

	public String getVisiteurNom() {
		return this.visiteurNom;
	}

	public void setVisiteurNom(String visiteurNom) {
		this.visiteurNom = visiteurNom;
	}

	public int getVisiteurNumere() {
		return this.visiteurNumere;
	}

	public void setVisiteurNumere(int visiteurNumere) {
		this.visiteurNumere = visiteurNumere;
	}

	public String getVisiteurPassword() {
		return this.visiteurPassword;
	}

	public void setVisiteurPassword(String visiteurPassword) {
		this.visiteurPassword = visiteurPassword;
	}

	public String getVisiteurPrenom() {
		return this.visiteurPrenom;
	}

	public void setVisiteurPrenom(String visiteurPrenom) {
		this.visiteurPrenom = visiteurPrenom;
	}

}