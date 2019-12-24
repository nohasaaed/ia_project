
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class QustionAndAnswers_DB 
{
	public static ArrayList<String> GET_Q()
	{
		ArrayList<String> list = new ArrayList();
		ArrayList<String> exam_type = ExamType.GET();
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();
			Statement stmt2=conn.createStatement();

			for (int i=0 ; i< exam_type.size() ; i++)
			{
				String Q="SELECT * FROM question WHERE exam_type = '"+exam_type.get(i)+"'" ;

				ResultSet RS = stmt.executeQuery(Q);

				while(RS.next())
				{
					//list.add(RS.getString("qid"));
					list.add(RS.getString("qtext"));
//					list.add("");
					
						String Query="SELECT * FROM answer WHERE qid = '"+RS.getString("qid")+"'" ;

						ResultSet RS2 = stmt2.executeQuery(Query);

						while(RS2.next())
						{
									//list.add(RS2.getString("aid"));
									list.add(RS2.getString("atext"));
									list.add(RS2.getString("correct"));

						}
					
				}
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return list;
	}
	
	public static ArrayList<String> GET_A()
	{
		ArrayList<String> list = new ArrayList();
		ArrayList<String> exam_type = ExamType.GET();
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();
			Statement stmt2=conn.createStatement();

			for (int i=0 ; i< exam_type.size() ; i++)
			{
				String Q="SELECT * FROM question WHERE exam_type = '"+exam_type.get(i)+"'" ;

				ResultSet RS = stmt.executeQuery(Q);

				while(RS.next())
				{
					list.add(RS.getString("qid"));
//					list.add(RS.getString("qtext"));
					
						String Query="SELECT * FROM answer WHERE qid = '"+RS.getString("qid")+"'" ;

						ResultSet RS2 = stmt2.executeQuery(Query);

						while(RS2.next())
						{
									list.add(RS2.getString("aid"));
//									list.add(RS2.getString("atext"));
//									list.add(RS2.getString("correct"));

						}
					
				}
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return list;
//		ArrayList<String> list = new ArrayList();
//		ArrayList<String> Q = GET_Q();
//		try{
//			Connection conn = DBconnection.openConnection();
//			Statement stmt=conn.createStatement();
//
//			for (int i=0 ; i< Q.size() ; i=i+2)
//			{
//				String Query="SELECT * FROM answer WHERE qid = '"+Q.get(i)+"'" ;
//
//				ResultSet RS = stmt.executeQuery(Query);
//
//				while(RS.next())
//				{
//							list.add(RS.getString("aid"));
//							list.add(RS.getString("atext"));
//							list.add(RS.getString("correct"));
//
//				}
//			}
//			
//		}catch(Exception e) {
//			System.err.println(e.getMessage()); 
//		}
//		return list;
	}
	
	public static int id ;
	public static int SAVE_Q(String qtext ,  String exam_type)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="INSERT INTO question (qtext, exam_type) VALUES ( '"+qtext+"', '"+exam_type+"');";
				
			row = stmt.executeUpdate(Q);
			 stmt.executeUpdate(Q, Statement.RETURN_GENERATED_KEYS);
			 ResultSet rs=stmt.getGeneratedKeys();
			 id =rs.getInt(1);
		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return row;
	}
	
	public static int SAVE_A(String atext ,  String correct)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="INSERT INTO answer ( atext, correct, qid) VALUES ( '"+atext+"', '"+correct+"' , '"+id+"');";
					
			row = stmt.executeUpdate(Q);

		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		return row;
	}
	
	
	public static void UPDATE(int qid , String qtext)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="UPDATE  question SET qtext = '"+qtext+"' WHERE qid = '"+qid+"'";
					
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
	
	
	public static void UPDATE_A(int aid , String atext )
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="UPDATE  question SET atext = '"+atext+"'  WHERE aid = '"+aid+"'";
					
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
	
	
	public static void DELETE_Q(int qid)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="DELETE FROM  question WHERE qid = '"+qid+"'";
					
			row = stmt.executeUpdate(Q);

		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		//return row;
	}
	
	public static void DELETE_A(int aid)
	{
		int row=0;
		try{
			Connection conn = DBconnection.openConnection();
			Statement stmt=conn.createStatement();

			String Q="DELETE FROM  answer WHERE aid = '"+aid+"'";
					
			row = stmt.executeUpdate(Q);

		}catch(Exception e) {
			System.err.println(e.getMessage()); 
		}
		//return row;
	}
}
