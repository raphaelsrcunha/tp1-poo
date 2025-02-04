package model;

public class Note {

	private int idNote;
	private double valeur;
	private int idEtudiant; //FK
	private int idEvaluation; //FK
	
	public Note(int idNote, double valeur, int idEtudiant, int idEvaluation) {
		this.idNote = idNote;
		this.valeur = valeur;
		this.idEtudiant = idEtudiant;
		this.idEvaluation = idEvaluation;
	}
	
	public int getIdNote() {
		return idNote;
	}
	
	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}
	
	public double getValeur() {
		return valeur;
	}
	
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	public int getIdEtudiant() {
		return idEtudiant;
	}
	
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	public int getIdEvaluation() {
		return idEvaluation;
	}
	
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	@Override
	public String toString() {
		return "Note [idNote=" + idNote + ", valeur=" + valeur + ", idEtudiant=" + idEtudiant + ", idEvaluation="
				+ idEvaluation + "]";
	}
}
