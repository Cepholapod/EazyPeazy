import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserGUI extends Pane{
	
	public UserGUI () {
		
		
		final Stage userWindow = new Stage();
		Button backButton = new Button("Back"), nutritionButton = new Button("Nutrition");
		
		getChildren().add(backButton);
		getChildren().add(nutritionButton);
		backButton.setOnAction(e -> {
			//should take us back to startGUI
		});
		nutritionButton.setOnAction(e -> {
			Scene scene2  = new Scene(new NutritionGUI(), 500,500);
			userWindow.setScene(scene2);
			userWindow.setTitle("Nutrition");
			userWindow.show();
		});
		setStyle("-fx-background-color: whitesmoke");
		
	}
	
	
}
