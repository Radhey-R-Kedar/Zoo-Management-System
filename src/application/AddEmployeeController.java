package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddEmployeeController implements Initializable{

    @FXML
    private Label eWarning;

    @FXML
    private TextField eaddress;

    @FXML
    private DatePicker edob;

    @FXML
    private TextField ename;

    @FXML
    private Button enroll;

    @FXML
    private TextField enumber;

    @FXML
    private ChoiceBox<String> eposition;
private String[] dis = {"Manager", "Employee" , "Cleaner" , "Security"};
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	eposition.getItems().addAll(dis);
    }


    @FXML
    void esubmit(ActionEvent event) {
    	String name = null;
     	String contact_no = null;
     	LocalDate  dob;
     	String position = null;
     	String address = null;
     	
     	name = ename.getText();
     	contact_no = enumber.getText();
     	dob = edob.getValue();
     	position = (String) eposition.getValue();
     	address = eaddress.getText();
    
     	 
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
    		String sql1 = "INSERT INTO Zoo_Person(id ,name, contact_no, dob, position, address)"
    				+ "values( "+"teid.NEXTVAL"+" ,'"+name+"','"+ contact_no +"','"+dob+"','"+ position+"','"+address+"')";	
    	    Statement st1 = con.createStatement();
    		int rs1 =  st1.executeUpdate(sql1);
            System.out.println(rs1);
    		if(rs1==1) {
    			eWarning.setText("Employee successfully enrolled");
    		}
    		st1.close();
    		con.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }

}
