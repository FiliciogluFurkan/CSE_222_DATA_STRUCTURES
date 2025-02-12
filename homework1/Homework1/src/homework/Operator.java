package homework;

import java.io.File;
import java.util.Scanner;

public class Operator extends Person{
private Customer[] Customer;
private int Wage;
private Customer[] customers;
public  int counter=0;
public int counter2=0;

public Operator(String _name,String _surname,String _adress,String _phone,int _ID,int _Wage) {
super(_name,_surname,_phone,_adress,_ID);//calls base class constructor
Wage=_Wage;	
customers = new Customer[100];
}//constructor for operator class
public Operator() {
	super("a","b","c","d",5);
}


public void print_operator() {//prints the operators
System.out.println("*** Operator Screen ***");	
System.out.println("----------------------------");
System.out.printf("Name & surname: %s %s\n",name,surname);
System.out.printf("Address: %s\n",address);	
System.out.printf("Phone: %s\n",phone);	
System.out.printf("ID: %d\n",ID);
System.out.printf("Wage: %d\n",Wage);	
System.out.println("----------------------------");
}
public void print_customers() {//ı have read the file again to keep orders 
	 File file = new File("content.txt");
	    String[] stringarray;
	    Order[] order = new Order[100];
	    for (int i = 0; i < 100; i++) {
	        order[i] = new Order();
	    }//

	    if (file.exists() && file.isFile()) {
	        try {
	            Scanner scanner = new Scanner(file);
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                stringarray = line.split(";");
	                if (stringarray[0].equals("order")) {//if first word is order
	                	try {
	                		if (stringarray.length == 6 && stringarray[1].length() > 0 && Integer.parseInt(stringarray[2]) > 0 && Integer.parseInt(stringarray[2])<100000 && Integer.parseInt(stringarray[3]) > 0 && Integer.parseInt(stringarray[3])<100000 && Integer.parseInt(stringarray[4]) >= 0 && Integer.parseInt(stringarray[4]) < 4 && Integer.parseInt(stringarray[5]) > 0 && Integer.parseInt(stringarray[5])<100000) {
    	                    	order[counter++] = new Order(stringarray[1], Integer.parseInt(stringarray[2]), Integer.parseInt(stringarray[3]), Integer.parseInt(stringarray[4]), Integer.parseInt(stringarray[5]));
    	                    }
    	                } catch (NumberFormatException e) {
    	                    // Eğer bir hata oluşursa, ilgili satırın işlenmesini geçersiz kıl
    	                    continue; // Bir sonraki satıra geç
    	                } 
	                } 
	            }
	            scanner.close();
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Dosya bulunamadı veya erişilemez.");
	    }	
	int flag=0;///to control there is customer or not
    for (int i = 0; i < customers.length; i++) {
        if (customers[i] instanceof Corporate_customer && customers[i]!=null) {
        	  System.out.printf("Customer #%d ", i + 1);
        	Corporate_customer corporateCustomer = (Corporate_customer) customers[i]; // Corporate_customer'a özgü özelliklere erişmek için tip dönüşümü yapılıyor
            System.out.printf("(a corporate customer) \n");  
            customers[i].define_orders(order);         
        	customers[i].print_customer(); 
        	customers[i].print_orders(); 
        	System.out.println("----------------------------");
        	flag=1;
        } else if(customers[i] instanceof Retail_customer && customers[i]!=null){
        	  System.out.printf("Customer #%d ", i + 1);
        	System.out.printf("(a retail customer) \n");
        	customers[i].print_customer();
            customers[i].define_orders(order);          
        	customers[i].print_orders();
        	System.out.println("----------------------------");
            // Company name özelliği Retail_customer sınıfında olmadığı için burada yazdırmaya gerek yok
        flag=1;
        }
    }
    if(flag==0) {
    	System.out.println("This operator doesn't have any customer.");
    }
}
public void define_customers(Customer other[]) {
    for(int i = 0; i < other.length; i++) {
        if(ID == other[i].operator_ID) {
            this.customers[counter++] = other[i]; // Customer dizisine erişiyoruz
        }
    }
}




	
}
