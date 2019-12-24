
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;




/**
 *
 * @author Noha
 */
@WebServlet(urlPatterns = {"/DBconnection"})
public class DBconnection  {
	
	private static final String URL = "jdbc:mysql://localhost:3306/iaproject2";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	


	public static Connection openConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return connection;
		}
	}

}
