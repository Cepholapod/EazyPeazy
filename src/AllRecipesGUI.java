//Jessie's GUI
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;
public class AllRecipesGUI extends Application{
	public void start(Stage stage) throws Exception{
		Pane pane = new Pane();
		pane.getChildren().add(new Label("Hello World"));
		Scene scene = new Scene(pane);
		
		stage.setScene(scene);
		stage.setTitle("My first GUI program with JavaFX");
		stage.show();
	}
	public static void main(String[] args) {
		launch();
	}
}
