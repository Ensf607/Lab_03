package retailStore;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome!!");
		System.out.println("Updating inventory");
		InventoryManager im =new InventoryManager("suppliers.txt", "items.txt");
			boolean runStatus=true;
			String file=null;
			
			String menue="1-> List all tools"+"\n2-> Search tool by Name\n"+"3-> Search by ID\n"+"4-> Check item quatity\n"+"5-> Decrease an item by ID\n"+"6-> Quit";
			while (runStatus) {
				im.updateInventory();
				System.out.println("Please choose one of the options below \n"+menue);
				Scanner scanner =new Scanner(System.in);
				int ans=scanner.nextInt();
				switch (ans) {
				case 1:
					System.out.println(im);
					break;
				case 2:
					System.out.println("Please enter Name of tool");
					String toolByName=im.searchByName(scanner.next());
					if(toolByName!=null)
					System.out.println(toolByName);
					else
						System.err.println("Tool Not Found!");
				break;
				case 3:
					System.out.println("Please enter ID of tool");
					String toolByID=im.searchByID(scanner.nextInt());
					if(toolByID!=null)
					System.out.println(toolByID);
					else
						System.err.println("Tool Not Found!");
					break;
				case 4:
					System.out.println(im.checkQuatity());
					break;
				case 5:
					System.out.println("Enter ID of tool and the amount by which you want to decrease ");
					im.decreaseQuantity(scanner.nextInt(), scanner.nextInt());
					im.updateInventory();
				
					break;
				case 6:
					runStatus=false;
					System.out.println("Good bye!!");
					break;
				default:
					System.err.println("Please enter a valid option");
				}
					
				
				
			}
			
	}

}
