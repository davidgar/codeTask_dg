
/**
 * Convenience class to represent trousers
 * 
 * @author David
 *
 */

public class Trousers implements Product{

	private String brand;
	private int code;
	private String colour;
	private int size;
	private double prize;
	
	static int units_stock = 0; 
	
	/**
	 * Default Trousers constructor
	 */
	
	public Trousers (){
		brand = "";
		code = -1;
		colour = "";
		size = 0;
		prize = 0.0;
	}
	
	/**
	 * Trousers constructor
	 * @param brand the brand of the trousers
	 * @param code the code of the trousers
	 * @param colour the colour of the trousers
	 * @param size the size of the trousers
	 * @param prize the prize of the trousers
	 */
	
	public Trousers (String brand, int code, String colour, int size, double prize){
		this.brand = brand;
		this.code = code;
		this.colour = colour;
		this.size = size;
		this.prize = prize;
	}
	
	/**
	 * Accessor for the brand
	 * 
	 * @return the brand of the trousers
	 */
	
	public String getBrand(){
		return brand;
	}
	
	/**
	 * Accessor for the code
	 * 
	 * @return the code of the trousers
	 */
	
	public int getCode(){
		return code;
	}
	
	/**
	 * Accessor for the colour
	 * 
	 * @return the colour of the trousers
	 */
	
	public String getColour(){
		return colour;
	}
	
	/**
	 * Accessor for the size
	 * 
	 * @return the size of the trousers
	 */
	
	public int getSize(){
		return size;
	}
	
	/**
	 * Accessor for the prize
	 */
	
	public double getPrize(){
		return prize;
	}
	
	/**
	 * Increases the amount of trousers in stock
	 */
	
	public void Refill (){
		units_stock ++;
	}
	
	/**
	 * Decreases the amount of trousers in stock
	 */
	
	public void Buy (){
		units_stock --;
	}
	
	/**
	 * Override toString
	 * 
	 * @return a String representation of the trousers
	 */
	
	public String toString (){
		return colour + " trousers " + brand + " of size " + size + " that costs " + 
				prize + " Euros.";
	}
	
}
