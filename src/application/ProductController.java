package application;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
;

public class ProductController implements Initializable{

    @FXML
    private TableColumn<Products, Integer> colId;

    @FXML
    private TableColumn<Products, Integer> colMinStock;

    @FXML
    private TableColumn<Products, Integer> colPrice;

    @FXML
    private TableColumn<Products, String> colProduct;

    @FXML
    private Button insert;

    @FXML
    private TextField minStock;
    @FXML
    private TextField id;

    @FXML
    private TextField price;

    @FXML
    private TextField productName;

    @FXML
    private TableView<Products> tContent;

    @FXML
    private Button update;

    @FXML
    void onInsert(ActionEvent event) {
    	if(event.getSource()==insert) {
    		insertRecord();
    	}
    }

    @FXML
    void onUpdate(ActionEvent event) {
    	updateRecord();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		showproducts();
		
	}
	public ObservableList<Products> getProductList(){
		ObservableList<Products> prodList=FXCollections.observableArrayList();
		DatabaseConnection connect=new DatabaseConnection();
    	Connection connectDB=connect.getConnection();
    	String query="select * from products";
    	Statement stmt;
    	ResultSet rs;
    	try {
    		stmt=connectDB.createStatement();
    		rs=stmt.executeQuery(query);
    		Products prod;
    		while(rs.next()) {
    			prod =new Products(rs.getInt("id"),rs.getString("prod"),rs.getInt("price"),rs.getInt("mstock"));
    			prodList.add(prod);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();    	
    	}
    	return prodList;
	}
	public void showproducts() {
		ObservableList<Products> list=getProductList();
		colId.setCellValueFactory(new PropertyValueFactory<Products,Integer>("id"));
		colProduct.setCellValueFactory(new PropertyValueFactory<Products,String>("prod"));
		colPrice.setCellValueFactory(new PropertyValueFactory<Products,Integer>("price"));
		colMinStock.setCellValueFactory(new PropertyValueFactory<Products,Integer>("mstock"));
		tContent.setItems(list);
	}
	void insertRecord() {
			String query="insert into products(prod,price,mstock) values('"+productName.getText()+"',"+price.getText()+","+minStock.getText()+")";
			executeQuery(query);
			showproducts();
	}
	void updateRecord() {
		String query="update products set prod='"+productName.getText()+"', price="+price.getText()+", mstock="+minStock.getText()+" where id="+id.getText()+"";
		executeQuery(query);
		showproducts();
		
	}

	private void executeQuery(String query) {
		// TODO Auto-generated method stub
		DatabaseConnection connect=new DatabaseConnection();
    	Connection connectDB=connect.getConnection();
    	Statement stmt;
    	try {
    		stmt=connectDB.createStatement();
    		stmt.executeUpdate(query);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}

}
