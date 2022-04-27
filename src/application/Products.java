package application;

public class Products {
	private int id;
	private String prod;
	private int price;
	private int mstock;
	public Products(int id, String prod, int price, int mstock) {
		this.id = id;
		this.prod = prod;
		this.price = price;
		this.mstock = mstock;
	}
	public int getId() {
		return id;
	}
	public String getProd() {
		return prod;
	}
	public int getPrice() {
		return price;
	}
	public int getMstock() {
		return mstock;
	}
	

	
}
