package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import config.DatabaseConnection;
import exception.ValidationException;
import model.Note;
import repository.NoteRepository;
import validator.NoteValidator;

public class NoteService {

	DatabaseConnection dbConnection;
	
	public NoteService() {
		this.dbConnection = new DatabaseConnection();
	}

	public void createNote(double valeur, int id_etudiant, int id_evaluation) {
		
		try {
			NoteValidator.validateValeur(valeur);
			try(Connection connection = dbConnection.getConnection();) {
				NoteRepository noteRepository = new NoteRepository(connection);
				noteRepository.createNote(valeur, id_etudiant, id_evaluation);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ValidationException e) {
			e.printStackTrace();
		}
	}
	
	public List<Note> getAllNotes() {
		List<Note> notes = null;
		
		// La connexion est fermé quando on utilise le paramètre dans le try-catch
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			notes = noteRepository.getAllNotes();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return notes;
	}
	
	public double getGeneralAverageNote() {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getGeneralAverageNote();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEvaluationId(int id_evaluation) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEvaluationId(id_evaluation);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEvaluationType(String type) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEvaluationType(type);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEtudiantPrenom(String prenom) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEtudiantPrenom(prenom);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEtudiantNom(String nom) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEtudiantNom(nom);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEtudiantMatricule(String matricule) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEtudiantMatricule(matricule);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByEtudiantNiveau(String niveau) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByEtudiantNiveau(niveau);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByMatiereNom(String nom) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByMatiereNom(nom);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return avg;
		
	}
	
	public double getAverageNoteByDepartementNom(String nom) {
		
		double avg = 0.0;
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			avg = noteRepository.getAverageNoteByDepartementNom(nom);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return avg;	
	}
	
	public double getAverageNoteByEtudiantAndMatiere(String nomEtudiant, String nomMatiere) {
		
		Connection connection = dbConnection.getConnection();
		NoteRepository noteRepository = new NoteRepository(connection);
		return noteRepository.getAverageNoteByEtudiantAndMatiere(nomEtudiant, nomMatiere);
			
	}
	
	public void deleteNote(int id_note) {
		
		try(Connection connection = dbConnection.getConnection()){
			NoteRepository noteRepository = new NoteRepository(connection);
			noteRepository.deleteNote(id_note);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateNote(double valeur, int idEtudiant, int idEvaluation, int idNote) {
		
		Connection connection = dbConnection.getConnection();
		NoteRepository noteRepository = new NoteRepository(connection);
		noteRepository.updateNote(valeur, idEtudiant, idEvaluation, idNote);
		
	}

}
