package beverage;

public class DecafCoffee extends Beverage {


	public DecafCoffee() {
		super();
		setName("Decaf Coffee");
		
		addIngredient("Decaf Coffee", 3);
		addIngredient("Sugar", 1);
		addIngredient("Cream", 1);
	}
}
