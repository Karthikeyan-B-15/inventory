package application;

import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Button cancelButton,registerButton,loginButton;
    @FXML
    private TextField c_name;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginMessage;

    @FXML
    private AnchorPane loginstage;
    @FXML
    void onLogin(ActionEvent event)throws IOException {
    	if(c_name.getText().isBlank()==false && password.getText().isBlank()==false) {
    		boolean temp=login();
    		if(temp==true) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource("work.fxml"));
    		root=loader.load();
    		//Work con=loader.getController();
	    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	    	scene=new Scene(root);
	    	scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
	    	stage.setScene(scene);
	    	stage.setX(25);
	    	stage.setY(0);
	    	stage.show();
    		}
    	}
    	else {
    		loginMessage.setText("Not Success!!!");
    	}
    }
    boolean login() {
    	DatabaseConnection connect=new DatabaseConnection();
    	Connection connectDB=connect.getConnection();
    	String verifyLogin="SELECT count(1) from userregister where cname='"+c_name.getText()+"'and password='"+password.getText()+"'";
    	try {
    		Statement stmt=connectDB.createStatement();
    		ResultSet query=stmt.executeQuery(verifyLogin);
    		while(query.next()) {
    			if(query.getInt(1)==1) {
    				return true;
    			}
    			else {
    				loginMessage.setText("Invalid company name and password!!!");
    			}
    			
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    		
    		
    	}
		return false;
    }
    @FXML
    void onCancelLogin(ActionEvent event) {
    		Stage stage=(Stage)loginstage.getScene().getWindow();
    		stage.close();
    }
    @FXML
    void createAnAccount(ActionEvent event) throws IOException {
    	root=FXMLLoader.load(getClass().getResource("Register.fxml"));
    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	scene=new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
 }

