
/*EzeayPeazy Meal
 * DEV @ Seth Glover 
 * DESCRIPTION This might not be needed but I am leaving this here for now. 
 * DATE
 */
public class Meal implements Comparable <Meal> {
	double calories; 
	Recipe entree;
	Recipe side;
	Recipe dessert;
	
	
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

	public void setEntree(Recipe entree) {
		this.entree = entree;
	}

	public int compareTo(Meal other) {
		return Double.compare(this.calories, other.calories);
	}

}
