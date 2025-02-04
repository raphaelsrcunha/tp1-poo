package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
	
	DatabaseConnection dbConnection;
	Connection connection;
	
	public DatabaseInitializer() {
		this.dbConnection = new DatabaseConnection();
		this.connection = dbConnection.getConnection();
	}
	
	 public void initializeDatabase() {
	        try (Connection tempConnection = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/", 
	                dbConnection.getUser(),
	                dbConnection.getPassword()
	        )) {
	            Statement stmt = tempConnection.createStatement();
	            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS tp_poo");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        try {
	            connection = dbConnection.getConnection();
	            connection.setCatalog("tp_poo");
	            
	            createTables();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void createTables() throws SQLException {
		    String createDepartementsTableSQL =
		        "CREATE TABLE IF NOT EXISTS departements (" +
		        "id_departement INT AUTO_INCREMENT PRIMARY KEY, " +
		        "nom VARCHAR(255) NOT NULL);";

		    String createEtudiantsTableSQL =
		        "CREATE TABLE IF NOT EXISTS etudiants (" +
		        "id_etudiant INT AUTO_INCREMENT PRIMARY KEY, " +
		        "nom VARCHAR(255) NOT NULL, " + 
		        "prenom VARCHAR(255) NOT NULL, " + 
		        "matricule VARCHAR(255) NOT NULL, " + 
		        "niveau VARCHAR(255) NOT NULL, " + 
		        "id_departement INT, " +  
		        "FOREIGN KEY (id_departement) REFERENCES departements(id_departement) ON DELETE CASCADE);";

		    String createMatieresTableSQL =
		        "CREATE TABLE IF NOT EXISTS matieres (" +
		        "id_matiere INT AUTO_INCREMENT PRIMARY KEY, " +
		        "nom VARCHAR(255) NOT NULL);";

		    String createEvaluationsTableSQL =
		        "CREATE TABLE IF NOT EXISTS evaluations (" +
		        "id_evaluation INT AUTO_INCREMENT PRIMARY KEY, " +
		        "type VARCHAR(255) NOT NULL, " +
		        "coefficient DOUBLE NOT NULL, " + 
		        "id_matiere INT, " +  
		        "FOREIGN KEY (id_matiere) REFERENCES matieres(id_matiere) ON DELETE CASCADE);";

		    String createNotesTableSQL =
		        "CREATE TABLE IF NOT EXISTS notes (" +
		        "id_note INT AUTO_INCREMENT PRIMARY KEY, " +
		        "valeur DOUBLE NOT NULL, " +
		        "id_etudiant INT, " +  
		        "id_evaluation INT, " +  
		        "FOREIGN KEY (id_etudiant) REFERENCES etudiants(id_etudiant) ON DELETE CASCADE, " +
		        "FOREIGN KEY (id_evaluation) REFERENCES evaluations(id_evaluation) ON DELETE CASCADE);";

		    try (Statement stmt = connection.createStatement()) {
		        stmt.executeUpdate(createDepartementsTableSQL);
		        stmt.executeUpdate(createEtudiantsTableSQL);
		        stmt.executeUpdate(createMatieresTableSQL);
		        stmt.executeUpdate(createEvaluationsTableSQL);
		        stmt.executeUpdate(createNotesTableSQL);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	
	/*public void initializeDatabase() {
		
		String createDatabaseTP1 = "CREATE DATABASE IF NOT EXISTS tp4";
		
		String useDatabaseTP1 = "USE tp4";

		String createDepartementsTableSQL = 
		        "CREATE TABLE IF NOT EXISTS departements (" +
		        "id_departement INT AUTO_INCREMENT PRIMARY KEY, " +
		        "nom VARCHAR(255) NOT NULL);";

		String createEtudiantsTableSQL = 
		    "CREATE TABLE IF NOT EXISTS etudiants (" +
		    "id_etudiant INT AUTO_INCREMENT PRIMARY KEY, " +
		    "nom VARCHAR(255) NOT NULL, " + 
		    "prenom VARCHAR(255) NOT NULL, " + 
		    "matricule VARCHAR(255) NOT NULL, " + 
		    "niveau VARCHAR(255) NOT NULL, " + 
		    "id_departement INT, " +  
		    "FOREIGN KEY (id_departement) REFERENCES departements(id_departement));";

		String createMatieresTableSQL = 
		        "CREATE TABLE IF NOT EXISTS matieres (" +
		        "id_matiere INT AUTO_INCREMENT PRIMARY KEY, " +
		        "nom VARCHAR(255) NOT NULL);";

		String createEvaluationsTableSQL = 
		        "CREATE TABLE IF NOT EXISTS evaluations (" +
		        "id_evaluation INT AUTO_INCREMENT PRIMARY KEY, " +
		        "type VARCHAR(255) NOT NULL, " +
		        "coefficient DOUBLE NOT NULL, " + 
		        "id_matiere INT, " +  
		        "FOREIGN KEY (id_matiere) REFERENCES matieres(id_matiere));";

		String createNotesTableSQL = 
		    "CREATE TABLE IF NOT EXISTS notes (" +
		    "id_note INT AUTO_INCREMENT PRIMARY KEY, " +
		    "valeur DOUBLE NOT NULL, " +
		    "id_etudiant INT, " +  
		    "id_evaluation INT, " +  
		    "FOREIGN KEY (id_etudiant) REFERENCES etudiants(id_etudiant), " +
		    "FOREIGN KEY (id_evaluation) REFERENCES evaluations(id_evaluation));";
		
		try (Statement stmt = connection.createStatement()) {
			stmt.executeUpdate(createDatabaseTP1);
			stmt.executeUpdate(useDatabaseTP1);
			stmt.executeUpdate(createDepartementsTableSQL);
            stmt.executeUpdate(createEtudiantsTableSQL);
            stmt.executeUpdate(createMatieresTableSQL);
            stmt.executeUpdate(createEvaluationsTableSQL);
            stmt.executeUpdate(createNotesTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}*/
	
	public void populateTables() throws SQLException {
        String insertDepartement = "INSERT INTO departements (nom) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertDepartement)) {
            String[] departements = {"Informatique", "Mathématiques", "Physique"};
            for (String dept : departements) {
                pstmt.setString(1, dept);
                pstmt.executeUpdate();
            }
        }

        String insertEtudiant = "INSERT INTO etudiants (nom, prenom, matricule, niveau, id_departement) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertEtudiant)) {
            Object[][] etudiants = {
                {"Dupont", "Jean", "E001", "L1", 1},
                {"Martin", "Marie", "E002", "L2", 2},
                {"Bernard", "Paul", "E003", "L3", 3}
            };
            for (Object[] etudiant : etudiants) {
                pstmt.setString(1, (String) etudiant[0]);
                pstmt.setString(2, (String) etudiant[1]);
                pstmt.setString(3, (String) etudiant[2]);
                pstmt.setString(4, (String) etudiant[3]);
                pstmt.setInt(5, (Integer) etudiant[4]);
                pstmt.executeUpdate();
            }
        }

        String insertMatiere = "INSERT INTO matieres (nom) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertMatiere)) {
            Object[][] matieres = {
                {"Java"},
                {"Algebre"},
                {"Mecanique"}
            };
            for (Object[] matiere : matieres) {
                pstmt.setString(1, (String) matiere[0]);
                pstmt.executeUpdate();
            }
        }

        String insertEvaluation = "INSERT INTO evaluations (type, coefficient, id_matiere) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertEvaluation)) {
            Object[][] evaluations = {
                {"Examen", 0.6, 1},
                {"TP", 0.4, 1},
                {"Controle", 0.5, 2},
                {"ExamenFinal", 0.7, 3}
            };
            for (Object[] evaluation : evaluations) {
                pstmt.setString(1, (String) evaluation[0]);
                pstmt.setDouble(2, (Double) evaluation[1]);
                pstmt.setInt(3, (Integer) evaluation[2]);
                pstmt.executeUpdate();
            }
        }

        String insertNote = "INSERT INTO notes (valeur, id_etudiant, id_evaluation) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertNote)) {
            Object[][] notes = {
                {15.5, 1, 1},
                {65.3, 1, 2},
                {75.5, 1, 3},
                {75.5, 1, 4},
                {14.0, 1, 2},
                {16.5, 2, 3},
                {13.0, 3, 4}
            };
            for (Object[] note : notes) {
                pstmt.setDouble(1, (Double) note[0]);
                pstmt.setInt(2, (Integer) note[1]);
                pstmt.setInt(3, (Integer) note[2]);
                pstmt.executeUpdate();
            }
        }
    }
	
	public boolean areTablesEmpty() throws SQLException {
        String checkDepartements = "SELECT COUNT(*) FROM departements";
        String checkMatieres = "SELECT COUNT(*) FROM matieres";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rsDepartements = stmt.executeQuery(checkDepartements);
            if (rsDepartements.next() && rsDepartements.getInt(1) > 0) {
                return false;
            }

            ResultSet rsMatieres = stmt.executeQuery(checkMatieres);
            if (rsMatieres.next() && rsMatieres.getInt(1) > 0) {
                return false;
            }
        }
        return true;
    }

}
