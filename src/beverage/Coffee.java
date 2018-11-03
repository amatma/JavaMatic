package beverage;

public class Coffee extends Beverage {

	public Coffee() {
		super();
		setName("Coffee");
		addIngredient("Coffee", 3);
		addIngredient("Sugar", 1);
		addIngredient("Cream", 1);
	}

}
