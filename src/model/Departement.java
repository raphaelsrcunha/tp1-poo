package model;

public class Departement {

	private int idDepartement;
	private String nom;
	
	public Departement(int idDepartement, String nom) {
		this.idDepartement = idDepartement;
		this.nom = nom;
	}
	
	public int getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
