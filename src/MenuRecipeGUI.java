
/**
* MenuRecipeGUI.java,
* Jessica Servis
* Shows the recipes in the week's meal plan
*/

import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class MenuRecipeGUI extends Pane {
	private TextField mealInput = new TextField();
	// private List<Meal> meals = new ArrayList<Meal>();
	private List<Label> numLBL = new ArrayList<Label>();
	private List<Label> timeLBL = new ArrayList<Label>();
	private List<Button> entreesBTN = new ArrayList<Button>();
	private List<Button> sidesBTN = new ArrayList<Button>();
	private List<Button> dessertsBTN = new ArrayList<Button>();
	private Label entreesLBL = new Label("Entrees");
	private Label sidesLBL = new Label("Sides");
	private Label dessertsLBL = new Label("Desserts");
	private Label mealsLBL = new Label("Meals");
	private GridPane pane = new GridPane();
	private int numMeals;

	public MenuRecipeGUI() {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		numMeals = 5;
		setNumMeals(numMeals);

		pane.setStyle("-fx-background-color:  #aac4e8;");
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		entreesLBL.setFont(font);
		sidesLBL.setFont(font);
		dessertsLBL.setFont(font);
		mealsLBL.setFont(font);

		// Set row and column constraints to expand with window
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(10);
		pane.getColumnConstraints().add(col1);
		for (int i = 1; i < 5; i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(22.5);
			pane.getColumnConstraints().add(col);
		}
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(0);
		pane.getRowConstraints().add(row1);
		/*
		 * RowConstraints row2 = new RowConstraints(); row2.setPercentHeight(30);
		 * pane.getRowConstraints().add(row2);
		 */
		for (int i = 0; i < numMeals + 1; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100 / (numMeals + 1));
			pane.getRowConstraints().add(row);
		}

		pane.setPrefSize(300, 300);
		pane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		Scene scene = new Scene(pane, 1000, 480);
		Stage MenuRecipesStage = new Stage();
		MenuRecipesStage.setTitle("All Recipes Available");
		MenuRecipesStage.setScene(scene);
		MenuRecipesStage.show();
	}

	public void setNumMeals(int quantity) {
		// test size
		if (main.entrees.isEmpty() || main.entrees.size() < numMeals) {
			System.out.printf("Entrees only has %d recipes", main.entrees.size());
		}
		List<Recipe> entrees = main.entrees;
		if (main.sides.isEmpty() || main.sides.size() < numMeals)
			System.out.println("Sides is empty");
		System.out.println(main.sides.size());
		List<Recipe> sides = main.sides;
		if (main.desserts.isEmpty() || main.desserts.size() < numMeals)
			System.out.println("Desserts is empty");
		List<Recipe> desserts = main.desserts;
		System.out.println(main.desserts.size());

		// addings elements to the pane
		pane.addRow(0, mealsLBL, entreesLBL, sidesLBL, dessertsLBL);
		for (int i = 0; i <= quantity; i++) {
			numLBL.add(new Label("Meal #" + String.valueOf(i + 1)));
			// meal
			Recipe entree = entrees.remove((int) Math.random() * entrees.size());
			Recipe side = sides.remove((int) Math.random() * sides.size());
			Recipe dessert = desserts.remove((int) Math.random() * desserts.size());
			// Meal meal = new Meal(entree, side, dessert);
			// meals.add(meal);
			entreesBTN.add(new Button(entree.getTitle()));

			sidesBTN.add(new Button(side.getTitle()));
			dessertsBTN.add(new Button(dessert.getTitle()));
			// set buttons to expand with rows/columns
			entreesBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			entreesBTN.get(i).setMaxWidth(Double.MAX_VALUE);
			sidesBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			sidesBTN.get(i).setMaxWidth(Double.MAX_VALUE);
			dessertsBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			dessertsBTN.get(i).setMaxWidth(Double.MAX_VALUE);

			timeLBL.add(new Label(
					"Entree: " + entree.getTime() + ", Side: " + side.getTime() + ", Dessert: " + dessert.getTime()));
			int index = i;
			pane.addRow(index + 1, numLBL.get(index), entreesBTN.get(index), sidesBTN.get(index),
					dessertsBTN.get(index), timeLBL.get(index));
		}
	}
}