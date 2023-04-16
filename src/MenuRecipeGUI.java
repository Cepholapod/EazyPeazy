/**
* MenuRecipeGUI.java,
* Jessica Servis
* Shows the recipes in the week's meal plan
*/

import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;

public class MenuRecipeGUI extends Pane{
	private TextField mealInput = new TextField();
	//private List<Meal> meals = new ArrayList<Meal>();
	private List<Label> numLBL = new ArrayList<Label>();
	private List<Label> timeLBL = new ArrayList<Label>();
	private List<Button> entreesBTN = new ArrayList<Button>();
	private List<Button> sidesBTN = new ArrayList<Button>();
	private List<Button> dessertsBTN = new ArrayList<Button>();
	private GridPane pane = new GridPane();
	
	public MenuRecipeGUI() {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		setNumMeals(14);
		
		pane.setPrefSize(300, 300);
		pane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
	}
	
	public void setNumMeals(int quantity) {
		List<Recipe> entrees = main.entrees;
		List<Recipe> sides = main.sides;
		List<Recipe> desserts = main.desserts;
		for (int i = 1; i<= quantity; i++) {
			numLBL.add(new Label(String.valueOf(i)));
			
			//meal
			Recipe entree = entrees.remove((int)Math.random()*entrees.size());
			Recipe side = sides.remove((int)Math.random()*sides.size());
			Recipe dessert = desserts.remove((int)Math.random()*desserts.size());
			//Meal meal = new Meal(entree, side, dessert);
			//meals.add(meal);
			entreesBTN.add(new Button(entree.getTitle()));
			sidesBTN.add(new Button(side.getTitle()));
			dessertsBTN.add(new Button(dessert.getTitle()));
			timeLBL.add(new Label("Entree: " + entree.getTime() + ", Side: " + side.getTime() + ", Dessert: " + dessert.getTime()));
			int index = i-1;
			pane.addRow(index, numLBL.get(index), entreesBTN.get(index), sidesBTN.get(index), dessertsBTN.get(index), timeLBL.get(index));
		}
	}
}