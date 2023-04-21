import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class numMealsGUI {
	private BorderPane border = new BorderPane();
	private Label mealsLBL = new Label("Enter Number of Meals");
	private TextField mealInputTF = new TextField();
	private int numMeals;

	public numMealsGUI(User user){
		Scene scene = new Scene(border, 200, 200);
		Stage numMealsStage = new Stage();
		
		mealInputTF.setOnKeyTyped(e -> numMeals+=Integer.parseInt(mealInputTF.getText()));
	
		Button exitBTN = new Button("Exit");
		exitBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			numMealsStage.close();
		});
		Button finishBTN = new Button("Show my Meals");
		finishBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
			MenuRecipeGUI gui = new MenuRecipeGUI(user, numMeals);
		});
		
		// setting up border pane
		border.setLeft(exitBTN);
		border.setBottom(finishBTN);
		border.setTop(mealsLBL);
		border.setCenter(mealInputTF);
		
		numMealsStage.setTitle("How many meals?");
		numMealsStage.setScene(scene);
		numMealsStage.show();
	}
}
