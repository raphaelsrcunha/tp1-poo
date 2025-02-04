package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DatabaseConnection;
import model.Matiere;
import model.Note;
import repository.MatiereRepository;
import repository.NoteRepository;

public class MatiereService {

DatabaseConnection dbConnection;
	
	public MatiereService() {
		this.dbConnection = new DatabaseConnection();
	}

	public void createMatiere(String nom, int idDepartement) {
		
		try(Connection connection = dbConnection.getConnection();) {
			MatiereRepository matiereRepository = new MatiereRepository(connection);
			matiereRepository.createMatiere(nom, idDepartement);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Matiere> getAllMatieres() {
		List<Matiere> matieres = null;
		
		try(Connection connection = dbConnection.getConnection()){
			MatiereRepository matiereRepository = new MatiereRepository(connection);
			matieres = matiereRepository.getAllMatieres();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return matieres;
	}

	public void deleteMatiere(int id_matiere) {
		Connection connection = dbConnection.getConnection();
		MatiereRepository matiereRepository = new MatiereRepository(connection);
		matiereRepository.deleteMatiere(id_matiere);
	}
	
	public void updateMatiere(String nom, int idMatiere) {
		Connection connection = dbConnection.getConnection();
		MatiereRepository matiereRepository = new MatiereRepository(connection);
		matiereRepository.updateMatiere(nom, idMatiere);
	}
}
