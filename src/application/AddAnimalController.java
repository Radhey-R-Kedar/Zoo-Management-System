package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.TextField;

public class AddAnimalController implements Initializable{

    @FXML
    private Button addAnimalBtn;

    @FXML
    private TextField adescription;

    @FXML
    private ChoiceBox<String> adisability;
 private String[] dis = {"Yes", "No"};
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	adisability.getItems().addAll(dis);
    }

    @FXML
    private DatePicker adob;

    @FXML
    private TextField aname;

    @FXML
    private TextField apetname;

    @FXML
    private TextField atype;

    @FXML
    private TextField aweight;

    @FXML
    void onAddAnimalClick(ActionEvent event) {
    	
    	String name = null;
        String petName = null;
     	String type = null;
     	LocalDate  dob;
     	String disability = null;
     	String description = null;
     	int animal_id = 0;
     	String weight=null;
     	
     	name = aname.getText();
     	petName = apetname.getText();
     	type = atype.getText();
     	dob = adob.getValue();
     	disability = (String) adisability.getValue();
     	description = adescription.getText();
     	weight = aweight.getText();
     	 
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    		Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
    		String sql1 = "INSERT INTO Zoo_Animal(animal_id ,name , petName , type , dob , weight , disability , description )"
    				+ "values("+"taid.NEXTVAL" +",'"+name+"', '"+petName+"' , '"+type+"' ,'"+ dob +"',"+ weight + ", '"+disability+"' , '"+description+"' )";	
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
    }

}
