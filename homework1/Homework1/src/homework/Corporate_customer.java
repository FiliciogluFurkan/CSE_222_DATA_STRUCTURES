package homework;

public class Corporate_customer extends Customer {
protected String company_name;
public Corporate_customer(String _name,String _surname,String _phone,String _adress,int _ID,int _operator_ID,String _company_name) { 
	super(_name,_surname,_phone,_adress,_ID,_operator_ID);
	company_name=_company_name;//it extends customer class also includes company name
}
public Corporate_customer() {
	super("","","","",0,0);
	company_name="";
}
public void print_customer(){
super.print_customer();//prints customers
	 System.out.printf("Company name: %s\n", company_name); 
}
}
