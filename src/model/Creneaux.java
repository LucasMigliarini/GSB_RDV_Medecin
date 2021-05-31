package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CRENEAUX database table.
 * 
 */
@Entity
@Table(name="CRENEAUX")
@NamedQuery(name="Creneaux.findAll", query="SELECT c FROM Creneaux c")
public class Creneaux implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CreDate")
	private String creDate;

	@Column(name="CreHeure")
	private String creHeure;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CreId")
	private int creId;

	@Column(name="CreReserver")
	private int creReserver;

	@ManyToOne
	@JoinColumn(name="CreMedecin", referencedColumnName="MedecinId")
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name="CreVisiteur", referencedColumnName="VisiteurId")
	private Visiteur visiteur;


	public Creneaux() {
	}

	public String getCreDate() {
		return this.creDate;
	}

	public void setCreDate(String creDate) {
		this.creDate = creDate;
	}

	public String getCreHeure() {
		return this.creHeure;
	}

	public void setCreHeure(String creHeure) {
		this.creHeure = creHeure;
	}

	public int getCreId() {
		return this.creId;
	}

	public void setCreId(int creId) {
		this.creId = creId;
	}

	public int getCreReserver() {
		return this.creReserver;
	}

	public void setCreReserver(int creReserver) {
		this.creReserver = creReserver;
	}

	public Visiteur getVisiteur() {
		return this.visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}
	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

}