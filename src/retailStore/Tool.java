package retailStore;

public class Tool {
	private int id;
	private String name;
	private int quantity;
	private double price;
	private int supplierID;

	public Tool(int id, String name, int quantity, double price, int supplierID) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.supplierID = supplierID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="Name: "+name+"\n";
//		s+="ID: "+id+"\n";
//		s+="Quantity: "+quantity+"\n";
//		s+="price: "+price+"\n";
//		
		return s;
	}


	

}
