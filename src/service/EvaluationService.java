package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DatabaseConnection;
import exception.ValidationException;
import model.Departement;
import model.Evaluation;
import repository.DepartementRepository;
import repository.EvaluationRepository;
import validator.EvaluationValidator;

public class EvaluationService {

	DatabaseConnection dbConnection;
	
	public EvaluationService() {
		this.dbConnection = new DatabaseConnection();
	}

	public void createEvaluation(String type, double coefficient, int idMatiere) {
		
		try {
			EvaluationValidator.validateCoefficient(coefficient);
			try(Connection connection = dbConnection.getConnection();) {
				EvaluationRepository evaluationRepository = new EvaluationRepository(connection);
				evaluationRepository.createEvaluation(type, coefficient, idMatiere);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ValidationException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Evaluation> getAllEvaluations() {
		List<Evaluation> evaluations = null;
		
		try(Connection connection = dbConnection.getConnection()){
			EvaluationRepository evaluationRepository = new EvaluationRepository(connection);
			evaluations = evaluationRepository.getAllEvaluations();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return evaluations;
	}

	public void deleteEvaluation(int idEvaluation) {
		Connection connection = dbConnection.getConnection();
		EvaluationRepository evaluationRepository = new EvaluationRepository(connection);
		evaluationRepository.deleteEvaluation(idEvaluation);
	}
	
	public void updateEvaluation(String type, double coefficient, int idMatiere, int idEvaluation) {
		
		try {
			EvaluationValidator.validateCoefficient(coefficient);
			Connection connection = dbConnection.getConnection();
			EvaluationRepository evaluationRepository = new EvaluationRepository(connection);
			evaluationRepository.updateEvaluation(type, coefficient, idMatiere, idEvaluation);
		} catch(ValidationException e) {
			e.printStackTrace();
		}
	}
	
}
