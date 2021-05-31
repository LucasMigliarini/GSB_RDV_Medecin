package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEDECIN database table.
 * 
 */
@Entity
@Table(name="MEDECIN")
@NamedQuery(name="Medecin.findAll", query="SELECT m FROM Medecin m")
public class Medecin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MedecinId")
	private int MedecinId;

	@Column(name="MedecinAdresse")
	private String medecinAdresse;

	@Column(name="MedecinNom")
	private String medecinNom;

	@Column(name="MedecinSpecialite")
	private String medecinSpecialite;


	public Medecin() {
	}
	
	public int getMedecinId() {
		return this.MedecinId;
	}

	public void setMedecinId(int Medecinid) {
		this.MedecinId = Medecinid;
	}

	public String getMedecinAdresse() {
		return this.medecinAdresse;
	}

	public void setMedecinAdresse(String medecinAdresse) {
		this.medecinAdresse = medecinAdresse;
	}

	public String getMedecinNom() {
		return this.medecinNom;
	}

	public void setMedecinNom(String medecinNom) {
		this.medecinNom = medecinNom;
	}

	public String getMedecinSpecialite() {
		return this.medecinSpecialite;
	}

	public void setMedecinSpecialite(String medecinSpecialite) {
		this.medecinSpecialite = medecinSpecialite;
	}



}