import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserGUI extends TilePane{
	
	public UserGUI () {
		
		final Stage userWindow = new Stage();
		Button backButton = new Button("Back"), nutritionButton = new Button("Nutrition");
		
		Button recipeMakerButton = new Button("New Recipe"), displayButton = new Button("Display Recipe");
		
		
		getChildren().add(backButton);
		getChildren().add(nutritionButton);
		getChildren().add(recipeMakerButton);
		getChildren().add(displayButton);
		backButton.setOnAction(e -> {
			//should take us back to startGUI
		});
		nutritionButton.setOnAction(e -> {
			Scene scene2  = new Scene(new NutritionGUI(), 500,500);
			userWindow.setScene(scene2);
			userWindow.setTitle("Nutrition");
			userWindow.show();
		});
		
		recipeMakerButton.setOnAction(e -> {
			Scene scene3 = new Scene(new RecipeMakerGUI(), 500,500);
			userWindow.setScene(scene3);
			userWindow.setTitle("Recipe Maker");
			userWindow.show();
		});
		
		displayButton.setOnAction(e -> {
			Scene scene4 = new Scene(new SingleRecipeGUI(), 640, 640);
			userWindow.setScene(scene4);
			userWindow.setTitle("Recipe Viewer");
			userWindow.show();
		});
		
		setStyle("-fx-background-color: whitesmoke");
		
	}
	
	
}
