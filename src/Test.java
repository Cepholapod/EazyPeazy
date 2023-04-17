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
		
		GridPane gpane = new GridPane();
		
		Button b1 = new Button("Recipe Maker");
		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Scene scene1 = new Scene(new RecipeMakerGUI(), 400,400);
			stage1.setScene(scene1);
		});
//		Button b2 = new Button("Single Recipe");
//		b2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
//			Scene scene1 = new Scene(new SingleRecipeGUI(), 400,400);
//			stage1.setScene(scene1);
//		});
		gpane.add(b1, 0, 0);
//		gpane.add(b2, 1, 0);
		
		Scene scene = new Scene(gpane, 440,440);

		stage1.setScene(scene);
		
		
		stage1.show();
	}

	public static void main(String[] args) {
		launch();
	}

	

}
