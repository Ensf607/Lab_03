package retailStore;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Order {
private int id;
private String date;
private String[] orderInfo;
public Order( String[] orderInfo) {
	Random r=new Random();
	this.id=r.nextInt(100000);
	this.orderInfo=orderInfo;
	Date today=Calendar.getInstance().getTime();
	this.date=today.getDate()+"-"+(today.getMonth()+1)+"-"+(today.getYear()+1900);
}
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
