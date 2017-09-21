
/**
 * Convenience class to represent a shirt
 * 
 * @author David
 *
 */

public class Shirt implements Product{
	
	private String brand;
	private int code;
	private String colour;
	private char size;
	private double prize;
	
	static int units_stock = 0; 
	
	
	/**
	 * Default Shirt constructor 
	 */
	
	public Shirt (){
		brand = "";
		code = -1;
		colour = "";
		size = 'e';
		prize = 0.0;
	}
	
	/**
	 * Shirt constructor
	 * @param brand the brand of the shirt
	 * @param code the code associated with the shirt
	 * @param colour the colour of the shirt
	 * @param size the size of the shirt
	 * @param prize the prize of the shirt
	 */
	
	public Shirt (String brand, int code, String colour, char size, double prize){
		this.brand = brand;
		this.code = code;
		this.colour = colour;
		this.size = size;
		this.prize = prize;
	}
	
	/**
	 * Accessor for the brand
	 * 
	 * @return the brand of the shirt
	 */
	
	public String getBrand(){
		return brand;
	}
	
	/**
	 * Accessor for the code
	 * 
	 * @return the code of the shirt
	 */
	
	public int getCode(){
		return code;
	}
	
	/**
	 * Accessor for the colour
	 * 
	 * @return the colour of the shirt
	 */
	
	public String getColour(){
		return colour;
	}
	
	/**
	 * Accessor for the size
	 * 
	 * @return the size of the shirt
	 */
	
	public char getSize(){
		return size;
	}
	
	/**
	 * Accessor for the prize
	 */
	
	public double getPrize(){
		return prize;
	}
	
	/**
	 * Increases the amount of shirts in stock
	 */
	
	public void Refill (){
		units_stock ++;
	}
	
	/**
	 * Decreases the amount of shirts in stock
	 */
	
	public void Buy (){
		units_stock --;
	}
	
	/**
	 * Override toString
	 * 
	 * @return a String representation of a Shirt
	 */
	
	public String toString (){
		return colour + " shirt " + brand + " of size " + size + " that costs " + 
				prize + " Euros.";
	}

}
