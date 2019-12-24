
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class Search{

	/**
	 *
	 */
	public static ArrayList<String> search(String Name , String Email , String ExamType , String ExamDate)
	{
		ArrayList<String> list = new ArrayList();
		try {
			Connection conn = null;
			Statement stmt = null;

			//display connection
			conn = DBconnection.openConnection();
			stmt = conn.createStatement();

			String Q = "";
			ResultSet RS = null;

			if ((Name != null) || (Email != null) || (ExamType != null) || (ExamDate != null)) 
			{
				if (Name != null) 
				{
					Q = "SELECT * FROM user WHERE name = '" + Name + "'";
					RS = stmt.executeQuery(Q);
				} else if (Email != null) 
				{
					Q = "SELECT * FROM user WHERE email = '" + Email + "'";
					RS = stmt.executeQuery(Q);
				} else if (ExamType != null)
				{
					Q="SELECT *\n" +
						"FROM user_exam p\n" +
						"LEFT JOIN user c1 ON p.user_id = c1.id\n"+
							"WHERE exam_type = '"+ExamType+"'";
					RS = stmt.executeQuery(Q);
				} else if (ExamDate != null)
				{
					Q="SELECT *\n" +
					"FROM choosen_answer p\n" +
					"LEFT JOIN user c1 ON p.user_id = c1.id\n" +
					"WHERE exam_date =  '"+ExamDate+"'";
					RS = stmt.executeQuery(Q);
				}
			}

			while (RS.next()) {
				list.add( RS.getString("id"));
				list.add( RS.getString("name"));
				list.add(  RS.getString("email"));
				list.add(  RS.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return list;
	}
}
