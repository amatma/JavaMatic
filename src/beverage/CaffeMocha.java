package beverage;

public class CaffeMocha extends Beverage {
	public CaffeMocha() {
		super();
		setName("Caffe Mocha");
		addIngredient("Espresso", 1);
		addIngredient("Cocoa", 1);
		addIngredient("Steamed Milk", 1);
		addIngredient("Whipped Cream", 1);
	}

}
