
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ExamType {
	
	
	public static ArrayList<String> GET() {
		ArrayList<String> list = new ArrayList();
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="SELECT * FROM exam_type" ;

			ResultSet RS = stmt.executeQuery(Q);

			while(RS.next())
			{
				//out.println("<br>Type" +RS.getString("ID_exam_type")+":"+ RS.getString("exam_type")+"<br>");
				list.add(RS.getString("exam_type"));
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return list;
	}
	
	
	public static int SAVE(String exam_type)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="INSERT INTO exam_type ( exam_type) VALUES ('"+exam_type+"')";
					
			row = stmt.executeUpdate(Q);

		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return row;
	}
	
	
	public static void UPDATE(String old_exam_type , String exam_type)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="UPDATE  exam_type SET exam_type = '"+exam_type+"' WHERE exam_type = '"+old_exam_type+"'";
					
			row = stmt.executeUpdate(Q);
			
			if (row == 1)
			{
				out.println("Done");
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		//return row;
	}
	
	
	public static void DELETE(String exam_type)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="DELETE FROM  exam_type WHERE exam_type = '"+exam_type+"'";
					
			row = stmt.executeUpdate(Q);

		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		//return row;
	}

}