package Homework3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class Inventory {
	    private LinkedList<Inventory> list;
	    private ArrayList<Device> devices;
	    private String category;

	    public Inventory() {
	        this.list = new LinkedList<>();
	    }
	    /**
	     * This is constructor.Complexity is o(1)
	     * @param category
	     * @param device
	     */

	    public Inventory(String category, Device device) {
	        this.category = category;
	        this.devices = new ArrayList<>();
	        this.devices.add(device);
	    }
	    /**
	     * this is constructor of Inventory class.It makes new arraylist in devices.Complexity is o(1)
	     * also adds the device to arraylist if categories are equal each other
	     * @param device
	     */

	    public void add(Device device) {
	    	int flag3=0;
	    	for(Inventory temp:list) {
				   for (Device devices : temp.devices) {
				        if(devices.getname().equals(device.getname())) {
				   flag3=1;
				   break;
				        }
				}
			}
	 
	    	if (list == null) {
	            list = new LinkedList<>();
	            list.add(new Inventory(device.getcategory(), device));
	        } 
	        //if list is empty,it creats new linkedlist and adds devices (this creates new arraylist at this node)
	        else if(flag3!=0) {
	        	System.out.println("This device has already added.");
	        }
	        else {
	           int flag=0;
	            for (Inventory temp : list) {
	                if (temp.devices.get(0).getcategory().equals(device.getcategory())) {
	                    temp.devices.add(device);
	                    flag=1;
	                    break;
	                }
	            }
	            if (flag==0) {
	                list.add(new Inventory(device.getcategory(), device));
	            }
	            /**
	             * There is for loop at here.İt goes along the Linked list so it is complexit is o(n)
	             * if statement does not include any for loop.Just adds devices to linked list 
	             */
	        }
	    }

public void remove() {
    System.out.println("Please enter the number of the device you want to remove:");
    int number;
    int counter = 1; // İlk numaralandırmaya 1'den başla
    
    // Liste başından itibaren tüm cihazları yazdır
    System.out.println("Device list:");
 for(Inventory temp:list) {
	  for (Device device : temp.devices) {
          System.out.printf("%d. Category: %s, Name: %s, Price: %.2f$, Quantity: %d\n",
                  counter, device.getcategory(), device.getname(), device.getprice(), device.getquantity());
          counter++;
      }
 }
    /**
     * Complexity is o(n*m)
     */
    Scanner input = new Scanner(System.in);
    do {
        System.out.print("Enter the number: ");
        number = input.nextInt();
        if (number <= 0 || number >= counter) {
            System.out.println("Invalid selection. Please try again.");
        }
    } while (number <= 0 || number >= counter);
    //if input is not valid,it takes again a input from user until it is correct
    int currentCounter = 1;
    int deviceCounter;
    for(Inventory temp:list) {
        deviceCounter = 0;
        for (Device device : temp.devices) {
            if (currentCounter == number) {
                temp.devices.remove(deviceCounter);
                System.out.println("Device removed successfully.");
                return;
            }
            deviceCounter++;
            currentCounter++;
        } 
        
    }
    /**
     * it includes again two for loop inside each other.Complexity is o(n^2)
     * counters are used to remove devices.One of the is for node -,the other one is for arraylists
     */
}

	public void update(String _name, double _price, int _quantity) {

		for(Inventory temp:list) {
			   for (Device devices : temp.devices) {
			        if(devices.getname().equals(_name)) {
			     devices.setprice(_price);
			     devices.setquantity(_quantity);
			     System.out.printf("%s details updated: Price- %.2f, Quantity- %d\n",_name,_price,_quantity);
			        }
			}
		}
		
			
	}
	/**
	 *it includes two for loop inside each other.Complexity is o(n*m)
	 *this metehod uses setters and getter.İt updates the values according to user input
	 */
	
	public void display() {
		
		int counter=0;
		for(Inventory temp:list) {
			   for (Device devices : temp.devices) {
		            System.out.printf("%d. Category: %s, Name: %s, Price: %.2f$, Quantity: %d\n",
		                    counter+1, devices.getcategory(), devices.getname(), devices.getprice(), devices.getquantity());
		            counter++;
		        }
		}
		
		System.out.println();
	}
/**
 *it prints all devices.Complexity is o(n*m)
 */
	
	public void find_cheapest() {

	    String cheapestCategory = "";
	    String cheapestName = "";
	    double cheapestPrice = Double.MAX_VALUE; //it assign the max value then looks all arraylist
	    int cheapestQuantity = 0;


	    System.out.println("Device list:");
	 for(Inventory temp:list) {
		  for (Device device : temp.devices) {
	            double currentPrice = device.getprice();
	            if (currentPrice < cheapestPrice) {
	                cheapestCategory = device.getcategory();
	                cheapestName = device.getname();
	                cheapestPrice = currentPrice;
	                cheapestQuantity = device.getquantity();
	            }
	        }
	 }
//it makes sorting.İf one device is smaller than other device,it keep the features
	    if (cheapestPrice != Double.MAX_VALUE) { // En ucuz cihaz bulunduysa
	        System.out.println("The cheapest device is:");
	        System.out.printf("Category: %s, Name: %s, Price: %.2f, Quantity: %d\n",
	                cheapestCategory, cheapestName, cheapestPrice, cheapestQuantity);
	        //prints cheapest device
	    } else {
	        System.out.println("No device found.");
	    }
	}

	public void sort() {
	
		ArrayList<Device>devices=new ArrayList<>();
	for(Inventory temp:list) {
		for(Device devicese:temp.devices ) {
			devices.add(devicese);
		}
	}
		/**
		 * Complexity is o(n*m)
		 * I created new arraylist and keeps all devices.İt sorts this array and prints
		 */
	    Collections.sort(devices, Comparator.comparing(Device::getprice));
		/**
		 * it sorts the arraylist
		 */
	    System.out.println("Devices sorted by price:");
	    int counter = 1;
	    for (Device device :devices) {
	        System.out.printf("%d. Category: %s, Name: %s, Price: %.2f$, Quantity: %d\n",
	                counter, device.getcategory(), device.getname(), device.getprice(), device.getquantity());
	        counter++;
	    }
		/**
		 * complexity is o(n).Total complexity is o(n*m + n)=o(n*m)
		 */
		
	
	}

	
	public void calculate() {
	
	double total_price=0;
	for(Inventory temp:list) {
		for(Device devices:temp.devices) {
			total_price+=devices.getprice()*devices.getquantity();	
			}
	}
	System.out.printf("Total Inventory Value: %.2f\n",total_price);
	}
	/**
	 * Calculates total price.Complexity is o(n*m)
	 */

	
	public void Restock() {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the name of the device to restock: ");
		String devicename=input.next().trim();
		System.out.println("Do you want to add or remove stock? (Add/Remove): ");
		String line=input.next().trim();
		int quantity2=0,flag=0,flag2=0;
		/**
		 * it takes input from user.
		 */
		if(line.equals("Add") || line.equals("add")) {
			try {
			do {
			System.out.println("Enter the quantity to add: ");
			quantity2=input.nextInt();
			if(quantity2<0) {
				System.out.println("Invalid quantity entered. ");
			}
			else {
				flag=1;
			}
			}while(flag!=1);
			}catch(Exception e) {
				System.out.println("Invalid input");
				flag2=1;
			}
		for(Inventory temp:list) {
			for(Device device:temp.devices) {
				if(device.getname().equals(devicename)) {
					int value=device.getquantity();
					value+=quantity2;
					device.setquantity(value);
					if(flag2==0)
					System.out.printf("%s restocked.New quantity: %d\n",devicename,value);
				}
			}
		}
			/**
			 * İts complexity is o(n^2).There is two for loop.
			 */
		}
		else if(line.equals("Remove") || line.equals("remove")) {
			try {
			do {
				System.out.println("Enter the quantity to remove: ");
				quantity2=input.nextInt();
				if(quantity2<0) {
					System.out.println("Invalid quantity entered. ");
				}
				else {
					flag=1;
				}
				}while(flag!=1);
			}catch(Exception e) {
			System.out.println("Invalid input");
			flag2=1;
		}
		for(Inventory temp:list) {
			for(Device device:temp.devices) {
				if(device.getname().equals(devicename)) {
					int value=device.getquantity();
					value-=quantity2;
					if(value<0)
						value=0;
					device.setquantity(value);
					if(flag2==0)
					System.out.printf("%s stock reduced. New quantity: %d\n",devicename,value);
				}
			}
		}
		/**
		 * İts complexity is o(n*m).There is two for loop.
		 */
		}
		else {
			System.out.println("Invalid line entered");
		}
		
	}
/**
 * Complexity is o(n*m) //
 */
	
	public void export() {
		 System.out.println("| ID | Category   | Name      | Price    | Quantity |");
		    System.out.println("--------------------------------------------------");
  int counter=0;
		  for(Inventory temp:list) {
			  for (Device device : temp.devices) {
		            System.out.printf("| %-2d | %-10s | %-10s | %7.2f | %-8d |\n",
		                    counter+1, device.getcategory(), device.getname(), device.getprice(), device.getquantity());
		        counter++;
		        }
		  }
	System.out.println("\n--------------------------------------------------");
	System.out.println("\nSummary:");	
	System.out.println("- Total Number of Devices: "+counter);	
	calculate();
	System.out.println("\nEnd of Report\n");	
	
	 try (PrintWriter writer = new PrintWriter(new FileWriter("export.txt"))) {
         writer.println("| ID | Category   | Name      | Price    | Quantity |");
         writer.println("--------------------------------------------------");
          counter = 0;
         for (Inventory temp : list) {
             for (Device device : temp.devices) {
                 writer.printf("| %-2d | %-10s | %-10s | %7.2f | %-8d |\n",
                         counter + 1, device.getcategory(), device.getname(), device.getprice(), device.getquantity());
                 counter++;
             }
         }
         writer.println("\n--------------------------------------------------");
         writer.println("\nSummary:");
         writer.println("- Total Number of Devices: " + counter);
         calculate();
         writer.println("\nEnd of Report\n");
     } catch (IOException e) {
         System.err.println("Dosya yazma hatası: " + e.getMessage());
     }
	
	
	/**
	 * complexity is o(n*m),prints export report
	 */
	}


}
