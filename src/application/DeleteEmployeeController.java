package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DeleteEmployeeController {

    @FXML
    private Label edWarning;

    @FXML
    private TextField edid;

    @FXML
    private TextArea einfo;

    @FXML
    private Button esubmit;

    @FXML
    private Button no;

    @FXML
    private Button yes;

    @FXML
    void ondesubmitclick(ActionEvent event) {
    	System.out.println("11");
    	String name = null;
     	String contact_no = null;
     	String dob = null;
     	String position = null;
     	String address = null;
    		
    		String emp_id = edid.getText();
    		int a = Integer.parseInt(emp_id);
    		System.out.println(a);
    		
    	try {
    		System.out.println("11");
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");	
    		String sql1 = "SELECT * FROM Zoo_Person WHERE id="+a;	
    	    Statement st1 = con.createStatement();
    		ResultSet rs1 =  st1.executeQuery(sql1);
    		System.out.println("21");
    	
    		while (rs1.next()) {
    			System.out.println("10");
    			name = rs1.getString("name");
    			contact_no = rs1.getString("contact_no");
    			position = rs1.getString("position");
    			dob = rs1.getString("dob");
    			address = rs1.getString("address");
    	         
    			String data ="ID: " + a + "\n Name: "+ name +"\n Position: "+ position+"\n Dob: "+ dob +"\n Contact_no: "+ contact_no +"\n Address: "+ address ;
    			einfo.setText(data);
    			edWarning.setText("Data found Successfully");
    	    }	
    		    		
    		st1.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		edWarning.setText("Data Not found Successfully");
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void onnoclick(ActionEvent event) {

    }

    @FXML
    void onyesclick(ActionEvent event) {
    	String id = edid.getText();
    	int a = Integer.parseInt(id);
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
    		String sql = "DELETE FROM Zoo_Person WHERE id="+ a;	
    	    Statement st = con.createStatement();
    		int rs =  st.executeUpdate(sql);
    		System.out.println(rs);
    		if(rs==1) 
    		{
    			edWarning.setText("Data Deleted Successfully");   
    		}else {
    			edWarning.setText("Data not found");
    		}
    		st.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }

}
