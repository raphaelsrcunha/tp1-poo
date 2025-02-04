package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Matiere;
import model.Note;

public class MatiereRepository {
	
	Connection connection;
	
	public MatiereRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void createMatiere(String nom, int id_departement) {
		String query = "INSERT INTO matieres (nom, id_departement) VALUES (?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setString(1, nom);
			ps.setInt(2, id_departement);
			
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
	
	public List<Matiere> getAllMatieres() {
        
		List<Matiere> matieres = new ArrayList<>();
        String query = "SELECT * FROM matieres";
        
        try (
        	PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	Matiere matiere = new Matiere(
            		rs.getInt("id_matiere"),
            		rs.getString("nom")
                );
                matieres.add(matiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matieres;
    }
	
	public void deleteMatiere(int idMatiere) {
		
		String query = "DELETE FROM matieres where id_matiere = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, idMatiere);
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
	
	public void updateMatiere(String nom, int idMatiere) {
		
		String query = "UPDATE matieres SET nom = ? WHERE id_matiere = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setString(1, nom);
			ps.setInt(2, idMatiere);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données mise à jour avec succès!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
}
