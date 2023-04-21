
/**
* MenuRecipeGUI.java,
* Jessica Servis
* Shows the recipes in the week's meal plan
* void newNum(num: int)
* meals list
*/

import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class MenuRecipeGUI extends Pane {
	// private TextField mealInputTF = new TextField();
	private List<Meal> meals = new ArrayList<Meal>();
	private List<Label> numLBL = new ArrayList<Label>();
	private List<Label> timeLBL = new ArrayList<Label>();
	private List<Button> entreesBTN = new ArrayList<Button>();
	private List<Button> sidesBTN = new ArrayList<Button>();
	private List<Button> dessertsBTN = new ArrayList<Button>();
	private Label entreesLBL = new Label("Entrees");
	private Label sidesLBL = new Label("Sides");
	private Label dessertsLBL = new Label("Desserts");
	private Label mealsLBL = new Label("Meals");
	private Label menuLBL = new Label("Menu for the Week");
	private Label timesLBL = new Label("Time");
	private GridPane pane = new GridPane();
	private BorderPane border = new BorderPane();
	private int numMeals;
	// private int number;

	public MenuRecipeGUI(User user, int numOfMeals) {
		numMeals = numOfMeals;
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		border.setCenter(pane);

		Scene scene = new Scene(border, 1000, 500);
		Stage MenuRecipesStage = new Stage();

		setNumMeals(numMeals);

		// add meals
		if (user.getMeals() != null)
			user.clearMeals();
		user.addMeals(meals);

		// set background
		pane.setStyle("-fx-background-color:  #aac4e8;");
		border.setStyle("-fx-background-color:  #aac4e8;");

		// set fonts
		Font LBLfont = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		entreesLBL.setFont(LBLfont);
		sidesLBL.setFont(LBLfont);
		dessertsLBL.setFont(LBLfont);
		menuLBL.setFont(LBLfont);
		timesLBL.setFont(LBLfont);
		mealsLBL.setFont(LBLfont);

		// set labels to expand with cells
		entreesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		sidesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		dessertsLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		mealsLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		timesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// center labels
		entreesLBL.setAlignment(Pos.CENTER);
		sidesLBL.setAlignment(Pos.CENTER);
		dessertsLBL.setAlignment(Pos.CENTER);
		mealsLBL.setAlignment(Pos.CENTER);
		menuLBL.setAlignment(Pos.CENTER);
		timesLBL.setAlignment(Pos.CENTER);

		// Set row and column constraints to expand with window
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(10);
		pane.getColumnConstraints().add(col1);
		for (int i = 1; i < 5; i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth((100 - 10) / 4);
			pane.getColumnConstraints().add(col);
		}
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(10);
		pane.getRowConstraints().add(row1);
		for (int i = 0; i < numMeals + 1; i++) {
			RowConstraints row = new RowConstraints();
			// row.setPercentHeight(100 / (numMeals + 1));
			pane.getRowConstraints().add(row);
		}

		// exit button
		Button exitBTN = new Button("Exit");
		exitBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			MenuRecipesStage.close();
		});

		// setting up border pane
		border.setBottom(exitBTN);
		border.setTop(menuLBL);

		MenuRecipesStage.setTitle("All Recipes Available");
		MenuRecipesStage.setScene(scene);
		MenuRecipesStage.show();
	}

	public void setNumMeals(int quantity) {
		// pane.getChildren().clear();
		// test size
		if (quantity < 0)
			throw new IllegalArgumentException("Number of meals connot be 0 ");
		if (main.entrees.isEmpty() || main.entrees.size() < numMeals)
			System.out.println("Entrees only has " + main.entrees.size() + " recipes");
		if (main.sides.isEmpty() || main.sides.size() < numMeals)
			System.out.println("Sides only has " + main.sides.size() + " recipes");
		System.out.println(main.sides.size());
		if (main.desserts.isEmpty() || main.desserts.size() < numMeals)
			System.out.println("Desserts only has " + main.desserts.size() + " recipes");

		// initialize lists
		List<Recipe> entrees = new ArrayList<Recipe>();
		List<Recipe> sides = new ArrayList<Recipe>();
		List<Recipe> desserts = new ArrayList<Recipe>();
		entrees.addAll(main.entrees);
		sides.addAll(main.sides);
		desserts.addAll(main.desserts);

		if (entreesBTN != null)
			entreesBTN.clear();
		if (sidesBTN != null)
			sidesBTN.clear();
		if (dessertsBTN != null)
			dessertsBTN.clear();

		// addings elements to the pane
		pane.addRow(0, mealsLBL, entreesLBL, sidesLBL, dessertsLBL, timesLBL);

		// add all butttons
		for (int i = 0; i < quantity; i++) {
			numLBL.add(new Label("Meal #" + String.valueOf(i + 1)));

			// meal
			Recipe entree = entrees.remove((int) (Math.random() * entrees.size()));
			//NutritionGUI.addEntree(entree);
			Recipe side = sides.remove((int) (Math.random() * sides.size()));
			//NutritionGUI.addSide(side);
			Recipe dessert = desserts.remove((int) (Math.random() * desserts.size()));
			//NutritionGUI.addDessert(entree);
			Meal meal = new Meal(entree, side, dessert);
			meals.add(meal);

			// add entrees to buttons
			entreesBTN.add(new Button(entree.getTitle()));
			sidesBTN.add(new Button(side.getTitle()));
			dessertsBTN.add(new Button(dessert.getTitle()));

			// set buttons to expand with rows/columns
			entreesBTN.get(i).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			sidesBTN.get(i).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			dessertsBTN.get(i).setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

			// set buttons to wrap text
			entreesBTN.get(i).setWrapText(true);
			sidesBTN.get(i).setWrapText(true);
			dessertsBTN.get(i).setWrapText(true);

			// set buttons to center if wrapped
			entreesBTN.get(i).setTextAlignment(TextAlignment.CENTER);
			sidesBTN.get(i).setTextAlignment(TextAlignment.CENTER);
			dessertsBTN.get(i).setTextAlignment(TextAlignment.CENTER);

			// add action handlers
			entreesBTN.get(i).setOnAction(e -> {
				SingleRecipeGUI gui = new SingleRecipeGUI(entree);
			});
			sidesBTN.get(i).setOnAction(e -> {
				SingleRecipeGUI gui = new SingleRecipeGUI(side);
			});
			dessertsBTN.get(i).setOnAction(e -> {
				SingleRecipeGUI gui = new SingleRecipeGUI(dessert);
			});
			Label time = new Label(
					"Entree: " + entree.getTime() + "\nSide: " + side.getTime() + "\nDessert: " + dessert.getTime());
			time.setWrapText(true);
			timeLBL.add(time);

			pane.addRow(i + 1, numLBL.get(i), entreesBTN.get(i), sidesBTN.get(i), dessertsBTN.get(i), timeLBL.get(i));
		}

	}
}