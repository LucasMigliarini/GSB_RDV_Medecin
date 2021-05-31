package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COMPTE_RENDU_VISITE database table.
 * 
 */
@Entity
@Table(name="COMPTE_RENDU_VISITE")
@NamedQuery(name="CompteRenduVisite.findAll", query="SELECT c FROM CompteRenduVisite c")
public class CompteRenduVisite implements Serializable {
	private static final long serialVersionUID = 1L;

	private String CRVDate;

	private String CRVDescription;

	private String CRVHeure;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CRVId")
	int CRVId;

	//bi-directional many-to-one association to Medecin
	@ManyToOne
	@JoinColumn(name="CRVMedecin", referencedColumnName="MedecinId")
	private Medecin medecin;

	//bi-directional many-to-many association to Produit
	@ManyToMany
	@JoinTable(
		name="PROPSITION"
		, joinColumns={
			@JoinColumn(name="PROPCRV", referencedColumnName="CRVId")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PROPProduit", referencedColumnName="ProduitId")
			}
		)
	private List<Produit> produits;

	//bi-directional many-to-one association to Visiteur
	@ManyToOne
	@JoinColumn(name="CRVVisiteur", referencedColumnName="VisiteurId")
	private Visiteur visiteur;

	public CompteRenduVisite() {
	}
	
	public int getCRVId() {
		return this.CRVId;
	}

	public void setCRVId(int CRVId) {
		this.CRVId = CRVId;
	}

	public String getCRVDate() {
		return this.CRVDate;
	}

	public void setCRVDate(String CRVDate) {
		this.CRVDate = CRVDate;
	}

	public String getCRVDescription() {
		return this.CRVDescription;
	}

	public void setCRVDescription(String CRVDescription) {
		this.CRVDescription = CRVDescription;
	}

	public String getCRVHeure() {
		return this.CRVHeure;
	}

	public void setCRVHeure(String CRVHeure) {
		this.CRVHeure = CRVHeure;
	}

	public Medecin getMedecin() {
		return this.medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Visiteur getVisiteur() {
		return this.visiteur;
	}

	public void setVisiteur(Visiteur visiteur) {
		this.visiteur = visiteur;
	}

}