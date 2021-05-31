package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	Connection cnx;

	public TestConnection() {
	}

	public void init() {
		try {
			System.out.println("Creating Connection");
			cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/GSB_RDVMEDECINS?user=usermedecin&password=123+aze");
			System.out.println("OK");
			
		} catch (SQLException e) {
			System.out.println("Erreur !!!");
			e.printStackTrace();
		}
	}
}
