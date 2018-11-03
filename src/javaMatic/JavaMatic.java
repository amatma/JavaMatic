package javaMatic;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

import beverage.*;

public class JavaMatic {
	private HashMap<String, Integer> stock= new HashMap();
	private HashMap<String, Double> ingredientPrices= new HashMap();
	private ArrayList<String> ingredientList= new ArrayList<>();
	private ArrayList<Beverage> menu= new ArrayList();
	
	public JavaMatic() { 
		this.reStock();
		this.setPrices();
		this.setIngredientList();
		this.setMenu();
	}
	
	public int getStock(String ingredient) {
		return this.stock.get(ingredient);
	}
	
	private void setIngredientList() {
		this.ingredientList.add("Cocoa");
		this.ingredientList.add("Coffee");
		this.ingredientList.add("Decaf Coffee");
		this.ingredientList.add("Espresso");
		this.ingredientList.add("Foamed Milk");
		this.ingredientList.add("Steamed Milk");
		this.ingredientList.add("Sugar");
		this.ingredientList.add("Whipped Cream");
	}


	private void setMenu() {
		Beverage caffeAmericano= new CaffeAmericano();
		this.menu.add(caffeAmericano);
		Beverage caffeLatte= new CaffeLatte();
		this.menu.add(caffeLatte);
		Beverage caffeMocha= new CaffeMocha();
		this.menu.add(caffeMocha);
		Beverage cappuccino= new Cappuccino();
		this.menu.add(cappuccino);
		Beverage coffee= new Coffee();
		this.menu.add(coffee);
		Beverage decafCoffee= new DecafCoffee();
		this.menu.add(decafCoffee);
	}

	public ArrayList<Beverage> getMenu() {
		return this.menu;
	}
	
	private void setPrices() {
		this.ingredientPrices.put("Coffee", 0.75);
		this.ingredientPrices.put("Decaf Coffee", 0.75);
		this.ingredientPrices.put("Sugar", 0.25);
		this.ingredientPrices.put("Cream", 0.25);
		this.ingredientPrices.put("Steamed Milk", 0.35);
		this.ingredientPrices.put("Foamed Milk", 0.35);
		this.ingredientPrices.put("Espresso", 1.1);
		this.ingredientPrices.put("Cocoa", 0.90);
		this.ingredientPrices.put("Whipped Cream", 1.00);
	}

	public void reStock() {
		this.stock.put("Cocoa", 10);
		this.stock.put("Coffee", 10);
		this.stock.put("Cream", 10);
		this.stock.put("Decaf Coffee", 10);
		this.stock.put("Espresso", 10);
		this.stock.put("Foamed Milk", 10);
		this.stock.put("Steamed Milk", 10);
		this.stock.put("Sugar", 10);
		this.stock.put("Whipped Cream", 10);
	}
	
	public void orderDrink(Beverage b) {
		if (available(b)) {
			for (String ingredient: b.ingredients.keySet()) {
				this.stock.put(ingredient, this.stock.get(ingredient)-b.ingredients.get(ingredient));
			}
			System.out.println("Dispensing: "+b.getName());
		} else {
			System.out.println("Out of stock: "+b.getName());
		}
	}
	
	
	public boolean available(Beverage b) {
		for (String ingredient: b.ingredients.keySet()) {
			if (this.stock.get(ingredient)<=b.ingredients.get(ingredient)) {
				return false;
			}
		}
		return true;
	}
	
	public double getPrice(Beverage b) {
		double price=0.0;
		for (String ingredient: b.ingredients.keySet()) {
			double add= this.ingredientPrices.get(ingredient)*b.ingredients.get(ingredient);
			price+= add;
		}
		return price;
	}
	
	public void printMenu() {
		System.out.println("Menu:");
		for (int i=0; i<this.menu.size(); i++) {
			Beverage b= this.menu.get(i);
			NumberFormat formatter= NumberFormat.getCurrencyInstance();
			System.out.println(i+1+","+b.getName()+","+formatter.format(getPrice(b))+","+available(b));
		}
	}
	
	public void printInventory() {
		System.out.println("Inventory:");
		for (String key: this.ingredientList) {
			System.out.println(key+","+this.stock.get(key));
		}
	}

	
	
}
