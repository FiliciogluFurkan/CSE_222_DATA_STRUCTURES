package Homework3;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * 
 */
public class Test {
	public static void main(String[] args) {

	   Inventory object=new Inventory();
       Scanner input=new Scanner(System.in);
		int choice=0;
		String cname,dname;
		double price;
		int quantity;
		System.out.println("Welcome to the Electronics Inventory Management System!\n");
		try {
		do {
			System.out.println("Please select an option:");
			System.out.println("1. Add a new device");
			System.out.println("2. Remove a device");
			System.out.println("3. Update device details");
			System.out.println("4. List all devices");
			System.out.println("5. Find the cheapest device");
			System.out.println("6. Sort devices by price");
			System.out.println("7. Calculate total inventory value");
			System.out.println("8. Restock a device");
			System.out.println("9. Export inventory report");
			System.out.println("0. Exit");
			choice=input.nextInt();
			if(choice<0 || choice> 10)
			System.out.println("Invalid option selected");
			/**
			 * their complexity is o(1).İt prints menu
			 */
		switch(choice) {
		/**
		 * According to user's choice,it calls the methods
		 */
		case 1:
			System.out.println("Enter category name: ");
			cname=input.next().trim();
			System.out.println("Enter device name: ");
			dname=input.next().trim();
			System.out.println("Enter price: ");
			price=input.nextDouble();
			System.out.println("Enter quantity: ");
			quantity=input.nextInt();
			if(cname.equals("Tv") || cname.equals("tv")) {
           Tv tv=new Tv(dname,price,quantity);
           object.add(tv);
			}else if(cname.equals("Headphones") || cname.equals("headphones")) {
	  		Headphones headphone=new Headphones(dname,price,quantity);
			object.add(headphone);
			}	else if(cname.equals("Smartphone") || cname.equals("smartphone")) {
					Smartphone smartphone=new Smartphone(dname,price,quantity);
			object.add(smartphone);
			}else if(cname.equals("Gamebox") || cname.equals("gamebox")) {
						Gamebox gamebox=new Gamebox(dname,price,quantity);
			object.add(gamebox);
			}else if(cname.equals("Laptop") || cname.equals("laptop")) {
							Laptop laptop=new Laptop(dname,price,quantity);
			object.add(laptop);
			}
			else{
			System.out.println("Invalid input");
			}
			break;
        
		case 2:
			object.remove();
			break;
        
        case 3:
	System.out.println("Enter the name of the device to update");
	dname=input.next().trim();
	System.out.println("Enter new price (leave blank to keep current price): ");
	price=input.nextDouble();
	System.out.println("Enter new quantity (leave blank to keep current quantity): ");
	quantity=input.nextInt();
	object.update(dname, price, quantity);
	break;
        
        case 4:
        	object.display();	
	
	break;
        
        case 5:
	object.find_cheapest();
	
	break;
    
        case 6:
	object.sort();
	
	break;
    
    case 7:
	object.calculate();
	break;
    
    case 8:	
	object.Restock();
		break;
    
    case 9:
	System.out.println("Electronics Shop Inventory Report");
	
	LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    System.out.println("Generated on: " + currentDate.format(formatter));
	object.export();
	/**
	 * This is the format of printing day/month/years
	 */
    break;
}

	}while(choice!=0);
		
		}catch(Exception e) {
			System.out.println("Invalid input ");
		}
		
	}

}
