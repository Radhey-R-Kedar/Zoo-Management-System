package application;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button LoginBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputPassword;

    @FXML
    private Label title;
    
    @FXML
    private Button loginbtn;

    @FXML
    void onLoginButtonClick(ActionEvent event) {
    	
    	String user = inputEmail.getText();
    	String Pass = inputPassword.getText();
    	
    	System.out.println(user + Pass);
    	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
			String sql = "SELECT * FROM Zoo_Login where username = '"+user+"'";	
		    Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			
			 while (rs.next()) {
				 System.out.println("1230");
			        String password = rs.getString("password");
			        String name = rs.getString("username");
			        String type = rs.getString("employee_type");
			        System.out.println(password +" " + type + " " + name );
		
			        if(password.equals(Pass) && name.equals(user)){
			        	if(type.equals("manager")) {
			        		try {
			        			Parent root = FXMLLoader.load(getClass().getResource("/Resources/ManagerWindow.fxml"));
			        			Scene scene = new Scene(root);
			        			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			        			Stage stage1 = new Stage();
			        			stage1.setTitle("Login Page");
			        			stage1.setScene(scene);
			        			stage1.show();
			        			
			        			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			        			stage.close();
			        			
			        		} catch(Exception e) {
			        			e.printStackTrace();
			        		}
			        		break;
			        	}else if(type.equals("ticket")) {
			        		try {
			        			Parent root = FXMLLoader.load(getClass().getResource("/Resources/TicketBookingForm.fxml"));
			        			Scene scene = new Scene(root);
			        			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			        			Stage stage1 = new Stage();
			        			stage1.setTitle("Zoo Ticket Booking");
			        			stage1.setScene(scene);
			        			stage1.show();
			        			
			        			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			        			stage.close();
			        			
			        			
			        		} catch(Exception e) {
			        			e.printStackTrace();
			        		}
			        		break;
		        	}
	           }
			        
		    }

			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    }

    @FXML
    void onHomeButtonClick(ActionEvent event) {
    	
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
    	
    }
    
}

		

	
	
  

