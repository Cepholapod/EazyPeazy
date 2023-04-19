
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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class MenuRecipeGUI extends Pane {
	//private TextField mealInput = new TextField();
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
	private Label menuLBL = new Label("Menu for the Week");
	private Label timesLBL = new Label("Time");
	private GridPane pane = new GridPane();
	private BorderPane border = new BorderPane();
	private int numMeals;

	public MenuRecipeGUI() {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		border.setCenter(pane);
		border.setTop(menuLBL);
		
		numMeals = 5;
		setNumMeals(numMeals);

		pane.setStyle("-fx-background-color:  #aac4e8;");
		border.setStyle("-fx-background-color:  #aac4e8;");

		Font lblfont = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		entreesLBL.setFont(lblfont);
		sidesLBL.setFont(lblfont);
		dessertsLBL.setFont(lblfont);
		mealsLBL.setFont(lblfont);
		menuLBL.setFont(lblfont);
		timesLBL.setFont(lblfont);
		
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
			col.setPercentWidth(22.5);
			pane.getColumnConstraints().add(col);
		}
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(10);
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

		//pane.setPrefSize(300, 300);
		pane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		Scene scene = new Scene(border, 1000, 400);
		Stage MenuRecipesStage = new Stage();
		MenuRecipesStage.setTitle("All Recipes Available");
		MenuRecipesStage.setScene(scene);
		MenuRecipesStage.show();
	}

	public void setNumMeals(int quantity) {
		// test size
		if (main.entrees.isEmpty() || main.entrees.size() < numMeals) {
			System.out.println("Entrees only has " + main.entrees.size() + " recipes");
		}
		if (main.sides.isEmpty() || main.sides.size() < numMeals)
			System.out.println("Sides only has " + main.sides.size() + " recipes");		System.out.println(main.sides.size());
		if (main.desserts.isEmpty() || main.desserts.size() < numMeals)
			System.out.println("Desserts only has " + main.desserts.size() + " recipes");

		//initialize lists
		List<Recipe> entrees = main.entrees;
		List<Recipe> sides = main.sides;
		List<Recipe> desserts = main.desserts;
		
		// addings elements to the pane
		pane.addRow(0, mealsLBL, entreesLBL, sidesLBL, dessertsLBL, timesLBL);
		for (int i = 0; i <= quantity; i++) {
			numLBL.add(new Label("Meal #" + String.valueOf(i + 1)));
			// meal
			Recipe entree = entrees.remove((int) Math.random() * entrees.size());
			Recipe side = sides.remove((int) Math.random() * sides.size());
			Recipe dessert = desserts.remove((int) Math.random() * desserts.size());
			
			// Meal meal = new Meal(entree, side, dessert);
			// meals.add(meal);
			
			//add entrees to buttons
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
			
			//add action handlers
			entreesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(entree);
			});
			sidesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(side);
			});
			dessertsBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(dessert);
			});
			Label time = new Label("Entree: " + entree.getTime() + "\nSide: " + side.getTime() + "\nDessert: " + dessert.getTime());
			time.setWrapText(true);
			timeLBL.add(time);
			
			pane.addRow(i + 1, numLBL.get(i), entreesBTN.get(i), sidesBTN.get(i),
					dessertsBTN.get(i), timeLBL.get(i));
		}
	}
}