import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 * 
 * @author sethm DESCRIPTION: takes information from recipe.txt and returns
 *         recipe object
 */
public class RecipeParser {

    public static List<Recipe> recipeReader(File f) {

        List<Recipe> recipeList = new ArrayList<>();
        try (Scanner in = new Scanner(new FileReader(f))) {

            String currentLine = in.nextLine();
            // String[] headers = currentLine.split("\t");

            // takes info from .txt file and sets them to the appropriate variables
            while (in.hasNext()) {
                Recipe recipe = new Recipe();
                
                List<String> tags = new ArrayList<String>();
                Map<String, Double> ingredients = new HashMap<String, Double>();
                List<String> units = new ArrayList<String>();
                List<String> directions = new ArrayList<String>();
                String[] values = in.nextLine().split("\t");

                String title = values[0];
                String type = values[1];
                String prepTime = values[2];
                String cookTime = values[3];
                double servings = Double.parseDouble(values[4]);
                double calories = Double.parseDouble(values[5]);
                double fat = Double.parseDouble(values[6]);
                double carbs = Double.parseDouble(values[7]);
                double protein = Double.parseDouble(values[8]);

                recipe.setTitle(title);
                recipe.setType(type);
                recipe.setPrepTime(prepTime);
                recipe.setCookTime(cookTime);
                recipe.setServing(servings);
                recipe.setCalories(calories);
                recipe.setFat(fat);
                recipe.setCarbs(carbs);
                recipe.setProtein(protein);

                for (int i = 9; i < 20; i++) {
                    tags.add(values[i]);

                }
                recipe.setTags(tags);

                //Splitting of the directions string and adding to list
                String[] values2 = values[20].split("&");

                // Trimming whitespace
				for (int i = 0; i < values2.length; i++) {
					if(values2[i].charAt(values2[i].length() - 1) == ' ') {
						values2[i] = values2[i].trim();
					}
					directions.add(values2[i]);
				}

                recipe.setDirections(directions);

                // Array that holds each ingredient in their own string
                String [] values3 = values[21].split("&");
                
                
                // Splitting that string into the separate values
                for(int i = 0; i < values3.length; i++) {
                    String [] values4 = values3[i].split(",");
                    ingredients.put(values4[0], Double.parseDouble(values4[1]));
                    units.add(values4[2]);
                }
                
                recipe.setIngredients(ingredients);
                recipe.setUnits(units);
                recipeList.add(recipe);
            }

            in.close();

        } catch (ArrayIndexOutOfBoundsException e) {

            System.err.println("Array index out of bounds: " + e);

            e.printStackTrace();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (NumberFormatException e) {

            e.printStackTrace();

        }
        return recipeList;
    }

}
//
