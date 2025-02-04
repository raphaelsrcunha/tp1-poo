package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Departement;
import model.Evaluation;

public class EvaluationRepository {

	Connection connection;
	
	public EvaluationRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void createEvaluation(String type, double coefficient, int id_matiere) {
		String query = "INSERT INTO evaluations (type, coefficient, id_matiere) VALUES (?, ?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setString(1, type);
			ps.setDouble(2, coefficient);
			ps.setInt(3, id_matiere);
			
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
	
	public List<Evaluation> getAllEvaluations() {
        
		List<Evaluation> evaluations = new ArrayList<>();
        String query = "SELECT * FROM evaluations";
        
        try (
        	PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	Evaluation evaluation = new Evaluation(
            		rs.getInt("id_evaluation"),
            		rs.getString("type"),
            		rs.getDouble("coefficient"),
            		rs.getInt("id_matiere")
                );
                evaluations.add(evaluation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evaluations;
    }
	
	public void deleteEvaluation(int idEvaluation) {
		
		String query = "DELETE FROM evaluations WHERE id_evaluation = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, idEvaluation);
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
	
	public void updateEvaluation(String type, double coefficient, int idMatiere, int idEvaluation) {
		String query = "UPDATE evaluations SET type = ?, coefficient = ?, id_matiere = ? WHERE id_evaluation = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setString(1, type);
			ps.setDouble(2, coefficient);
			ps.setInt(3, idMatiere);
			ps.setInt(4, idEvaluation);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données mises à jour avec succès!");
			}
			
			ps.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
