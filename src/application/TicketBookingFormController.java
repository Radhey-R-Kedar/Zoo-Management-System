package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TicketBookingFormController implements Initializable{

    @FXML
    private TextField tAddress;
    
    @FXML
    private Button tBookTicketBtn;
 

    @FXML
    private TextField tAdult;


    @FXML
    private TextField tChildern;

    @FXML
    private TextField tEmail;

    @FXML
    private ChoiceBox<String> tGuide;
    
    private String[] needguide = {"Yes", "No"};
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	tGuide.getItems().addAll(needguide);
    }

    @FXML
    private TextField tName;

    @FXML
    private TextField tNumber;
    
    @FXML
    private Label ticketNo;
    
    @FXML
    private Label tPrice;
    
    @FXML
    private Label tWarning;
    
    @FXML
    private Label price;

    

    
    @FXML
    void ontBookClick(ActionEvent event) {
    
        String Email = null;
        String Address = null;
    	
    	String Adult = null;
    	String Childern = null;
    	String Guide = null;
    	String Name = null;
    	String Contact = null;
    	int Price=0;
    	
    	 Address = tAddress.getText();
    	 Email = tEmail.getText();
    	 Adult = tAdult.getText();
    	 Childern = tChildern.getText();
    	 Guide = (String) tGuide.getValue();
    	 Name = tName.getText();
    	 Contact = tNumber.getText();
    	
    	
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "Zoo", "Radhey#123");
				
				if(Name=="" || Contact=="" || Email=="" || Adult=="" || Childern=="") {
					tWarning.setText("warning: Please fill all * fields...");
				}else {
					
					String sql = "Select * from Zoo_Ticket_Price";
				    Statement st1 = con.createStatement();
					ResultSet rs1 =  st1.executeQuery(sql);
					 while (rs1.next()) {
					        // Retrieve data from the result set
					        int p = rs1.getInt("price");
					        String name = rs1.getString("type");
					        // Retrieve other columns similarly
					        
					        if(name.equals("adult")) {
					        	Price += p*( Integer.parseInt(Adult));
					        }else if(name.equals("child")) {
					        	Price += p*( Integer.parseInt(Childern));
					        }
					        
//					        tPrice.setText(Price+"");
					        // Process the retrieved data as needed
					        System.out.println("ID: " + p + ", Name: " + name);
					    }
					st1.close();
					
					
				
						String sql1 = "INSERT INTO Zoo_Ticket (ticket_no , address , email , adult , children , guide , name , contact , issue_date ,  price)"
								+ "values( "+ "tid.NEXTVAL" +",'" + Address +"','" + Email + "','"+ Adult +"','"+ Childern +"','"+ Guide +"','" + Name + "','" + Contact + "'," + java.time.LocalDate.now() + "," + Price + ")";
				    Statement st2 = con.createStatement();
					int rs2 =  st2.executeUpdate(sql1);
					System.out.println(rs2);
					st2.close();
					
					
					con.close();
					
					if(rs2==1) {
						try {

		        			Parent root = FXMLLoader.load(getClass().getResource("/Resources/Ticket.fxml"));
		        			Scene scene = new Scene(root);
		        			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        			Stage stage1 = new Stage();
		        			//stage1.setTitle("Login Page");
		        			stage1.setScene(scene);
		        			stage1.show();
		        		
							
//		        			FXMLLoader loader= FXMLLoader.load(getClass().getResource("/Resources/Ticket.fxml"));
//		        		    Parent nextRoot = loader.load();
//		        			
//		        			Stage stage = (Stage) tBookTicketBtn.getScene().getWindow();
//		        	
//		        			Scene nextScene = new Scene(nextRoot);
//		        			stage.show();
		        			
		        			
		        		} catch(Exception e) {
		        			e.printStackTrace();
		        		}
					}
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}

