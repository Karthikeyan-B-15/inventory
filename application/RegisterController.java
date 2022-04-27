package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class RegisterController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField companyName;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private PasswordField password;

    @FXML
    private Label register;

    @FXML
    private Label registerMessage;

    @FXML
    private AnchorPane registerstage;

    @FXML
    void onCancelRegister(ActionEvent event) {
    	Stage stage=(Stage)registerstage.getScene().getWindow();
		stage.close();

    }

    @FXML
    void onRegister(ActionEvent event)throws IOException {
    	if(companyName.getText().isBlank()==false&&confirmPassword.getText().isBlank()==false&&password.getText().isBlank()==false) {
    		if(password.getText().equals(confirmPassword.getText())) {
    			register();
    			root=FXMLLoader.load(getClass().getResource("main.fxml"));
    	    	stage=(Stage)((Node)event.getSource()).getScene().getWindow();
    	    	scene=new Scene(root);
    	    	stage.setScene(scene);
    	    	stage.show();
    		}
    		else {
    			registerMessage.setText("Please enter correct matching password!!!");
    		}
    	}
    	else {
    		registerMessage.setText("Please Enter All The Fields!");
    	}
    }
    void register() {
    	DatabaseConnection connect=new DatabaseConnection();
    	Connection connectDB=connect.getConnection();
    	String c_name=companyName.getText();
    	String pass=password.getText();
    	String query="insert into userregister(cname,password) values('"+c_name+"','"+pass+"')";
    	try {
    		Statement stmt=connectDB.createStatement();
    		stmt.executeUpdate(query);
    	}
    	catch(Exception e) {
    		
    	}
    	
    }

}
