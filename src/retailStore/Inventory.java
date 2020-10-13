package retailStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/**
 * This class creates many {@link Tool} classes and store them in a local variable .
 * Also it can check for a tool by name or id, decrease quantity of a tool, and automatically create new orders for tools that has quatity below 40
 * @author zchem
 *
 */
public class Inventory {
	//private variables
private ArrayList<Tool>toolList;
private HashMap<Integer,String> supplier;
/**
 * Constructor
 * @param supplier this is a hashmap contains the supplier id and name
 */
public Inventory(HashMap<Integer,String> supplier)
{	this.supplier=supplier;
	toolList=new ArrayList<Tool>();
}
/**
 * Creates a new {@link Tool} and stores it in {@link #toolList}
 * @param id passed from Frontend via {@link InventoryManager}
 * @param name passed from Frontend via {@link InventoryManager}
 * @param quantity passed from Frontend via {@link InventoryManager}
 * @param price passed from Frontend via {@link InventoryManager}
 * @param supplierID passed from Frontend via {@link InventoryManager}
 */
public void addTool(int id, String name, int quantity, double price, int supplierID) {
	toolList.add(new Tool(id,name,quantity,price,supplierID));
}
/**
 * This method can delete a tool
 * @param id  passed from Frontend via {@link InventoryManager}
 * @param name passed from Frontend via {@link InventoryManager}
 */
public void deleteTool(int id,String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id && temp.getName()==name) {
			toolList.remove(i);
		}
	}
}
/**
 * This method searches if a tool exists based on id
 * @param id passed from Frontend via {@link InventoryManager}
 * @return a toString() of Tool
 */
public String searchToolByID( int id) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id ) {
			return temp.toString();
		}
	}
	return null;
}
/**
 * This method searches if a tool exists based on tool name
 * @param name passed from Frontend via {@link InventoryManager}
 * @return a toString() of Tool
 */
public String searchToolByName( String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getName().equals(name) ) {
			return temp.toString();
		}
	}
	return null;
}
/**
 * This method traverse through all the tools stored in {@link #toolList} and checks if tool's quantity is below 40,
 * if it is below 40, then update amount and create an oder of 50-prev amount, which is returned to {@link InventoryManager} which 
 * in turn creates {@link Order}
 * @return a string of all the tools that should be ordered
 */
public  ArrayList<String[]> checkStock (){
	ArrayList<String[]> newOrderList = new ArrayList<String[]>();
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getQuantity()<40) {
			String[] toolInfo=new String [3] ;
			toolInfo[0]=temp.getName();
			toolInfo[1]=String.valueOf(50-temp.getQuantity());
			toolList.get(i).setQuantity(50);
			toolInfo[2]=supplier.get(temp.getSupplierID());
			
		
		newOrderList.add(toolInfo);}
		
			}
	
	
return newOrderList;

}
/**
 * This method can decrease the quatity of any tool available
 * @param id passed from Frontend via {@link InventoryManager}
 * @param amount passed from Frontend via {@link InventoryManager}
 */
public void decreaseQuantity(int id, int amount) {
	boolean check=true;
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id) {
			check=false;
			if(temp.getQuantity()>amount)
			temp.setQuantity(temp.getQuantity()-amount);
			else
				temp.setQuantity(0);
		
		}
	
}
	if(check)
System.err.println("Item Not Found");	
}

@Override
public String toString() {
	StringBuffer sb =new StringBuffer();
	for (int i=0; i<toolList.size();i++) {
		sb.append("Tool Number: "+(i+1)+"\n"+toolList.get(i).toString()+"\n");
	}
	return sb.toString();
}
/**
 * This method simply creates a string of all the tools and their quantities available
 * @return
 */
public String checkQuantity() {
	StringBuffer sb =new StringBuffer();
	for (int i=0; i<toolList.size();i++) {
		sb.append("Tool Number: "+(i+1)+"\n"+toolList.get(i).toString()+"Quantity: "+toolList.get(i).getQuantity()+"\n\n");
	}
	return sb.toString();
	
}

}
