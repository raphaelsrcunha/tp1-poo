package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Note;

public class NoteRepository {

	Connection connection;
	
	public NoteRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void createNote(double valeur, int id_etudiant, int id_evaluation) {
		String query = "INSERT INTO notes (valeur, id_etudiant, id_evaluation) VALUES (?, ?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setDouble(1, valeur);
			ps.setInt(2, id_etudiant);
			ps.setInt(3, id_evaluation);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données insérées avec succès!");
			}
			
			ps.close();
			connection.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Note> getAllNotes() {
        
		List<Note> notes = new ArrayList<>();
        String query = "SELECT * FROM notes";
        
        try (
        	PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	Note note = new Note(
            		rs.getInt("id_note"),
            		rs.getDouble("valeur"),
            		rs.getInt("id_etudiant"),
            		rs.getInt("id_evaluation")
                );
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }
	
	public double getGeneralAverageNote() {
		
		String query = "SELECT SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) from NOTES LEFT JOIN evaluations on notes.id_evaluation = evaluations.id_evaluation";
		
		double average = 0.0;
		
		try (
	        	PreparedStatement stmt = connection.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						average = rs.getDouble("average_valeur");
					}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return average;
	}
	
	public double getAverageNoteByEvaluationId(int id_evaluation) {

	    String query = "SELECT AVG(valeur) AS average_valeur FROM notes WHERE id_evaluation = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setInt(1, id_evaluation);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble("average_valeur");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByEvaluationType(String type) {

	    String query = "SELECT AVG(valeur) AS average_valeur FROM notes LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation WHERE type = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, type);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble("average_valeur");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByEtudiantPrenom(String prenom) {

	    String query = "SELECT SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) from notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation WHERE prenom = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, prenom);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}

	public double getAverageNoteByEtudiantNom(String nom) {

	    String query = "SELECT SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) from notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation WHERE nom = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, nom);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByEtudiantMatricule(String matricule) {

	    String query = "SELECT SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) from notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation WHERE matricule = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, matricule);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByEtudiantNiveau(String niveau) {

	    String query = "SELECT AVG(valeur) AS average_valeur from notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant WHERE niveau = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, niveau);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble("average_valeur");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByMatiereNom(String nom) {

	    String query = "SELECT SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) AS average_valeur FROM notes LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation LEFT JOIN matieres ON evaluations.id_matiere = matieres.id_matiere WHERE matieres.nom = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, nom);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble("average_valeur");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByDepartementNom(String nom) {

	    String query = "SELECT AVG(valeur) AS average_valeur FROM notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant LEFT JOIN departements ON etudiants.id_departement = departements.id_departement WHERE departements.nom = ?";
	    double average = 0.0;

	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setString(1, nom);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                average = rs.getDouble("average_valeur");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return average;
	}
	
	public double getAverageNoteByEtudiantAndMatiere(String nomEtudiant, String nomMatiere) {
		String query = "select SUM(notes.valeur * evaluations.coefficient) / SUM(evaluations.coefficient) from notes LEFT JOIN etudiants ON notes.id_etudiant = etudiants.id_etudiant LEFT JOIN evaluations ON notes.id_evaluation = evaluations.id_evaluation LEFT JOIN matieres ON evaluations.id_matiere = matieres.id_matiere WHERE etudiants.prenom = ? AND matieres.nom = ?";
		double average = 0.0;
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setString(1, nomEtudiant);
			ps.setString(2, nomMatiere);
			
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					average = rs.getDouble(1);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return average;
	}
	
	public void deleteNote(int id_note) {
		String query = "DELETE FROM notes WHERE id_note = ?;";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setInt(1, id_note);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données supprimées avec succès!");
			}
			
			ps.close();
			connection.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateNote(double valeur, int idEtudiant, int idEvaluation, int idNote) {
		
		String query = "UPDATE notes SET valeur = ?, id_etudiant = ?, id_evaluation = ? WHERE id_note = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setDouble(1, valeur);
			ps.setInt(2, idEtudiant);
			ps.setInt(3, idEvaluation);
			ps.setInt(4, idNote);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données mise à jour avec succès!");
			}
			ps.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
