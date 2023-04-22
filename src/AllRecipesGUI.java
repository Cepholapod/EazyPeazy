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
	private Label allRecipesLBL = new Label("All Recipes");
	private GridPane pane = new GridPane();
	private BorderPane border = new BorderPane();
	//private Recipe tempRecipe;
	
	public AllRecipesGUI() {
		Stage AllRecipesStage = new Stage();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		border.setCenter(pane);
		border.setTop(allRecipesLBL);

		//set background color
		pane.setStyle("-fx-background-color:  #aac4e8;");
		border.setStyle("-fx-background-color:  #aac4e8;");
		
		// set fonts
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		entreesLBL.setFont(font);
		sidesLBL.setFont(font);
		dessertsLBL.setFont(font);
		allRecipesLBL.setFont(font);
		
		// set labels to expand with cells
		entreesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		sidesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		dessertsLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		allRecipesLBL.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		// center labels
		entreesLBL.setAlignment(Pos.CENTER);
		sidesLBL.setAlignment(Pos.CENTER);
		dessertsLBL.setAlignment(Pos.CENTER);
		allRecipesLBL.setAlignment(Pos.CENTER);
		
		
		//gets max row size for below
		int maxSize = 0;
		if (main.entrees.size()>main.sides.size() && main.entrees.size()>main.desserts.size())
			maxSize = main.entrees.size();
		else if(main.sides.size()>main.entrees.size() && main.sides.size()>main.desserts.size())
			maxSize = main.sides.size();
		else
			maxSize = main.desserts.size();
		
		// Set row and column constraints to expand with window
		for (int i = 0; i < 3; i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth(33.3);
			pane.getColumnConstraints().add(col);
		}
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(20);
		pane.getRowConstraints().add(row1);
		for (int i = 0; i < maxSize + 1; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100 / (maxSize + 1));
			pane.getRowConstraints().add(row);
		}
		
		
		//Adding entrees
		pane.addColumn(0, entreesLBL);
		for(int i = 0; i<main.entrees.size(); i++) {
			Recipe tempRecipe = main.entrees.get(i);
			entreesBTN.add(new Button(tempRecipe.getTitle()));
			pane.addColumn(0, entreesBTN.get(i));
			entreesBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			entreesBTN.get(i).setMaxWidth(Double.MAX_VALUE);
			entreesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
			});
		}
		//Adding sides
		pane.addColumn(1, sidesLBL);
		for(int i = 0; i<main.sides.size(); i++) {
			Recipe tempRecipe = main.sides.get(i);
			sidesBTN.add(new Button(tempRecipe.getTitle()));
			pane.addColumn(1, sidesBTN.get(i));
			// set to expand with cell
			sidesBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			sidesBTN.get(i).setMaxWidth(Double.MAX_VALUE);
			sidesBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
			});
		}
		//Adding desserts
		pane.addColumn(2, dessertsLBL);
		for(int i = 0; i<main.desserts.size(); i++) {
			Recipe tempRecipe = main.desserts.get(i);
			dessertsBTN.add(new Button(tempRecipe.getTitle()));
			pane.addColumn(2, dessertsBTN.get(i));
			//set to expand with cell
			dessertsBTN.get(i).setMaxHeight(Double.MAX_VALUE);
			dessertsBTN.get(i).setMaxWidth(Double.MAX_VALUE);
			dessertsBTN.get(i).setOnAction(e ->{
				SingleRecipeGUI gui = new SingleRecipeGUI(tempRecipe);
			});
		}
		
		//exit button
		Button exitBTN = new Button("Exit");
		exitBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			AllRecipesStage.close();
		});
		border.setBottom(exitBTN);
		
	
		Scene scene = new Scene(border, 640, 480);
		AllRecipesStage.setTitle("All Recipes Available");
		AllRecipesStage.setScene(scene);
		AllRecipesStage.show();
	}
}