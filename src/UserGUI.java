import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.Popup;


public class UserGUI extends VBox {
	
	private Image userImage;
	private ImageView userView;
	private String[] imageTitles = {"Blue icon","green icon","Orange icon","Pink icon"};
	private String title;
	private ImageView[] userImages = { new ImageView("UserImage/UserBlue.PNG"),new ImageView("UserImage/UserGreen.PNG"),
			new ImageView("UserImage/UserOrange.PNG"),new ImageView("UserImage/UserPink.PNG")};
	private String[] tags = {"carnivore","paleo","Mediterranean","dash","gf","lowFat","lactoseFre"};
	private ComboBox<String> comboBox = new ComboBox<>();
	User user = new User();
	
	public UserGUI (User user) {
		this.user = user;
		final Stage userWindow = new Stage();
		main main = new main();
		VBox buttons = new VBox();//box for buttons
		VBox userPic = new VBox();//box for user image
		buttons.setAlignment(Pos.CENTER);
		userPic.setAlignment(Pos.CENTER);
		
		title = userWindow.getTitle();
		Label label = new Label(title);//label for user image.
		//sets user image as a default blue
		userImage = userImages[0].getImage();
		label.setGraphic(new ImageView(userImage));
		label.setAlignment(Pos.TOP_LEFT);
		userPic.getChildren().add(label);
		Button exitButton = new Button("Exit"), nutritionButton = new Button("Nutrition");
		
		Button recipeMakerButton = new Button("New Recipe"), displayButton = new Button("Display Recipe"), 
				menu = new Button("Menu");

		
	    setAlignment(Pos.TOP_CENTER); // set alignment to center
	    setSpacing(10); // set spacing between buttons

	    // modify button sizes and font
	    exitButton.setPrefSize(300, 50);
	    nutritionButton.setPrefSize(300, 50);
	    recipeMakerButton.setPrefSize(300, 50);
	    displayButton.setPrefSize(300, 50);
	    menu.setPrefSize(300, 50);
		exitButton.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
		nutritionButton.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
		recipeMakerButton.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
		displayButton.setFont(Font.font("Georgia", FontWeight.BOLD, 18));
		menu.setFont(Font.font("Georgia", FontWeight.BOLD, 24));
				
		userPic.setAlignment(Pos.TOP_LEFT);
		getChildren().add(userPic);
		userPic.getChildren().add(comboBox);
		
		buttons.setAlignment(Pos.TOP_CENTER);
		getChildren().add(menu);
		getChildren().add(nutritionButton);
		getChildren().add(recipeMakerButton);
		getChildren().add(displayButton);
		getChildren().add(exitButton);
		
	//	getChildren().add(setRestrictions);

		
		//list of options for combo box 
		ObservableList<String> options = FXCollections.observableArrayList(imageTitles);
		//adds all options to combo box and sets color of background to transparent
		comboBox.getItems().addAll(options);
		comboBox.setPrefWidth(10);
		comboBox.setStyle("-fx-background-color: transparent;");
		comboBox.setOnAction(e -> {
			//selects image from the combo box from combobox index   
			int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
			//sets user image
			userImage = userImages[selectedIndex].getImage();
			//creates and aligns new imageView
			label.setGraphic(new ImageView(userImage));
			label.setAlignment(Pos.TOP_LEFT);
			//sets main user image for later use, though effectively this does nothing without the backButton.
			main.setUserImage(userImage);
		});
		
		
		exitButton.setOnAction(e -> {
			System.exit(0);
			
		});
		nutritionButton.setOnAction(e -> {
			Scene scene2  = new Scene(new NutritionGUI(user), 500,500);
			userWindow.setScene(scene2);
			userWindow.setTitle("Nutrition");
			userWindow.show();
		});
		
		recipeMakerButton.setOnAction(e -> {
			Scene scene3 = new Scene(new RecipeMakerGUI(user), 640,640);
			userWindow.setScene(scene3);
			userWindow.setTitle("Recipe Maker");
			userWindow.close();
		});
		
//		displayButton.setOnAction(e -> {
//			Scene scene4 = new Scene(new SingleRecipeGUI(), 640, 640);
//			userWindow.setScene(scene4);
//			userWindow.setTitle("Recipe Viewer");
//			userWindow.show();
//		});
		menu.setOnAction(e -> {
			//Scene scene1 = new Scene(new MenuRecipeGUI(user, 7), 1000,1000);
			Scene scene2 = new Scene(new numMealsGUI(user), 100, 100);
			userWindow.setTitle("Menu");
			userWindow.setScene(scene2);
			//userWindow.setScene(scene1);
			userWindow.close();
		});
		
		setStyle("-fx-background-color: whitesmoke");
		
	}
	
	public Image getUserImage() {
		return this.userImage;
	}
	
	
}
