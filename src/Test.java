import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/* camsona-url testing having a single class pull from other class's scenes
 * 
 */
public class Test extends Application {
	Stage stage1 = new Stage();
	Recipe recipe = new Recipe();
	@Override
	public void start(Stage stage) throws Exception {
		stage1 = stage;

		stage.close();
		
		stage1.setScene(getMainScene());
		
		
		
		stage1.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
	public Scene getMainScene() {
		RecipeMakerGUI rm = new RecipeMakerGUI();
		SingleRecipeGUI mt = new SingleRecipeGUI();
		//SingleRecipeGUI sg = new SingleRecipeGUI();
		
		GridPane gpane = new GridPane();
		Button b1 = new Button("Recipe Maker");
		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			rm.start(stage1);
		});
		Button b2 = new Button("Single Recipe");
		b2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			mt.setRecipe(rm.getRecipe());
			mt.start(stage1);
		});
		gpane.add(b1, 0, 0);
		gpane.add(b2, 1, 0);
		
		Scene scene = new Scene(gpane, 440,440);

		return scene;
	}
	

}
