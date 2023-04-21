import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class numMealsGUI extends Pane {
	private GridPane pane = new GridPane();
	private Label mealsLBL = new Label("Enter Number of Meals");
	private TextField mealInputTF = new TextField();
	private int numMeals;

	public numMealsGUI(User user) {
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 400, 200);
		Stage numMealsStage = new Stage();
		Font LBLfont = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		mealsLBL.setFont(LBLfont);
		pane.setStyle("-fx-background-color:  #aac4e8;");

		Button exitBTN = new Button("Exit");
		exitBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			numMealsStage.close();
		});
		Button finishBTN = new Button("Show my Meals");
		finishBTN.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			numMeals = Integer.parseInt(mealInputTF.getText());
			MenuRecipeGUI gui = new MenuRecipeGUI(user, numMeals);
		});

		// formatting
		mealsLBL.setAlignment(Pos.CENTER);
		exitBTN.setAlignment(Pos.CENTER);
		finishBTN.setAlignment(Pos.CENTER);

		for (int i = 0; i < 4; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(25);
			pane.getRowConstraints().add(row);
		}

		exitBTN.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		finishBTN.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		// setting up pane
		pane.addRow(0, mealsLBL);
		pane.addRow(1, mealInputTF);
		pane.addRow(2, finishBTN);
		pane.addRow(3, exitBTN);

		numMealsStage.setTitle("How many meals?");
		numMealsStage.setScene(scene);
		numMealsStage.show();
	}
}
