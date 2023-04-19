import java.io.File;
import java.util.Scanner;

/** camsona-url - console recipe creator
* 
*/
public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		main.entrees = RecipeSelector.entreeSelector(new File("Entree.txt"));
		main.sides = RecipeSelector.sideSelector(new File("Side.txt"));
		main.desserts = RecipeSelector.dessertSelector(new File("Dessert.txt"));
		
		
		
		String input = "Y";
		
		while(input.equalsIgnoreCase("Y")) {
			System.out.println("Entree #: " + main.entrees.size() + " Side #: " + main.sides.size() + " Dessert #: " + main.desserts.size());
			
			Recipe.createRecipe();
			System.out.print("Would you like to make another? Y / N : ");
			input = sc.next();
		}
		
		RecipeSelector.shutdown();
		sc.close();
	}

}
