import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeSelector {

	// Exceptions are already taken care of in the Recipe Parser
	static List<Recipe> entrees = entreeSelector(new File("Entree.txt"));
	static List<Recipe> sides = sideSelector(new File("Side.txt"));
	static List<Recipe> desserts = dessertSelector(new File("Dessert.txt"));

// One big setup method called once vs 3 smaller methods all called once in file

//	public static void setup(File entrees, File sides, File desserts) {
//		File[] fileArr = { entrees, sides, desserts };
//		for (int i = 1; i < 3; i++) {
//			List<Recipe> recipes = RecipeParser.recipeReader(fileArr[i]);
//
//			for (Recipe recipe : recipes) {
//				if (recipe.getType().equals("entree")) {
//					RecipeSelector.entrees.add(recipe);
//				} else if (recipe.getType().equals("side")) {
//					RecipeSelector.sides.add(recipe);
//				} else if (recipe.getType().equals("dessert")) {
//					RecipeSelector.desserts.add(recipe);
//				}
//			}
//
//		}
//	}

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

	public Meal randomSelector() {
		Meal meal = null;
		if (!entrees.isEmpty() && !sides.isEmpty() && !desserts.isEmpty()) {
			Random rand = new Random();

			Recipe randomEntree = entrees.get(rand.nextInt(entrees.size()));
			Recipe randomSide = sides.get(rand.nextInt(sides.size()));
			Recipe randomDessert = desserts.get(rand.nextInt(desserts.size()));

			meal = new Meal(randomEntree, randomSide, randomDessert);
		}

		return meal;

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
			for (int i = 0; i < RecipeSelector.entrees.size(); i++) {
				pw.println(RecipeSelector.entrees.get(i));
			}

			pw.close();
			f = new File("Side.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredients	amounts	units");
			for (int i = 0; i < RecipeSelector.sides.size(); i++) {
				pw.println(RecipeSelector.sides.get(i));
			}
			
			pw.close();
			f = new File("Dessert.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredients	amounts	units");
			
			
			for (int i = 0; i < RecipeSelector.desserts.size(); i++) {
				pw.println(RecipeSelector.desserts.get(i));
			}

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
