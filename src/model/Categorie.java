package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIE database table.
 * 
 */
@Entity
@Table(name="CATEGORIE")
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public Categorie(int categorieId, String categorieDescription, String categorieNom, List<Produit> produits) {
		super();
		this.categorieId = categorieId;
		this.categorieDescription = categorieDescription;
		this.categorieNom = categorieNom;
		this.produits = produits;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategorieId")
	private int categorieId;
	
	@Column(name="CategorieDescription")
	private String categorieDescription;

	@Column(name="CategorieNom")
	private String categorieNom;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;
	
	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public Categorie() {
	}

	public String getCategorieDescription() {
		return this.categorieDescription;
	}

	public void setCategorieDescription(String categorieDescription) {
		this.categorieDescription = categorieDescription;
	}

	public String getCategorieNom() {
		return this.categorieNom;
	}

	public void setCategorieNom(String categorieNom) {
		this.categorieNom = categorieNom;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCategorie(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCategorie(null);

		return produit;
	}

}