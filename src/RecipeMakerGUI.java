import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

// camsona - Recipe Maker GUI - Lets the user know when an invalid input has been put in, wont add them if invalid.
//								Investigating why the hashmaps being weird again
public class RecipeMakerGUI extends Pane {
	// Lists that hold the labels, text fields, and side labels respectively
	static ArrayList<Label> labArr = new ArrayList<>();
	static ArrayList<TextField> textArr = new ArrayList<>();
	static ArrayList<Label> isCorrect = new ArrayList<>();

	// Title
	static Label topTitle = new Label("Recipe Creator");

	// Recipe variables
	static String title = "";
	static String type = "";
	static List<String> Tags = new ArrayList<String>();
	static String prepTime = "";
	static String cookTime = "";
	static double servings = 0;
	static double calories = 0;
	static double fat = 0;
	static double carbs = 0;
	static double protein = 0;
	static Map<String, Double> Ingredients = new HashMap<String, Double>();
	static List<String> units = new ArrayList<String>();
	static List<String> Directions = new ArrayList<String>();

	Stage stage1 = new Stage();
	
	static Recipe recipe;

	
	public RecipeMakerGUI() {
		// Creating the border pane that will hold the main panes
		BorderPane bpane = new BorderPane();

		bpane.setStyle("-fx-background-color:  #aac4e8;");
		// Pane that holds everything but the title
		GridPane pane = new GridPane();
		pane.setStyle("-fx-background-color: #aac4e8;");
		// Setting up the title
		topTitle.setFont(Font.font(40));
		topTitle.setTextAlignment(TextAlignment.CENTER);
		bpane.setTop(topTitle);
		bpane.setCenter(pane);

		// Creating variables to be accessed later
		for (int i = 0; i < 15; i++) {
			Label temp = new Label("");
			temp.setFont(Font.font(16));
			isCorrect.add(temp);
		}
		for (int i = 0; i < 15; i++) {
			Label temp = new Label("");
			temp.setFont(Font.font(20));
			labArr.add(temp);
		}
		for (int i = 0; i < 15; i++) {
			TextField temp = new TextField("");
			temp.setFont(Font.font(20));
			textArr.add(temp);
		}

		// Changing the column constraints for better spacing
		pane.getColumnConstraints().add(new ColumnConstraints(150));

		// Row 0 - Title
		labArr.get(0).setText("Title: ");

		// It refuses to iterate through this
		pane.add(labArr.get(0), 0, 0);
		pane.add(textArr.get(0), 1, 0);
		pane.add(isCorrect.get(0), 2, 0);

		// If the mouse clicks or if the user tabs out of it or presses enter it will
		// check to see if valid name
		textArr.get(0).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> nameChecker(textArr.get(0)));
		textArr.get(0).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				nameChecker(textArr.get(0));
			}
		});

		// Row 1 - Type
		labArr.get(1).setText("Type: ");
		isCorrect.get(1).setText("  ( Entree, Side or Dessert )");

		pane.add(labArr.get(1), 0, 1);
		pane.add(textArr.get(1), 1, 1);
		pane.add(isCorrect.get(1), 2, 1);

		// Checking if the type is entree side or dessert
		textArr.get(1).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> typeChecker(textArr.get(1)));
		textArr.get(1).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				typeChecker(textArr.get(1));
			}
		});

		// Row 2 - Tags - The user hits enter to input a tag
		labArr.get(2).setText("Tags: ");
		isCorrect.get(2).setText("Hit enter to put in a tag, up to 11");

		pane.add(labArr.get(2), 0, 2);
		pane.add(textArr.get(2), 1, 2);
		pane.add(isCorrect.get(2), 2, 2);
		textArr.get(2).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				if (Tags.size() < 11) {
					Tags.add(textArr.get(2).getText());
					isCorrect.get(2).setText("  " + textArr.get(2).getText() + " accepted");
					textArr.get(2).setText("");
				} else {
					isCorrect.get(2).setText("  Max tag limit reached");
				}
			}
		});
		;

		// Row 3 - Prep Time
		labArr.get(3).setText("Prep Time: ");

		pane.add(labArr.get(3), 0, 3);
		pane.add(textArr.get(3), 1, 3);
		pane.add(isCorrect.get(3), 2, 3);

		// Checking to see if the input is a double or not
		textArr.get(3).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(3), 3)) {
				prepTime = textArr.get(3).getText();
			}
		});
		textArr.get(3).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(3), 3)) {
					prepTime = textArr.get(3).getText();
				}
			}
		});

		// Row 4 - Cook Time
		labArr.get(4).setText("Cook Time: ");

		pane.add(labArr.get(4), 0, 4);
		pane.add(textArr.get(4), 1, 4);
		pane.add(isCorrect.get(4), 2, 4);

		// Double checking
		textArr.get(4).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(4), 4)) {
				cookTime = textArr.get(4).getText();
			}
		});
		textArr.get(4).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(4), 4)) {
					cookTime = textArr.get(4).getText();
				}
			}
		});

		// Row 5 - Servings
		labArr.get(5).setText("Servings: ");

		pane.add(labArr.get(5), 0, 5);
		pane.add(textArr.get(5), 1, 5);
		pane.add(isCorrect.get(5), 2, 5);

		// Double checking
		textArr.get(5).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(5), 5)) {
				servings = Double.parseDouble(textArr.get(5).getText());
			}
		});
		textArr.get(5).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(5), 5)) {
					servings = Double.parseDouble(textArr.get(5).getText());
				}
			}
		});

		// Row 6 - Calories
		labArr.get(6).setText("Calories: ");

		pane.add(labArr.get(6), 0, 6);
		pane.add(textArr.get(6), 1, 6);
		pane.add(isCorrect.get(6), 2, 6);

		// Double checking
		textArr.get(6).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(6), 6)) {
				calories = Double.parseDouble(textArr.get(6).getText());
			}
		});
		textArr.get(6).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(6), 6)) {
					calories = Double.parseDouble(textArr.get(6).getText());
				}
			}
		});

		// Row 7 - Fat
		labArr.get(7).setText("Fat: ");

		pane.add(labArr.get(7), 0, 7);
		pane.add(textArr.get(7), 1, 7);
		pane.add(isCorrect.get(7), 2, 7);

		// Double checking
		textArr.get(7).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(7), 7)) {
				fat = Double.parseDouble(textArr.get(7).getText());
			}
		});
		textArr.get(7).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(7), 7)) {
					fat = Double.parseDouble(textArr.get(7).getText());
				}
			}
		});

		// Row 8 - Carbs
		labArr.get(8).setText("Carbs: ");

		pane.add(labArr.get(8), 0, 8);
		pane.add(textArr.get(8), 1, 8);
		pane.add(isCorrect.get(8), 2, 8);

		// Double checking
		textArr.get(8).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(8), 8)) {
				carbs = Double.parseDouble(textArr.get(8).getText());
			}
		});
		textArr.get(8).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(8), 8)) {
					carbs = Double.parseDouble(textArr.get(8).getText());
				}
			}
		});

		// Row 9 - Protein
		labArr.get(9).setText("Protein: ");

		pane.add(labArr.get(9), 0, 9);
		pane.add(textArr.get(9), 1, 9);
		pane.add(isCorrect.get(9), 2, 9);

		// Double checking
		textArr.get(9).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			if (doubleChecker(textArr.get(9), 9)) {
				protein = Double.parseDouble(textArr.get(9).getText());
			}
		});
		textArr.get(9).setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.TAB || e.getCode() == KeyCode.ENTER) {
				if (doubleChecker(textArr.get(9), 9)) {
					protein = Double.parseDouble(textArr.get(9).getText());
				}
			}
		});

		// Row 10-11 - Ingredients - User uses a button to add them, will give an error
		// msg if the
		// amount is not a double and will not add the ingredient
		labArr.get(10).setText("Ingredients: ");

		textArr.get(10).setText("Ingredient");
		textArr.get(11).setText("Unit type");
		textArr.get(12).setText("How many needed?");
		pane.add(labArr.get(10), 0, 10);
		pane.add(textArr.get(10), 1, 10);
		pane.add(textArr.get(11), 2, 10);
		pane.add(textArr.get(12), 1, 11);

		// Button to add
		Button b1 = new Button("Add");
		b1.setFont(Font.font(16));
		pane.add(b1, 2, 11);

		// Side msg display
		pane.add(isCorrect.get(10), 1, 12);

		// Checking the double independently
		textArr.get(12).addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			doubleChecker(textArr.get(12), 10);
			// The second # is the side label #
		});

		b1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			try {
				// If its not a double then itll spit out an error msg at you (in a nice format)
				Ingredients.put(textArr.get(10).getText(), Double.parseDouble(textArr.get(12).getText()));
				units.add(textArr.get(11).getText());

				isCorrect.get(10).setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
				isCorrect.get(10).setText(textArr.get(10).getText() + " accepted");

				textArr.get(10).setText("Ingredient");
				textArr.get(11).setText("Unit type");
				textArr.get(12).setText("How many needed?");
			} catch (NumberFormatException nfe) {
				isCorrect.get(10).setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
				isCorrect.get(10).setText("Invalid amount. Please change.");
			}
		});

		// Creating the scene with the overall Border pane and setting it to the stage
		Scene scene = new Scene(bpane, 640, 640);
		stage1.setScene(scene);

		// Continue button
		Button b2 = new Button("Continue to next page?");
		pane.add(b2, 1, 13);

		// Goes to scene 2
		b2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Scene scene2 = scene2();
			stage1.setScene(scene2);
			
			
		});
		stage1.setTitle("Recipe Maker");
		stage1.show();
	}



	// Checks for unique name against all lists
	public static boolean checkUniqueName(String title) {

		for (int i = 0; i < main.entrees.size(); i++) {
			if (title.equalsIgnoreCase(main.entrees.get(i).getTitle())) {
				return false;
			}
		}

		for (int i = 0; i < main.sides.size(); i++) {
			if (title.equalsIgnoreCase(main.sides.get(i).getTitle())) {
				return false;
			}
		}

		for (int i = 0; i < main.desserts.size(); i++) {
			if (title.equalsIgnoreCase(main.desserts.get(i).getTitle())) {
				return false;
			}
		}

		return true;
	}

	// Checks that the recipe name is new and sets labels to the output
	public static void nameChecker(TextField text) {
		if (checkUniqueName(text.getText())) {
			isCorrect.get(0).setText("  New Recipe Detected!");
			isCorrect.get(0).setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
			title = text.getText();
		} else {
			isCorrect.get(0).setText("  Not a New Recipe, please enter a different one");
			isCorrect.get(0).setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
			title = null;
		}
	}

	// Checks if the type is valid and adjusts labels accordingly
	public static void typeChecker(TextField text) {
		if (!text.getText().equals("Entree") && !text.getText().equals("Side") && !text.getText().equals("Dessert")) {
			isCorrect.get(1).setText("  Invalid Type - Entree, Side or Dessert");
			isCorrect.get(1).setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
			type = null;
		} else {
			isCorrect.get(1).setText("  ( Entree, Side or Dessert )");
			isCorrect.get(1).setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
			type = isCorrect.get(1).getText();
		}
	}

	// Checks if the input is a double, if yes it changes the appropriate value, if
	// not it shows a side msg,
	public static boolean doubleChecker(TextField text, int rowC) {
		try { // (What row isCorrect is on)
			Double.parseDouble(text.getText());
			isCorrect.get(rowC).setText("");
			return true;
		} catch (NumberFormatException e) {
			isCorrect.get(rowC).setText("  Invalid input, please change");
			isCorrect.get(rowC).setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
			return false;
		}
	}

	// Scene 2
	public Scene scene2() {
		BorderPane bpane2 = new BorderPane();
		bpane2.setTop(topTitle);
		bpane2.setStyle("-fx-background-color: #aac4e8");
		
		GridPane gpane = new GridPane();
		gpane.setStyle("-fx-background-color: #aac4e8");
		
		bpane2.setCenter(gpane);

		// Directions - User hits button to input them
		labArr.get(11).setText("Directions ");
		// Text is ahead due to the ingredients taking up multiple text boxes
		textArr.get(13).setMinWidth(500);

		// Butotn to add direction, tells user how many they've added and clears the box
		Button b3 = new Button("Add Direction");
		b3.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Directions.add(textArr.get(13).getText());
			isCorrect.get(11).setText("Direction added. You have added " + Directions.size() + " directions");
			textArr.get(13).setText("");
		});

		gpane.add(labArr.get(11), 0, 0);
		gpane.add(textArr.get(13), 1, 0);
		gpane.add(isCorrect.get(11), 1, 2);
		gpane.add(b3, 0, 2);

		// End Button, creates the class variable recipe & tells the user that it's been
		// created
		Button b4 = new Button("Click when done");
		b4.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			for (int i = 0; i < 11 - Tags.size(); i++) {
				Tags.add("none");
			}

			recipe = new Recipe(title, type, Tags, prepTime, cookTime, servings, Ingredients, units, calories, fat,
					carbs, protein, Directions);

			isCorrect.get(12).setText("Your recipe has been created!");
			close();
			
		});

		gpane.add(b4, 1, 5);
		gpane.add(new Label(), 1, 6);
		gpane.add(isCorrect.get(12), 1, 7);

		Scene scene2 = new Scene(bpane2, 640, 250);
		return scene2;
	}

	// Method to get the generated recipe
	public Recipe getRecipe() {
		return recipe;
	}
	
	public void clearRecipe() {
		recipe = new Recipe();
	}
	
	//
	public void close() {
		Scene scene1 = new Scene(new UserGUI(), 500,500);
		stage1.setScene(scene1);
		stage1.setTitle("UserName");
		stage1.close();
		stage1.show();
		for(int i = 0; i < 15; i++) {
			labArr.get(i).setText("");
			textArr.get(i).setText("");
			isCorrect.get(i).setText("");
		}
	}

}
