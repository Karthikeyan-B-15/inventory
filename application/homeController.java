package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class homeController implements Initializable {

    @FXML
    private Button insert;

    @FXML
    private TableColumn<Items, String> items;

    @FXML
    private TableView<Items> itemtable;

    @FXML
    private TableColumn<Items, String> qty;

    @FXML
    private TableColumn<Items, Integer> rate;

    @FXML
    private TableColumn<Items,Integer> sno;

    @FXML
    void add(ActionEvent event) {
    show();
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	void show() {
		ObservableList<Items> list=FXCollections.observableArrayList(new Items(2,"","",0));
		sno.setCellValueFactory(new PropertyValueFactory<Items,Integer>("sno"));
	    items.setCellValueFactory(new PropertyValueFactory<Items,String>("items"));
	    qty.setCellValueFactory(new PropertyValueFactory<Items,String>("qty"));
	    rate.setCellValueFactory(new PropertyValueFactory<Items,Integer>("rate"));
	    itemtable.setItems(list);
	}
    
    
   
}
