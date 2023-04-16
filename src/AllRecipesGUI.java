/**
* AllRecipesGUI.java,
* Jessica Servis
* Shows all of the recipes available
*/
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class AllRecipesGUI extends Pane{
	private List<Button> entreesBTN = new ArrayList<Button>();
	private List<Button> sidesBTN = new ArrayList<Button>();
	private List<Button> dessertsBTN = new ArrayList<Button>();
	private Label entreesLBL = new Label("Entrees");
	private Label sidesLBL = new Label("Sides");
	private Label dessertsLBL = new Label("Desserts");
	private GridPane pane = new GridPane();
	
	public AllRecipesGUI() {
		Stage AllRecipesStage = new Stage();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
	   // pane.setPrefWrapLength(300); // preferred width = 300
		
		//List<Recipe> entrees = main.entrees;
		//List<Recipe> sides = main.sides;
		//List<Recipe> desserts = main.desserts;
		for(Recipe entree : main.entrees)
			entreesBTN.add(new Button(entree.getTitle()));
		for(Recipe side : main.sides)
			sidesBTN.add(new Button(side.getTitle()));
		for(Recipe dessert : main.desserts)
			dessertsBTN.add(new Button(dessert.getTitle()));
	
		pane.getChildren().add(entreesLBL);
	    pane.getChildren().addAll(entreesBTN);
	    
		//init();
		Scene scene = new Scene(pane, 640, 480);
		AllRecipesStage.setTitle("All Recipes Available");
		//pane.setPrefSize(300, 300);
		//pane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		AllRecipesStage.setScene(scene);
		AllRecipesStage.show();
	}
	
	public void init() {
		if(main.entrees == null)
			System.out.println("Entrees is empty");
		System.out.println(main.entrees.size());
		List<Recipe> entrees = main.entrees;
		if(main.sides == null)
			System.out.println("Sides is empty");
		System.out.println(main.sides.size());
		List<Recipe> sides = main.sides;
		if(main.desserts == null)
			System.out.println("Desserts is empty");
		List<Recipe> desserts = main.desserts;
		System.out.println(main.desserts.size());
		for (int i = 1; i<= quantity; i++) {
			numLBL.add(new Label(String.valueOf(i)));
			
			//meal
			Recipe entree = entrees.remove((int)Math.random()*entrees.size()-1);
			Recipe side = sides.remove((int)Math.random()*sides.size()-1);
			Recipe dessert = desserts.remove((int)Math.random()*desserts.size()-1);
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