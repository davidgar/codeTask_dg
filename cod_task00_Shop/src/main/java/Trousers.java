
public class Trousers implements Product{

	private String brand;
	private int code;
	private String colour;
	private int size;
	private double prize;
	
	static int units_stock = 0; 
	
	public Trousers (){
		brand = "";
		code = -1;
		colour = "";
		size = 0;
		prize = 0.0;
	}
	
	public Trousers (String brand, int code, String colour, int size, double prize){
		this.brand = brand;
		this.code = code;
		this.colour = colour;
		this.size = size;
		this.prize = prize;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public int getCode(){
		return code;
	}
	
	public String getColour(){
		return colour;
	}
	
	public int getSize(){
		return size;
	}
	
	public double getPrize(){
		return prize;
	}
	
	public void Refill (){
		units_stock ++;
	}
	
	public void Buy (){
		units_stock --;
	}
	
	public String toString (){
		return colour + " trousers " + brand + " of size " + size + " that costs " + 
				prize + " Euros.";
	}
	
}
