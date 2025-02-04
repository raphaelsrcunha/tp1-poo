package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DatabaseConnection;
import exception.ValidationException;
import model.Departement;
import model.Matiere;
import repository.DepartementRepository;
import repository.MatiereRepository;
import validator.DepartementValidator;

public class DepartementService {
	
	DatabaseConnection dbConnection;
	
	public DepartementService() {
		this.dbConnection = new DatabaseConnection();
	}

	public void createDepartement(String nom) {
		
		try {
			DepartementValidator.validateNom(nom);
			try(Connection connection = dbConnection.getConnection();) {
				DepartementRepository departementRepository = new DepartementRepository(connection);
				departementRepository.createDepartement(nom);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ValidationException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Departement> getAllDepartements() {
		List<Departement> departements = null;
		
		try(Connection connection = dbConnection.getConnection()){
			DepartementRepository departementRepository = new DepartementRepository(connection);
			departements = departementRepository.getAllDepartements();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return departements;
	}
	
	public void deleteDepartement(int idDepartement) {
		Connection connection = dbConnection.getConnection();
		DepartementRepository departementRepository = new DepartementRepository(connection);
		departementRepository.deleteDepartement(idDepartement);
	}
	
	public void updateDepartement(String nom, int idDepartement) {
		
		try {
			DepartementValidator.validateNom(nom);
			Connection connection = dbConnection.getConnection();
			DepartementRepository departementRepository = new DepartementRepository(connection);
			departementRepository.updateDepartement(nom, idDepartement);
		} catch(ValidationException e) {
			e.printStackTrace();
		}
	}
}
