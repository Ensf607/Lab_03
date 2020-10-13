package retailStore;
/**
 * This class simply stores the info that each tool has, example name,id,price..etc
 * @author zchem
 *
 */
public class Tool {
	//private variables
	private int id;
	private String name;
	private int quantity;
	private double price;
	private int supplierID;
/**
 * Constructor that updates the local private variables with the passed @param
 * @param id
 * @param name
 * @param quantity
 * @param price
 * @param supplierID
 */
	public Tool(int id, String name, int quantity, double price, int supplierID) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.supplierID = supplierID;
	}
/**
 * Getter for Tool Id
 * @return
 */
	public int getId() {
		return id;
	}
/**
 * Setter for tool Id
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}
/**
 * Getter for tool name
 * @return
 */
	public String getName() {
		return name;
	}
/**
 * Setter for tool name
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * Getter for tool quantity 
 * @return
 */
	public int getQuantity() {
		return quantity;
	}
/**
 * Setter for tool quantity 
 * @param quantity
 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/**
 * Getter for tool price
 * @return
 */
	public double getPrice() {
		return price;
	}
/**
 * Setter for tool price
 * @param price
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Getter for supplier id
 * @return
 */
	public int getSupplierID() {
		return supplierID;
	}
/**
 * Setter for supplier iD
 * @param supplierID
 */
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	@Override
	public String toString() {
		String s="Name: "+name+"\n";
		return s;
	}


	

}
