package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextField;

public class Items {
	private SimpleIntegerProperty sno;
	private TextField items;
	private TextField qty;
	private SimpleIntegerProperty rate;
	public Items(int sno, String items, String qty , int rate) {
		super();
		this.sno = new SimpleIntegerProperty(sno);
		this.items = new TextField(items);
		this.qty = new TextField(qty);
		this.rate = new SimpleIntegerProperty(rate);
	}
	public int getSno() {
		return sno.get();
	}
	public TextField getItems() {
		return items;
	}
	public TextField getQty() {
		return qty;
	}
	public int getRate() {
		return rate.get();
	}
	

}
