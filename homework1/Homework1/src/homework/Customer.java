package homework;

import java.util.Scanner;

public class Customer extends Person {
public int counter=0;	
public int counter2=0;
protected Order[] orders;
protected int operator_ID;
public void print_customer() {  //prints customer's features
      System.out.printf("Name & Surname: %s %s\n", name,surname);
      System.out.printf("Address: %s\n",address);    
      System.out.printf("Phone: %s\n", phone);    
      System.out.printf("ID: %d\n", ID);
      System.out.printf("Operator ID: %d\n", operator_ID);
      
}
public void print_orders() {
for(int i=0;i<100;i++) {
	if(orders[i]!=null) {
    System.out.printf("Order #%d =>",i+1);	
	orders[i].print_Order();
	}
	}

}
public void define_orders(Order[] other) {
	  for(int i = 0; i < other.length; i++) {
	        if(ID == other[i].customer_ID) {//if ID's matches
	            this.orders[counter++] = other[i]; 
	        }
	    }
	
}
public Customer(String _name,String _surname,String _phone,String _adress,int _ID,int _operator_ID) {
	super(_name,_surname,_adress,_phone,_ID);
	operator_ID=_operator_ID;
	 this.orders = new Order[100]; // orders dizisini başlatıyoruz
}//constructor for customer
	 
}
