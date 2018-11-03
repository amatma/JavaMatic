package beverage;
import java.util.HashMap;

public abstract class Beverage {
	private String name;
	public HashMap<String, Integer> ingredients= new HashMap<>();
	
	
	public void addIngredient(String ingredientName, int count) {
		this.ingredients.put(ingredientName, count);
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
