package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Departement;
import model.Etudiant;

public class DepartementRepository {

	private final Connection connection;
	
	public DepartementRepository(Connection connection) {
		this.connection = connection;
	}
	
	public void createDepartement(String nom) {
		String query = "INSERT INTO departements (nom) VALUES (?)";
		
		try(PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setString(1, nom);
			
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
	
	public List<Departement> getAllDepartements() {
        
		List<Departement> departements = new ArrayList<>();
        String query = "SELECT * FROM departements";
        
        try (
        	PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
            	Departement departement = new Departement(
            		rs.getInt("id_departement"),
            		rs.getString("nom")
                );
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }
	
	public void deleteDepartement(int idDepartement) {
		String query = "DELETE FROM departements WHERE id_departement = ?";
		try(PreparedStatement ps = connection.prepareStatement(query);){
			ps.setInt(1, idDepartement);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Données supprimées avec succès!");
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void updateDepartement(String nom, int idDepartement) {
		String query = "UPDATE departements SET nom = ? WHERE id_departement = ?";
		try(PreparedStatement ps = connection.prepareStatement(query);){
			ps.setString(1, nom);
			ps.setInt(2, idDepartement);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Donnée mise à jour avec succès!");
			}
			ps.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
