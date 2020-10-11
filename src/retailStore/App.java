package retailStore;

public class App {

	public static void main(String[] args) {
		InventoryManager im =new InventoryManager("suppliers.txt", "items.txt");
			//while loop for menue//
//			f=im.updateInventory();
			im.addItemsToInventory("items.txt");
			String f=im.updateInventory();
			String x=im.updateInventory();
			x=im.updateInventory();
			x=im.updateInventory();
			System.out.println(f);
			im.decreaseQuantity(1019, 2);
			
	}

}
