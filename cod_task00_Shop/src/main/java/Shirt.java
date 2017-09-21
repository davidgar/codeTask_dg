
public class Shirt implements Product{
	
	private String brand;
	private int code;
	private String colour;
	private char size;
	private double prize;
	
	static int units_stock = 0; 
	
	public Shirt (){
		brand = "";
		code = -1;
		colour = "";
		size = 'e';
		prize = 0.0;
	}
	
	public Shirt (String brand, int code, String colour, char size, double prize){
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
	
	public char getSize(){
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
		return colour + " shirt " + brand + " of size " + size + " that costs " + 
				prize + " Euros.";
	}

}
