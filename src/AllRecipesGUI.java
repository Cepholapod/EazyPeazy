/**
* AllRecipesGUI.java,
* Jessica Servis
* Shows all of the recipes available
*/
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;
public class AllRecipesGUI extends Pane{
	public AllRecipesGUI(){
		Pane pane = new Pane();
		Scene scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.setTitle("All Available Recipes");
		stage.show();
	}
	public static void main(String[] args) {
		launch();
	}
}
