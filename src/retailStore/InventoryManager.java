package retailStore;

import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.xpath.internal.operations.Or;
/**
 * This class reads the item.txt and supplier.txt and creates a {@link Inventory} class and many {@link Order} classes
 * Note: The way this class is set up, it receives a string of all tools that should be ordered then create new {@link Order}
 * @author zchem
 *
 */
public class InventoryManager {
	//privae variables 
private HashMap <Integer,String> supplierList;
private ArrayList<Order> orderList;
private Inventory inventory;
/**
 * Constructor where the {@link Inventory} class is initiated, add two methods are invoked
 * First method: {@link #addSupplierList(String)} which reads supplier.txt and store it in Hasshmap {@value #supplierList}
 * Second method: {@link #addItemsToInventory(String)} reads items.txt and adds tools to {@link Inventory}
 * @param supplierFile file name of supplier.txt
 * @param itemFile file name of item.txt
 */ 
public InventoryManager(String supplierFile,String itemFile) {
	supplierList=new HashMap<Integer, String>();
	orderList=new ArrayList<Order>();
	addSupplierList(supplierFile);
	inventory =new Inventory(supplierList);
	addItemsToInventory(itemFile);
}
/**
 * This method traverse through @param lis and creates a new {@link Order} and store it in local variable {@value #orderList}}
 * @param lis contains a list of tools to be ordered 
 * @return combined string of all the orders 
 */
public String generateOrder(ArrayList<String[]> lis) {
	for(int i=0;i<lis.size();i++) {
		orderList.add(new Order(lis.get(i)));
	}
	StringBuffer sb= new StringBuffer();
	for(int i=0;i<orderList.size();i++) {
		sb.append(orderList.get(i).printOrder()+"\n");
	}
	return sb.toString();
}
/**
 * This method reads the supplier.txt and stores the id and supplier name in hashmap. 
 * Note: there wasnt a need to store the other info of the suppplier.txt
 * @param fileName
 */
public void addSupplierList(String fileName) {
	try {
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		String line=reader.readLine();
		while (line!=null) {
			String temp[];
			temp=line.split("[;]");
			if (!supplierList.containsKey(Integer.parseInt(temp[0])))
			{
				supplierList.put(Integer.parseInt(temp[0]), temp[1]);
			}
			line=reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/**
 * This method reads the item.txt and creates a new tool in {@link Inventory} for each line in items.txt
 * @param fileName
 */
public void addItemsToInventory(String fileName)  {
	
	try {
		BufferedReader reader=new BufferedReader(new FileReader(fileName));
		String line=reader.readLine();
		while (line!=null) {
			String temp[];
			
			temp=line.split("[;]");
			inventory.addTool(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
			line=reader.readLine();
}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/**
 * This method writes the return of {@link #generateOrder(ArrayList)} into a txt file.
 * checks if file exists or not, if file exists then merge previous and new orders
 * @param textOrder All the orders for today in a string 
 */
	public void writeFile(String textOrder) {
		try {
			File file =new File ("Order.txt");
			if(file.exists()) {
				System.err.println("file exists-copying previous order and appending new order");
				BufferedReader reader =new BufferedReader(new FileReader(file));
				String line=reader.readLine();
				String history = null;
				while (line!=null) {
					history+=line+"\n";
					line=reader.readLine();
				}
			FileWriter fw =new FileWriter(file);
			String updated =history +"/n"+textOrder;
			fw.write(updated);
			fw.close();
			}
			else {FileWriter fw =new FileWriter(file);
			fw.write(textOrder);
			fw.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method invoke {@link Inventory#checkStock()} which traverses through all the tools and 
	 * orders new tools that has quantity below 40
	 */
	public void updateInventory() {
		ArrayList<String[]>temp =inventory.checkStock();
		String file=null;
		if(temp.size()>0) {
		file=generateOrder(temp);
		}
		if (file!=null) {
			System.err.println("Creating new order, check Order.text file");
			writeFile(file);
		}
	}
	/**
	 * This method invokes {@link Inventory #searchToolByName(String)} which searches tool by name
	 * @param name passed from Front end
	 * @return the tool as a String 
	 */
	public String searchByName(String name) {
		return inventory.searchToolByName(name);
	}
	/**
	 * This method invokes {@link Inventory#searchToolByID(int)} which searches tool by ID
	 * @param id passed from Front end
	 * @return the tool in a string
	 */
	public String searchByID(int id) {
		return inventory.searchToolByID(id);
	}
	/**
	 * This method invokes {@link Inventory #decreaseQuantity(int, int)} which decreases the quatity of a tool by 
	 * amount specified by user. Note, if decreased amount > actual amount then set the quatity to 0
	 * @param id of the tool to decrease
	 * @param amount to decrease
	 */
	public void decreaseQuantity(int id,int amount) {
		inventory.decreaseQuantity( id, amount);
	}

	@Override
	public String toString() {
		return inventory.toString();
	}
	/**
	 * This method invokes {@link Inventory #checkQuantity()} which returns the quantities for each tool
	 * @return
	 */
	public String checkQuatity() {
		return inventory.checkQuantity();
	}
	
}
