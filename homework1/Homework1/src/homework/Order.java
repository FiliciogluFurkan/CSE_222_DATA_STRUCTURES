package homework;

public class Order {
protected String product_name;
protected int count;
protected int total_price;
protected int status;
protected int customer_ID;

public Order(String _product_name,int _count,int _total_price,int _status,int _customerID) {//constructor for order
	product_name=_product_name;
	count=_count;
	total_price=_total_price;
	status=_status;
	customer_ID=_customerID;
}
public Order() {
}

public void print_Order() {
	System.out.printf("Product name: %s -Count: %d -Total price: %d -",product_name,count,total_price);
	if(status==0)
	System.out.printf("Status: Initialized");
	if(status==1)
		System.out.printf("Status: Processing");
	if(status==2)
		System.out.printf("Status: Completed");
	if(status==3)
		System.out.printf("Status: Cancelled");
	System.out.println();
	//according to the status number,it prints 
}
	
}
