package Homework3;
/**
 * 
 */
public class Smartphone implements Device{
	private final String category = "Smartphone";
	private String name ;
	private double price ;
	private int quantity;
	
	public Smartphone(String _name,double _price,int _quantity) {
		name=_name;
		price=_price;
		quantity=_quantity;
	}
/**
 * This is constructor.Values are initialized and complexity is o(1)
 */
	@Override
	public void setname(String _name) {
		name=_name;
	}
	/**
	 * this is setter.Complexity is o(1)
	 */
	public void setprice(double _price) {
		price=_price;
		
	}
	/**
	 * this is setter.Complexity is o(1)
	 */

	@Override
	public void setquantity(int _quantity) {
quantity=_quantity;
		
	}
	/**
	 * this is setter.Complexity is o(1)
	 */

	@Override
	public String getcategory() {
		// TODO Auto-generated method stub
		return category;
	}
	/**
	 * this is getter.Complexity is o(1)
	 */
	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}
	/**
	 * this is getter.Complexity is o(1)
	 */

	@Override
	public double getprice() {
		// TODO Auto-generated method stub
		return price;
	}
	/**
	 * this is getter.Complexity is o(1)
	 */
	@Override
	public int getquantity() {
		// TODO Auto-generated method stub
		return quantity;
	}
	/**
	 * this is getter.Complexity is o(1)
	 */
	
}

