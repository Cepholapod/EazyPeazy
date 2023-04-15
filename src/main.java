
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class main extends Application {
	public static List<Recipe> entrees;
	public static List<Recipe> sides;
	public static List<Recipe> desserts;
	public static String tag;
	//final public static Image newUser = new Image("UserImage/NewUser.PNG");
	final public static TilePane tilePane = new TilePane();
	public Stage stage2;

	// Dev @GLOVER Start function. Still looking at how to do this with only one
	// start.
	// Zach - I made modifications so that we are adding Users from users.txt (So
	// that any number of users are defaulted/saved)
	// Also, I made an add user button, which saves the User input to users.txt and
	// creates a User object.
	// Both of these functions use the User.java class
	public void start(Stage primaryStage) {
		
		NutritionGUI nutrition = new NutritionGUI();
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 800, 700);
		Scene scene2 = new Scene(nutrition, 800, 700);
		createStage(stage2, "nutrition", scene2);
		//Image newUser = new Image("UserImage/NewUser.PNG");
		Button User1 = new Button("User1");
		Button User2 = new Button("User2");
		Button User3 = new Button("User3");
		Button User4 = new Button("User4");
		Button User5 = new Button("User5");

		
		Button btNewUser = new Button("New User...");
		btNewUser.setFont(Font.font("Georgia", FontWeight.BOLD, 18));

		btNewUser.setPrefSize(12, 12);
		btNewUser.setContentDisplay(ContentDisplay.BOTTOM);

		Label label = new Label("Who's eating?");
		label.setFont(new Font("Georgia", 50));

		borderPane.setTop(label);
		borderPane.setAlignment(label, Pos.TOP_CENTER);
		borderPane.setBottom(btNewUser);
		borderPane.setCenter(tilePane);
		borderPane.setAlignment(btNewUser, Pos.BOTTOM_RIGHT);

		tilePane.setHgap(10);
		tilePane.setVgap(10);
		tilePane.setTileAlignment(Pos.CENTER);
		tilePane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		ArrayList<User> users = User.DefaultUsers();

		// I made it so that we iterate through the list of users (given users.txt),
		// and create buttons/handle action events

		for (int i = 0; i < users.size(); i++) {
			final Button button = new Button("" + users.get(i).getUsername());
			button.setContentDisplay(ContentDisplay.TOP);
			button.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
			// button.setPrefSize(80, 30);
			tilePane.getChildren().add(button);

			button.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {

					String username = button.getText();
					User user = User.getUserByUsername(username);
					// Add a method to open new stage, depending on profile chosen (given by
					// username)

				}
			});

		}
		primaryStage.setScene(scene);
		primaryStage.setTitle("Eazy Peazy");
		primaryStage.show();

		User1.setOnAction(e -> {
			stage2.show();
		});
		// Handling ActionEvent of a new user created
		btNewUser.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				handleNewUser();

			}
		});

	}

	public Stage createStage(Stage stage, String title, Scene scene) {

		stage = new Stage();
		stage.setTitle(title);
		stage.setScene(scene);

		return stage;
	}

	public static void handleNewUser() {
		// Create a new window to add a profile
		final Stage addProfileWindow = new Stage();
		// Set the title of the window
		addProfileWindow.setTitle("Add Profile");

		// Create a VBox to hold the components and set its properties
		VBox addProfilePanel = new VBox(10);
		addProfilePanel.setAlignment(Pos.CENTER);
		addProfilePanel.setPadding(new Insets(10));

		// Create a label with the text "New Profile"
		Label addProfileLabel = new Label("New Profile");
		// Set the font of the label
		addProfileLabel.setFont(new Font("Georgia", 30));
		// Add the label to the VBox
		addProfilePanel.getChildren().add(addProfileLabel);

		// Create a HBox to hold the text field and label and set its properties
		HBox textFieldPanel = new HBox(10);
		textFieldPanel.setAlignment(Pos.CENTER);
		// Create a label with the text "Username:"
		Label usernameLabel = new Label("Username:");
		usernameLabel.setFont(new Font("Georgia", 12));
		// Add the label to the HBox
		textFieldPanel.getChildren().add(usernameLabel);
		// Create a text field with a default width of 20 characters
		final TextField usernameTextField = new TextField();
		usernameTextField.setPrefWidth(200);
		// Add the text field to the HBox
		textFieldPanel.getChildren().add(usernameTextField);
		// Add the HBox to the VBox
		addProfilePanel.getChildren().add(textFieldPanel);

		// Create a button to save the new profile
		Button saveButton = new Button("Save");
		saveButton.setFont(new Font("Georgia", 14));
		// Add an EventHandler to the button for actions on the saveButton
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				// Get the text from the username text field
				String username = usernameTextField.getText();
				// Ignore username saved if there's nothing in field...
				if (username.isBlank()) {
					addProfileWindow.close();
					return;
					// If given username and press save, add the user, create a new button, then
					// close window
				} else {
					User.addUser(username);

					final Button newUserButton = new Button(username);
					newUserButton.setContentDisplay(ContentDisplay.TOP);
					newUserButton.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
					tilePane.getChildren().add(newUserButton);

					// Close the window after saving the user
					addProfileWindow.close();
				}
			}
		});
		// Add the button to the VBox
		addProfilePanel.getChildren().add(saveButton);

		// Create a Scene and set its root to the VBox
		Scene addProfileScene = new Scene(addProfilePanel, 300, 150);
		// Set the Scene of the Stage
		addProfileWindow.setScene(addProfileScene);
		// Show the Stage
		addProfileWindow.show();

	}

	public static void main(String[] args) {

		Application.launch(args);

		// we can change this, but the top is how we could initialize the lists before
		// any tags, and the else would be when we have a tag!
		if (tag == null) {
			entrees = RecipeSelector.entreeSelector(new File("Entree.txt"));
			sides = RecipeSelector.sideSelector(new File("Side.txt"));
			desserts = RecipeSelector.dessertSelector(new File("Dessert.txt"));
		} else {
			entrees = DietDecorator.entreeSelector(new File("Entree.txt"), tag);
			sides = DietDecorator.sideSelector(new File("Side.txt"), tag);
			desserts = DietDecorator.dessertSelector(new File("Dessert.txt"), tag);
		}

		Scanner sc = new Scanner(System.in);
		File f = new File("Recipe.txt");
		List<Recipe> recipe = RecipeParser.recipeReader(f);

		System.out.println("Do you want to create a recipe? (Yes/No)");
		if (sc.next().equalsIgnoreCase("Yes"))
			createRecipe();

		// RecipeSelector rs = new RecipeSelector();
		// RecipeSelector vs = new VeganDecorator();
		// System.out.println(rs.desserts.get(0).print());
		System.out.println(entrees.get(0).print());

		// rs.shutdown();
	}

	

	public void loadUsers() {

	}
}
