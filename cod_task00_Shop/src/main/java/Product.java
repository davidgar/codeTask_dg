
/**
 * This class is used to represent a product
 * and the operations associated with it (required by every product).
 * 
 * @author David
 *
 */

public interface Product {
	
	/**
	 * This method increases the amount of items in stock
	 */
	
	public void Refill ();
	
	/**
	 * This method decreases the amount of items in stock 
	 */
	
	public void Buy ();
	
	/**
	 * Accessor for the prize of the item
	 * 
	 * @return the prize
	 */
	
	public double getPrize ();
	

}
