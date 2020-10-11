package retailStore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Inventory {
private ArrayList<Tool>toolList;
private HashMap<Integer,String> supplier;

public Inventory(HashMap<Integer,String> supplier)
{	this.supplier=supplier;
	toolList=new ArrayList<Tool>();
}
public void addTool(int id, String name, int quantity, double price, int supplierID) {
	toolList.add(new Tool(id,name,quantity,price,supplierID));
}
public void deleteTool(int id,String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id && temp.getName()==name) {
			toolList.remove(i);
		}
	}
}
public String searchToolByID( int id) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getId()==id ) {
			return temp.toString();
		}
	}
	return null;
}
public String searchToolByName( String name) {
	for (int i=0;i<toolList.size();i++) {
		Tool temp=toolList.get(i);
		if(temp.getName().equals(name) ) {
			return temp.toString();
		}
	}
	return null;
}
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
public String checkQuantity() {
	StringBuffer sb =new StringBuffer();
	for (int i=0; i<toolList.size();i++) {
		sb.append("Tool Number: "+(i+1)+"\n"+toolList.get(i).toString()+"Quantity: "+toolList.get(i).getQuantity()+"\n\n");
	}
	return sb.toString();
	
}

}
