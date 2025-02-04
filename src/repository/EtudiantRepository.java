package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Etudiant;
import model.Note;

public class EtudiantRepository {

	Connection connection;
	
	public EtudiantRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void createEtudiant(String nom, String prenom, String matricule, String niveau, int idDepartement) {
		String query = "INSERT INTO etudiants (nom, prenom, matricule, niveau, id_departement) VALUES (?, ?, ?, ?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, matricule);
			ps.setString(4, niveau);
			ps.setInt(5, idDepartement);
			
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
	
	public List<Etudiant> getAllEtudiants() {
        
		List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiants";
        
        try (
        	PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	Etudiant etudiant = new Etudiant(
            		rs.getInt("id_etudiant"),
            		rs.getString("nom"),
            		rs.getString("prenom"),
            		rs.getString("matricule"),
            		rs.getString("niveau"),
            		rs.getInt("id_departement")
                );
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
	
	public void deleteEtudiant(int idEtudiant) {
		String query = "DELETE FROM etudiants WHERE id_etudiant = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query);){
			ps.setInt(1, idEtudiant);
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données supprimées avec succès!");
			}
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateEtudiant(String nom, String prenom, String matricule, String niveau, int idDepartement, int idEtudiant) {

		String query = "UPDATE etudiants SET nom = ?, prenom = ?, matricule = ?, niveau = ?, id_departement = ? WHERE id_etudiant = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(query);) {
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, matricule);
			ps.setString(4, niveau);
			ps.setInt(5, idDepartement);
			ps.setInt(6, idEtudiant);
			
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
