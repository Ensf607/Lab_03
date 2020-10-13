package retailStore;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
/**
 * This class simply creates a string for all the tools ordered for the day.It is created in {@link InventoryManager #generateOrder(java.util.ArrayList)}
 * @author zchem
 *
 */
public class Order {
	//private variables 
private int id;
private String date;
private String[] orderInfo;
/**
 * Constructor that assigns the private variables
 * @param orderInfo
 */
public Order( String[] orderInfo) {
	Random r=new Random();
	this.id = 10000 + new Random().nextInt(90000);
	this.orderInfo=orderInfo;
	Date today=Calendar.getInstance().getTime();
	this.date=today.getDate()+"-"+(today.getMonth()+1)+"-"+(today.getYear()+1900);
}
/**
 * This method simply creates a String for the order
 * @return
 */
public String printOrder() {
	StringBuffer sb =new StringBuffer();
	sb.append("Order ID:\t\t\t\t"+id+"\n");
	sb.append("Date Ordered:\t\t\t\t"+date+"\n");
	sb.append("Item description:\t\t\t"+orderInfo[0]+"\n");
	sb.append("Amount ordered:\t\t\t\t"+orderInfo[1]+"\n");
	sb.append("Supplier:\t\t\t\t"+orderInfo[2]+"\n");
	sb.append("****************************\n");
	return sb.toString();
}
}
