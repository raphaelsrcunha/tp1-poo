package model;

public class Etudiant {

	private int idEtudiant;
	private String nom;
	private String prenom;
	private String matricule;
	private String niveau;
	private int idDepartement;//FK
	
	public Etudiant(int idEtudiant, String nom, String prenom, String matricule, String niveau, int idDepartement) {
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.niveau = niveau;
		this.idDepartement = idDepartement;
	}
	
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}
}
