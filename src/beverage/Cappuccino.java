package beverage;

public class Cappuccino extends Beverage{
	public Cappuccino() {
		super();
		setName("Cappuccino");
		addIngredient("Espresso", 2);
		addIngredient("Steamed Milk", 1);
		addIngredient("Foamed Milk", 1);
	}
}
