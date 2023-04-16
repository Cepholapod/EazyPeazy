import java.io.File;
import java.util.*;
//Jessie's class
public class DietDecorator extends RecipeSelector {
    public static List<Recipe> recipes = new ArrayList<>();
    public static List<Recipe> dietRecipes = new ArrayList<>();
    public static List<String> tags = new ArrayList<>();

    //if the tag is in the recipe, then it adds it to the new list!
    private List<Recipe> flagFinder(String tagflag) {
        for (int i = 0; i < recipes.size(); i++) {
            tags = recipes.get(i).getTags();
            for (String tag : tags) {
                if (tag.equalsIgnoreCase(tagflag))
                    dietRecipes.add(recipes.get(i));
                break;
            }
        }
        return dietRecipes;
    }

    public static List<Recipe> entreeSelector(File f, String tagflag) {
        recipes = RecipeSelector.entreeSelector(f);
        return flagFinder(tagflag);
    }

    public static List<Recipe> sideSelector(File f, String tagflag) {
        recipes = RecipeSelector.sideSelector(f);
        return flagFinder(tagflag);

    }

    public static List<Recipe> dessertSelector(File f, String tagflag) {
        recipes = RecipeSelector.dessertSelector(f);
        return flagFinder(tagflag);
    }
}