package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DatabaseConnection;
import model.Etudiant;
import model.Note;
import repository.DepartementRepository;
import repository.EtudiantRepository;
import repository.NoteRepository;

public class EtudiantService {

	DatabaseConnection dbConnection;
	
	public EtudiantService() {
		this.dbConnection = new DatabaseConnection();
	}

	public void createEtudiant(String nom, String prenom, String matricule, String niveau, int id_departement) {
		
		try(Connection connection = dbConnection.getConnection();) {
			EtudiantRepository etudiantRepository = new EtudiantRepository(connection);
			etudiantRepository.createEtudiant(nom, prenom, matricule, niveau, id_departement);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Etudiant> getAllEtudiants() {
		List<Etudiant> etudiants = null;
		
		try(Connection connection = dbConnection.getConnection()){
			EtudiantRepository etudiantRepository = new EtudiantRepository(connection);
			etudiants = etudiantRepository.getAllEtudiants();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return etudiants;
	}
	
	public void deleteEtudiant(int idEtudiant) {
		
		Connection connection = dbConnection.getConnection();
		EtudiantRepository etudiantRepository = new EtudiantRepository(connection);
		etudiantRepository.deleteEtudiant(idEtudiant);
		
	}
	
	public void updateEtudiant(String nom, String prenom, String matricule, String niveau, int idDepartement, int idEtudiant) {
		
		Connection connection = dbConnection.getConnection();
		EtudiantRepository etudiantRepository = new EtudiantRepository(connection);
		etudiantRepository.updateEtudiant(nom, prenom, matricule, niveau, idDepartement, idEtudiant);
	}
	
}
