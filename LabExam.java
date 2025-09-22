import java.util.*;

class Item{
	String code;
	String name;
	int quantity;
	
	Item (String code, String name,int quantity){
				this.code = code;
				this.name = name;
				this.quantity = quantity;
	}
	public String toString() {
		
		
		return code + "|" + name + "|" + quantity ; 
				
	}
}

class Truck{
	String plate;
	String driver;
	
	Truck(String plate,	String driver){
		this.plate = plate;
		this.driver = driver;	
	}
		
		public String toString() {			
			return plate + "|" + driver;		
	}
	
}




public class LabExam {
	public static void main(String []args) {	
    ArrayDeque<Item> warehouseStack = new ArrayDeque<>();
    ArrayDeque<Truck> truckQueue = new ArrayDeque<>();
    Scanner scan = new Scanner (System.in);
    
    while (true) {
        System.out.println("\n=== Warehouse Loading System  ===");
        System.out.println("[1] Store item (push)");
        System.out.println("[2] View Warehouse Stack");
        System.out.println("[3] Register Truck (enqueue)");
        System.out.println("[4] View Waiting Trucks");
        System.out.println("[5] Load Next Truck (pop item + poll truck)");
        System.out.println("[0] Exit");
        System.out.print("Choose an option: ");
		
        int choice = scan.nextInt();
        scan.nextLine();
        
        if (choice == 0) {
        	System.out.println("Exiting Program");
        }
        
        switch (choice) {
        
        case 1:
        	System.out.println("Enter code");
        	String code = scan.nextLine();
            System.out.print("Enter name: ");
            String name = scan.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scan.nextInt();
            scan.nextLine();
            Item i = new Item (code, name, quantity);
            warehouseStack.push(i);
            System.out.println("Stored: " + i);
            break;
            
        case 2:
            if (warehouseStack.isEmpty()) {
                System.out.println("No items in warehouse.");
            } else {
                System.out.println("TOP →");
                for (Item cont : warehouseStack) {
                    System.out.println(cont);
                }
                System.out.println("← BOTTOM");
            }
            break;
            
        case 3:
            System.out.print("Enter truck plate: ");
            String itemName = scan.nextLine();
            System.out.print("Enter driver's name: ");
            String driver = scan.nextLine();
            Truck t = new Truck(itemName, "Sir. " + driver);
            truckQueue.offer(t);
            System.out.println("Registered: " + t);
            break;
            
        case 4:
            if (truckQueue.isEmpty()) {
                System.out.println("No trucks waiting.");
            } else {
                System.out.println("FRONT →");
                for (Truck truck : truckQueue) {
                    System.out.println(truck);
                }
                System.out.println("← REAR");
            }
            break;
            
        case 5:
            if (warehouseStack.isEmpty()) {
                System.out.println("No items to load.");
            } else if (truckQueue.isEmpty()) {
                System.out.println("No trucks waiting.");
            } else {
                Item loadCont = warehouseStack.pop();
                Truck loadShip = truckQueue.poll();
                System.out.println("Loaded: " + loadCont + " → " + loadShip + "\n");
                System.out.println("Remaining items: " + warehouseStack.size());
                System.out.println("Remaining trucks waiting: " + truckQueue.size());
            }
            break;

        default:
            System.out.println("Invalid option. Try again.");
            scan.close();  
    }
}

  

            
            

        		
        
        
        }
        
        
			
		
		
	
}

