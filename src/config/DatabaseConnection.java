package config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	private String url;
	private String user;
	private String password;

    public DatabaseConnection() {
    	loadProperties();
    }
    
    private void loadProperties() {
    	
    	Properties properties = new Properties();
    	
    	try(InputStream input = getClass().getClassLoader().getResourceAsStream("config/db.properties")) {
    		if(input == null) {
    			System.out.println("Impossible de trouver le fichier db.properties");
    			return;
    		}
    		properties.load(input);
    		url = properties.getProperty("db.url");
    		user = properties.getProperty("db.user");
    		password = properties.getProperty("db.password");
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    
    public Connection getConnection() {
    	
    	try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(url, user, password);        	
        	return conn;
        	
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();        	
        }
    	return null;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
