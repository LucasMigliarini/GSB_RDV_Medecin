package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUIT database table.
 * 
 */
@Entity
@Table(name="PRODUIT")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ProduitDescription")
	private String produitDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProduitId")
	private int produitId;

	@Column(name="ProduitNom")
	private String produitNom;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="ProduitCategorie", referencedColumnName="CategorieId")
	private Categorie categorie;

	public Produit() {
	}

	public String getProduitDescription() {
		return this.produitDescription;
	}

	public void setProduitDescription(String produitDescription) {
		this.produitDescription = produitDescription;
	}

	public int getProduitId() {
		return this.produitId;
	}

	public void setProduitId(int produitId) {
		this.produitId = produitId;
	}

	public String getProduitNom() {
		return this.produitNom;
	}

	public void setProduitNom(String produitNom) {
		this.produitNom = produitNom;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}