package Homework3;

public class Gamebox implements Device{
	private final String category = "Gamebox";
	private String name ;
	private double price ;
	private int quantity;
	
	public Gamebox(String _name,double _price,int _quantity) {
		name=_name;
		price=_price;
		quantity=_quantity;
	}
	/**
	 * This is a constructor.And same values are assigned at here.Comlexity is o(1)
	 */
	@Override
	public void setname(String _name) {
		name=_name;
	}
/**
 * this is setter complexity is o(1)
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
	
/**
 * Total complexit is o(1).This class does not include any loops.
 */
}

