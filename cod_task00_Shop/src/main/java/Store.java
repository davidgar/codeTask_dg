
/**
 * This class contains the main method to test the program.
 * It also contains the methods required to simulate the operations
 * available in the store.
 * 
 * @author David
 */

import java.util.*;


public class Store {
	
	static final int MAX_STOCK = 20;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Map<Integer, Product> products = new HashMap<Integer, Product>();
		
		int opt = 0;
		boolean error = false;
		
		do{
			System.out.println ("\nWelcome to STORE\n");
			System.out.println ("Select option:");
			System.out.println ("1. Add new shirt to store.");
			System.out.println ("2. Add new trousers to store.");
			System.out.println ("3. Buy.");
			System.out.println ("4. Show stock.");
			System.out.println ("5. Exit program.");
		
			try{
				error = false;	
				opt = input.nextInt();
		
				switch (opt){
					case 1:{
						if (Shirt.units_stock < MAX_STOCK){
							Shirt sh = AddShirt_Menu ();
							sh.Refill();
							products.put(sh.getCode(), sh);	
							System.out.println ("The stock of shirts is now of " + Shirt.units_stock + " units.");
						}
						else{
							System.out.println("Stock is full of shirts. New shirts cannot be added.");
						}
						break;
					}
					case 2:{
						if (Trousers.units_stock < MAX_STOCK){
							Trousers tr = AddTrousers_Menu ();
							tr.Refill();
							products.put(tr.getCode(), tr);	
							System.out.println ("The stock of trousers is now of " + Trousers.units_stock + " units.");
						}
						else{
							System.out.println("Stock is full of trousers. New trousers cannot be added.");
						}
						break;
					}
					case 3:{
						if (!products.isEmpty())
							Buy (products);
						else
							System.out.println ("No products in the store. Nothing for sale.");
						break;				
					}
					case 4:{
						if (!products.isEmpty())
							Show_Stock (products);
						else
							System.out.println ("No products in the store.");
						break;
					}
					case 5:{
						System.out.println ("Thanks!");
						break;
					}
					default:{
						System.out.println ("Error. Invalid option.");
						break;
					}
				}
			}
			catch (InputMismatchException e){
				System.out.println ("Please, enter a numerical option.");
				error = true;
				input.nextLine();
			}
		}while (opt!=5 || error);

	}
	
	/**
	 * This method prompts the menu to create
	 * a new shirt in order to be added to the store.
	 * 
	 * @return the shirt already created.
	 */
	
	public static Shirt AddShirt_Menu (){
		Scanner input = new Scanner(System.in);
		String b = "";
		String col = "";
		int c = 0;
		double pr = 0.0;
		char s = 'x';
		boolean error = false;
		
		
		do{
			System.out.println ("\nAdd new shirt menu\n");
		
			System.out.flush();
			
			try{			
				System.out.println ("Enter Brand: ");
				b = input.nextLine();
				System.out.println ("Enter Code (integer): ");
				c = input.nextInt();
				input.nextLine();
				System.out.println ("Enter Colour: ");
				col = input.nextLine();
				do{
					System.out.println ("Enter Size (S/M/L): ");
					s = input.nextLine().charAt(0);
					s = Character.toUpperCase(s);
				}while ((s!='S') && (s!='M') && (s!='L'));
		
				System.out.println ("Enter prize (in Euros): ");
				pr = input.nextDouble();
				error = false;
			
			}
			catch (InputMismatchException e){
				System.out.println ("Incorrect format of input data.");
				error = true;
				input.nextLine();
			}
		}while (error);
		
		Shirt sh = new Shirt (b, c, col, s, pr);
		
		System.out.println ("\nShirt successfully added.");		
		
		return sh;

	
	}
	
	/**
	 * This method prompts the menu to create
	 * trousers in order to be added to the store.
	 * 
	 * @return the trousers already created
	 */
	
	public static Trousers AddTrousers_Menu (){
		Scanner input = new Scanner(System.in);
		String b = "";
		String col = "";
		int c = 0;
		double pr = 0.0;
		int s = 0;
		boolean error = false;
		
		
		do{
			System.out.println ("\nAdd new trousers menu\n");
		
			System.out.flush();
			
			try{			
				System.out.println ("Enter Brand: ");
				b = input.nextLine();
				System.out.println ("Enter Code (integer): ");
				c = input.nextInt();
				input.nextLine();
				System.out.println ("Enter Colour: ");
				col = input.nextLine();
				System.out.println ("Enter size (integer): ");
				s = input.nextInt();		
				System.out.println ("Enter prize (in Euros): ");
				pr = input.nextDouble();
				error = false;
			
			}
			catch (InputMismatchException e){
				System.out.println ("Incorrect format of input data.");
				error = true;
				input.nextLine();
			}
		}while (error);
		
		Trousers tr = new Trousers (b, c, col, s, pr);
		
		System.out.println ("\nTrousers successfully added.");		
		
		return tr;

	
	}
	
	/**
	 * The method prompts the menu for buying
	 * products from the store.
	 * 
	 * @param products the map with the products available in the store
	 * ordered by code.
	 */
	
	public static void Buy (Map<Integer, Product> products){
		
		Scanner kb = new Scanner (System.in);
		double total = 0;
		int code = -1;
		char resp = 'n';
		int items = 0;
		boolean empty = false;
		boolean error = false;
		
		do{
			if (!products.isEmpty()){
				System.out.println ("\nBuy menu\n");
		
				System.out.flush();
			
				Show_Stock (products);
			
				System.out.println ("\nEnter the product code: ");
				
				try{
					error = false;
				code = kb.nextInt();
			
				if (products.containsKey(code)){
					Product p = products.get(code);
					System.out.println ("You bought " + p);
					products.remove(code);
					p.Buy();
					total = total + p.getPrize();
					items++;
				
					System.out.println ("Your current total is " + total + " Euros and you" +
						" bought " + items + " items.");
				
					kb.nextLine();
					System.out.println ("Do you want to keep on buying? (y/n)");
					resp = kb.nextLine().charAt(0);
				}
				else{
					System.out.println ("The product is not available in the stock.");
				}
				}
				catch (InputMismatchException e){
					System.out.println ("Incorrect format of input data.");
					error = true;
					kb.nextLine();
				}	
			}
			else{
				System.out.println ("No more products in the stock.");
				empty = true;
			}
				
		}while(((resp == 'y') || (resp == 'Y') || error) && !empty);	
	}
	
	/**
	 * This method shows the products available in the store.
	 * 
	 * @param products the map with the products available in the store
	 * ordered by code.
	 */
	
	public static void Show_Stock (Map<Integer, Product> products){
		for (Map.Entry<Integer, Product> ent : products.entrySet()){
			System.out.println ("Code: " + ent.getKey() + " Product: " + ent.getValue());
		}
	}

}
