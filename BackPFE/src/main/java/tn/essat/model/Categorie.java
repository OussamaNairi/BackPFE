package tn.essat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cat")
    private List<Pfe> pfe;
	public Categorie() {
		this.pfe = new ArrayList<Pfe>();
	}
	public Categorie(Integer id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
		this.pfe = new ArrayList<Pfe>();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Pfe> getPfe() {
		return pfe;
	}
	public void setPfe(List<Pfe> pfe) {
		this.pfe = pfe;
	}
	public void addpfe(Pfe li) {
		this.pfe.add(li);
		
	}
	

}
