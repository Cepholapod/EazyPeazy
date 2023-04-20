import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeSelector {


	public static List<Recipe> entreeSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> entrees = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Entree")) {
				entrees.add(recipe);
			}
		}

		return entrees;
	}

	public static List<Recipe> sideSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> sides = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Side")) {
				sides.add(recipe);
			}
		}
		return sides;
	}

	public static List<Recipe> dessertSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> desserts = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Dessert")) {
				desserts.add(recipe);
			}
		}
		return desserts;
	}

	public static Meal randomSelector(Meal meal) {
		
		if (!main.entrees.isEmpty() && !main.sides.isEmpty() && !main.desserts.isEmpty()) {
			Random rand = new Random();

			Recipe randomEntree = main.entrees.get(rand.nextInt(main.entrees.size()));
			Recipe randomSide = main.sides.get(rand.nextInt(main.sides.size()));
			Recipe randomDessert = main.desserts.get(rand.nextInt(main.desserts.size()));

			meal = new Meal(randomEntree, randomSide, randomDessert);
		}

		return meal;

	}
	
	public static Recipe randomEntree() {
		Random rand = new Random();
		Recipe randomEntree = main.entrees.get(rand.nextInt(main.entrees.size()));
		return randomEntree;
	}
	public static Recipe randomSide() {
		Random rand = new Random();
		Recipe randomSide = main.sides.get(rand.nextInt(main.entrees.size()));
		return randomSide;
	}
	public static Recipe randomDessert() {
		Random rand = new Random();
		Recipe randomDessert = main.desserts.get(rand.nextInt(main.entrees.size()));
		return randomDessert;
	}
	public static void checkUnique(List<Recipe> recipeList) {
		for(int i = 0; i < recipeList.size(); i++) {
			for(int j = i + 1; j < recipeList.size(); j++) {
				if(recipeList.get(i).getTitle().equalsIgnoreCase(recipeList.get(j).getTitle())) {
					recipeList.remove(j);
				}
			}
		}
	}
	
	public static void shutdown() {
		PrintWriter pw = null;

		//Formatting - Up to directions is separated by \t, Directions are separated by &, Ingredients are separatedby & and then by , into their specific values 
		
		File f = new File("Entree.txt");
		try {
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredients	amounts	units");
			for (int i = 0; i < main.entrees.size(); i++) {
				pw.println(main.entrees.get(i));
			}

			pw.close();
			f = new File("Side.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredients	amounts	units");
			for (int i = 0; i < main.sides.size(); i++) {
				pw.println(main.sides.get(i));
			}
			
			pw.close();
			f = new File("Dessert.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredients	amounts	units");
			
			
			for (int i = 0; i < main.desserts.size(); i++) {
				pw.println(main.desserts.get(i));
			}

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
