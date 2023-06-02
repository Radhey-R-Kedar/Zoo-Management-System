package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;

public class DataEntry {
	public static void main(String[] args) {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "system", "Radhey#123");
//			//String sql = "SELECT * FROM Zoo_Login where username = '"+user+"'";
//			String sql1 = "INSERT INTO Zoo_Login (username , password , employee_type ) values('Atharva', 'root@123', 'ticket')";
//		    Statement st = con.createStatement();
//			ResultSet rs =  st.executeQuery(sql1);
//			System.out.println(rs);
//			st.close();
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		
//		
//		    	try {
//		    		Class.forName("oracle.jdbc.OracleDriver");
//		    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
//		    		String sql1 = "SELECT * FROM Zoo_Ticket WHERE ticket_no="+no;	
//		    	    Statement st1 = con.createStatement();
//		    		ResultSet rs1 =  st.executeQuery(sql1);
//		    
//		    		while (rs1.next()) {
//		    			System.out.println("10");
//				         p1 = rs1.getInt("ticket_no");
//				         price = rs1.getInt("price");
//				         address = rs1.getString("address");
//				         email = rs1.getString("email");
//				         adult = rs1.getString("adult");
//				         children = rs1.getString("children");
//				         guide = rs1.getString("guide");
//				         name = rs1.getString("name");
//				         contact = rs1.getString("contact");
//				         issue_date = rs1.getString("issue_date");
//				        System.out.println("ID: " + p1 + ", Name: "+ price + address+ email + adult + children + name + guide + contact + issue_date );
//				    }		    		
//		    		st1.close()
//		    		con.close();
//		    	} catch (SQLException e) {
//		    		e.printStackTrace();
//		    	} catch (ClassNotFoundException e) {
//		    		e.printStackTrace();
//		    	}
//		    	
//		    	try {
//		    		Class.forName("oracle.jdbc.OracleDriver");
//		    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
//		    		String sql1 = "";	
//		    	    Statement st1 = con.createStatement();
//		    		ResultSet rs1 =  st1.executeQuery(sql1);
//		    
//		    		    		
//		    		st1.close();
//		    		con.close();
//		    	} catch (SQLException e) {
//		    		e.printStackTrace();
//		    	} catch (ClassNotFoundException e) {
//		    		e.printStackTrace();
//		    	}
		    	
		    	try {
		    		Class.forName("oracle.jdbc.OracleDriver");
		    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
		    		String sql1 = "INSERT INTO Zoo_Animal(animal_id ,name , petName , type , dob , weight , disability , discription )\r\n"
		    				+ "values(2 ,'tiger', 'jerry' , 'mammal' , '2001-11-11' , 10 , 'no' , 'information' )";	
		    	    Statement st1 = con.createStatement();
		    		int rs1 =  st1.executeUpdate(sql1);
		            System.out.println(rs1);
		    		    		
		    		st1.close();
		    		con.close();
		    	} catch (SQLException e) {
		    		e.printStackTrace();
		    	} catch (ClassNotFoundException e) {
		    		e.printStackTrace();
		    	}
	
	System.out.println(java.time.LocalDate.now());
	
}
}


