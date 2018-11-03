package beverage;

public class CaffeLatte extends Beverage {
	public CaffeLatte() {
		super();
		setName("Caffe Latte");
		addIngredient("Espresso", 2);
		addIngredient("Steamed Milk", 1);
	}
}

