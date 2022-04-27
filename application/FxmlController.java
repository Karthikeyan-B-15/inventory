package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class FxmlController implements Initializable{
	@FXML
	private BorderPane mainPane;
	@FXML
	private void homeAction(ActionEvent event) {
		FxmlLoader obj=new FxmlLoader();
		Pane view=obj.getPage("home");
		mainPane.setCenter(view);
	}
	@FXML
	private void productAction(ActionEvent event) {
		FxmlLoader obj=new FxmlLoader();
		Pane view=obj.getPage("Product");
		mainPane.setCenter(view);
	}
	@FXML
	 private void stockAction(ActionEvent event) {
		FxmlLoader obj=new FxmlLoader();
		Pane view=obj.getPage("Stock");
		mainPane.setCenter(view);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
