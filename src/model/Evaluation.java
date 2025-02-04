package model;

public class Evaluation {

	private int idEvaluation;
	private String type;
	private double coefficient;
	private int idMatiere; //FK
	
	public Evaluation(int idEvaluation, String type, double coefficient, int idMatiere) {
		this.idEvaluation = idEvaluation;
		this.type = type;
		this.coefficient = coefficient;
		this.idMatiere = idMatiere;
	}
	
	public int getIdEvaluation() {
		return idEvaluation;
	}
	
	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	
	public int getIdMatiere() {
		return idMatiere;
	}
	
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}	
}
