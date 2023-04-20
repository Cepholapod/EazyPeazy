import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


//camsona - Display a singular recipe fully
/* NOTE: Hashmaps still being consistantly weird, and the scrollbar is not cooperating, ill keep looking into it
 * (Can no longer run by itself, must be ran from main)
*/
class SingleRecipeGUI extends Pane {
	static Recipe test = new Recipe();
	static Label ingredients;
	static Label directions;
	static Label title;

	public SingleRecipeGUI(Recipe recipe) {
		test = recipe;
		
		Stage stage = new Stage();
		//Instantiating labels
		
		ingredients = new Label("Ingredients");

		directions = new Label("Directions");

		title = new Label(test.getTitle());

		//Formatting and setting font
		ingredients.setFont(Font.font(20)); 
		directions.setFont(Font.font(20)); 
		directions.setTextAlignment(TextAlignment.LEFT);
		title.setFont(Font.font(60)); 

		//Creating the main borderpane
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(0, 10, 0, 10));
		
		//Setting the top to the title
		pane.setTop(title);
		
		//Iterating through the recipe to get the ingredients + units into one label
		Iterator<Map.Entry<String, Double>> iter = test.Ingredients.entrySet().iterator();
		List<String> units = test.units;
		int j = 0;
		String temp = "";
		
		while(iter.hasNext()) {
			Map.Entry<String, Double> entry = iter.next();
			if(entry.getValue() % 1 == 0) {
				// Removing a decimal point if it is not used
				String [] t2 = entry.getValue().toString().split(".0");
				temp += "o " + t2[0] + " " + units.get(j) + " " + entry.getKey() + "\n";
			} else {
				temp += "o " + entry.getValue() + " " + units.get(j) + " " + entry.getKey() + "\n";
			}
			
			j++;
		}
		//Setting and formatting the text to the right side
		ingredients.setText(temp);
		ingredients.setTextAlignment(TextAlignment.JUSTIFY);
		ingredients.setLineSpacing(5);
		ingredients.setMinWidth(40);
		
		Button exitb = new Button("Exit");
		exitb.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			stage.close();
		});
		pane.setBottom(exitb);
		pane.setLeft(ingredients);
		
		
		
		//Setting and formatting 
		directions.setMaxWidth(290);
		directions.setWrapText(true);


		// Setting up the scrollbar
		ScrollPane scroll = new ScrollPane(directions);
		

		scroll.setMaxHeight(1000);
		//scroll.setLayoutX(290);
		scroll.setPrefWidth(370);
		scroll.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		scroll.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.ALWAYS);
			
		

		
		pane.setRight(scroll);

//		scroll.setStyle("-fx-background-color:  #aac4e8;");
//		gpane.setStyle("-fx-background-color:  #aac4e8;");
//		pane.setStyle("-fx-background-color:  #aac4e8;");
		

		
		temp = "";
		String temp2 = "";
		for (int i = 0; i < test.Directions.size(); i++) {
			temp2 += (i + 1) + ". " + test.Directions.get(i) + "\n";
			temp += temp2; 
			temp2 = "";
		}

		directions.setText(temp);

		Scene scene = new Scene(pane, 740, 480);

		stage.setScene(scene);
		stage.setTitle("Recipe Viewer");
		stage.show();
	}

}
