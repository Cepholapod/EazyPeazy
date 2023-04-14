import java.io.File;
import java.util.*;



//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author sethm I am going to try something out over the weekend so if you are
 *         reading this then know that if this doesn't work out. we will go back
 *         to the og plan
 */
public class Recipe {

	private String title;
	private String type;
	private List<String> Tags = new ArrayList<String>();
	private String prepTime;
	private String cookTime;
	double servings;
	double calories;
	double fat;
	double carbs;
	double protein;
	Map<String, Double> Ingredients = new HashMap<String, Double>();
	List<String> units = new ArrayList<String>();

	List<String> Directions = new ArrayList<String>();

	public Recipe() {
		this.title = "Unknown";
		this.Tags = null;
		this.prepTime = " ";
		this.cookTime = " ";
		this.servings = 0.0;
		this.Ingredients = null;
		this.calories = 0.0;
		this.fat = 0.0;
		this.carbs = 0.0;
		this.protein = 0.0;
		this.Directions = null;
		this.units = null;
	}

	public Recipe(String title, String type, List<String> Tags, String prepTime, String cookTime, double servings,
			Map<String, Double> Ingredients, List<String> units, double calories, double fat, double carbs,
			double protein, List<String> Directions) {
		this.title = title;
		this.type = type;
		this.Tags = Tags;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.servings = servings;
		this.Ingredients = Ingredients;
		this.units = units;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
		this.Directions = Directions;

	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIngredients(Map<String, Double> map) {
		this.Ingredients = map;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}

	public void setDirections(List<String> directions) {
		this.Directions = directions;
	}

	public void setTags(List<String> tag) {
		this.Tags = tag;
	}

	public void setServing(double serving) {
		this.servings = serving;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}
	
	public double getCalories() {
		return calories;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}
	//I (jessie) added this method
	public List<String> getTags(){
		return Tags;
	}

	//Printing fomatted and to show a user
		public String print() {
			// I am very much not a fan of having multiple loops and instantiations in a print statement but this is
			// just making this work
			// Something has to hold the data of the "none" sections, whether its a counter
			// or a list
			List<String> tempTagList = new ArrayList<String>();
			for (int i = 0; i < Tags.size(); i++) {
				if (!Tags.get(i).equalsIgnoreCase("none")) {
					tempTagList.add(Tags.get(i));
			}
		}

		
		
		return String.format("%s\nPrep Time: %-5sCook Time: %-5s \nServings: %-5s\nCalories: %.1f"
				+ "\nFat: %.1f\nCarbs: %.1f\nProtein: %.1f\nTags: %s\nDirections:\n%s\nIngredients: %s\nUnits: %s",
				this.title, this.prepTime, this.cookTime, this.servings, this.calories, this.fat, this.carbs,
				this.protein, tempTagList, this.Directions, this.Ingredients, this.units);
	}

	//Printing to file - camsona_url
	public String toString() {
		// Having two loops in a toString method is a necessary evil unless we want to have a
		// string in here dedicated to holding the big directions string and big Ingredients string
		String temp = "";
		int j = 0;
		// Iterate through map, int j holds an index so units can also be iterated through
		Iterator <Map.Entry<String,Double>> iter = Ingredients.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String,Double> entry = iter.next();
			temp += entry.getKey() + "," + entry.getValue() + "," + units.get(j);
			// Check to see if the ingredient is the last one, if so then an & is not needed
			if(j == Ingredients.size() - 1) {	
				break;
			} else {
				temp += "&";
			}
			
			j++;
		}

		String temp2 = "";
		// Iterates up to right before the last direction
		for (int i = 0; i < Directions.size() - 1; i++) {
			temp2 += Directions.get(i) + "&";
		}
		// Adds the last direction
		temp2 += Directions.get(Directions.size() - 1);
		
		return this.title + "\t" + this.type + "\t" + this.prepTime + "\t" + this.cookTime + "\t" + this.servings + "\t"
				+ this.calories + "\t" + this.fat + "\t" + this.carbs + "\t" + this.protein + "\t" + this.Tags.get(0)
				+ "\t" + this.Tags.get(1) + "\t" + this.Tags.get(2) + "\t" + this.Tags.get(3) + "\t" + this.Tags.get(4)
				+ "\t" + this.Tags.get(5) + "\t" + this.Tags.get(6) + "\t" + this.Tags.get(7) + "\t" + this.Tags.get(8)
				+ "\t" + this.Tags.get(9) + "\t" + this.Tags.get(10) + "\t" + temp2 + "\t" + temp;
	}


}
//asdf