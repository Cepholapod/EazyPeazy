
/*EzeayPeazy Meal
 * DEV @ Seth Glover 
 * DESCRIPTION Methods getCalories(), setCalories(), getSide(), setSide(Recipe Side), 
 * getDesert(), setDesert(Recipe desert) compareTo(Meal other)
 * DATE 15 April
 */
public class Meal implements Comparable <Meal> {
	double calories; 
	Recipe entree;
	Recipe side;
	Recipe dessert;
	double carbs; 
	double protein;
	double fat;
	
	public Meal() {
		this.entree = RecipeSelector.randomEntree();
		this.side = RecipeSelector.randomSide();
		this.dessert = RecipeSelector.randomDessert();
	}
	public Meal (Recipe entree, Recipe side, Recipe dessert) {
		this.entree = entree;
		this.side = side;
		this.dessert = dessert;
		this.calories = entree.getCalories() + side.getCalories() + dessert.getCalories();
	}
	
	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public Recipe getSide() {
		return side;
	}

	public void setSide(Recipe side) {
		this.side = side;
	}

	public Recipe getDessert() {
		return dessert;
	}

	public void setDessert(Recipe dessert) {
		this.dessert = dessert;
	}
	public Recipe getEntree() {
		return entree;
	}

	public void setEntree(Recipe entree) {
		this.entree = entree;
	}
	public double getFat() {
		return side.getFat()+ entree.getFat()+dessert.getFat();
	}
	public double getCarbs() {
		return side.getCarbs()+ entree.getCarbs()+dessert.getCarbs();
	}
	public double getProtein() {
		return side.getProtein()+ entree.getProtein()+dessert.getProtein();
	}

	public int compareTo(Meal other) {
		return Double.compare(this.calories, other.calories);
	}

}
