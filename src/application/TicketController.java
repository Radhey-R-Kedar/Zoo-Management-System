package application;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TicketController implements Initializable{

    @FXML
    private Label taddress;

    @FXML
    private Label tadult;

    @FXML
    private Label tchildern;

    @FXML
    private Label tcontact;

    @FXML
    private Label tdate;

    @FXML
    private Label temail;

    @FXML
    private Label ticketId;

    @FXML
    private Label tname;

    @FXML
    private Label tprice;
    
    public void initialize(URL location, ResourceBundle resources) {
        // Perform your data insertion here
        m1();
    }
    
    int no=0;
    
    private void m1(){
    	int p1 = 0;
        int price = 0;
    	String address = null;
        String email = null;
        String adult = null;
        String children = null;
        String guide = null;
        String name = null;
        String contact = null;
        String issue_date = null;

    	System.out.println("11");
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
    		
    		
    		String sql = "SELECT MAX( ticket_no ) AS max_id FROM Zoo_Ticket";	
    	    Statement st = con.createStatement();
    		ResultSet rs =  st.executeQuery(sql);
    
    		while (rs.next()) {
		        int p = rs.getInt("max_id");
		        System.out.println("ID: " + p + ", Name: ");
		        no=p;
		    }		    		
    		st.close();
    		
    		System.out.println(no);
	    		String sql1 = "SELECT * FROM Zoo_Ticket WHERE ticket_no="+no;	
	    	    Statement st1 = con.createStatement();
	    		ResultSet rs1 =  st1.executeQuery(sql1);
	    
	    		while (rs1.next()) {
	    			System.out.println("10");
			         p1 = rs1.getInt("ticket_no");
			         price = rs1.getInt("price");
			         address = rs1.getString("address");
			         email = rs1.getString("email");
			         adult = rs1.getString("adult");
			         children = rs1.getString("children");
			         guide = rs1.getString("guide");
			         name = rs1.getString("name");
			         contact = rs1.getString("contact");
			         issue_date = rs1.getString("issue_date");
			        System.out.println("ID: " + p1 + ", Name: "+ price + address+ email + adult + children + name + guide + contact + issue_date );
			    }		    		
	    		st1.close();
	    	
    		con.close();
    		
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	
    	ticketId.setText(no+"");
        tprice.setText(price+"");
        taddress.setText(address);
        temail.setText(email);
        tadult.setText(adult);
        tchildern.setText(children);
        tname.setText(name);
        tcontact.setText(contact);
        tdate.setText(issue_date);	
    		
   
    }

    @FXML
    void onCancelClick(ActionEvent event) {
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
    		String sql = "DELETE FROM Zoo_Ticket WHERE ticket_no="+ no;	
    	    Statement st = con.createStatement();
    		int rs =  st.executeUpdate(sql);
    		System.out.println(rs);
    		if(rs==1) 
    		{
    		    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    			stage.close();
    		}
    		st.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void onConfirmClick(ActionEvent event) {
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
    }

}



