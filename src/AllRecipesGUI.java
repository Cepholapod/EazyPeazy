/**
* AllRecipesGUI.java,
* Jessica Servis
* Shows all of the recipes available
*/
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.*;
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
	private Recipe tempRecipe;
	
	public AllRecipesGUI() {
		Stage AllRecipesStage = new Stage();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color:  #aac4e8;");

		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		entreesLBL.setFont(font);
		sidesLBL.setFont(font);
		dessertsLBL.setFont(font);
		
		//Adding entrees
		pane.addRow(0, entreesLBL);
		for(int i = 0; i<main.entrees.size(); i++) {
			tempRecipe = main.entrees.get(i);
			entreesBTN.add(new Button(tempRecipe.getTitle()));
			pane.addRow(1, entreesBTN.get(i));
			entreesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
				//gui.setRecipe(tempRecipe);
			});
		}
		//Adding sides
		pane.addRow(3, sidesLBL);
		for(int i = 0; i<main.sides.size(); i++) {
			tempRecipe = main.sides.get(i);
			sidesBTN.add(new Button(tempRecipe.getTitle()));
			pane.addRow(4, sidesBTN.get(i));
			sidesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
				//gui.setRecipe(tempRecipe);
			});
		}
		//Adding desserts
		pane.addRow(6, dessertsLBL);
		for(int i = 0; i<main.desserts.size(); i++) {
			tempRecipe = main.desserts.get(i);
			dessertsBTN.add(new Button(tempRecipe.getTitle()));
			pane.addRow(7, dessertsBTN.get(i));
			dessertsBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
				//gui.setRecipe(tempRecipe);
			});
		}
		
		//exit button
		Button exitBTN = new Button("Exit");
		exitBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			AllRecipesStage.close();
		});
		pane.addRow(9, exitBTN);
		
	
		Scene scene = new Scene(pane, 640, 480);
		AllRecipesStage.setTitle("All Recipes Available");
		//pane.setPrefSize(300, 300);
		//pane.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		AllRecipesStage.setScene(scene);
		AllRecipesStage.show();
	}
}