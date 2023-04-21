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
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.Popup;


public class UserGUI extends TilePane{
	
	private Image userImage;
	private ImageView userView;
	private String[] imageTitles = {"Blue icon","green icon","Orange icon","Pink icon"};
	private String title;
	private ImageView[] userImages = { new ImageView("UserImage/UserBlue.PNG"),new ImageView("UserImage/UserGreen.PNG"),
			new ImageView("UserImage/UserOrange.PNG"),new ImageView("UserImage/UserPink.PNG")};
	private String[] tags = {"carnivore","paleo","Mediterranean","dash","gf","lowFat","lactoseFre"};
	private ComboBox<String> comboBox = new ComboBox<>();
	private CheckBox checkBox;
	User user = new User();
	
	public UserGUI (User user) {
		this.user = user;
		final Stage userWindow = new Stage();
		main main = new main();
		VBox titleBar = new VBox();//box for user image
		titleBar.setAlignment(Pos.CENTER);
		
		title = userWindow.getTitle();
		Label label = new Label(title);//label for user image.
		//sets user image as a default blue
		userImage = userImages[0].getImage();
		label.setGraphic(new ImageView(userImage));
		label.setAlignment(Pos.TOP_LEFT);
		titleBar.getChildren().add(label);
		Button backButton = new Button("Back"), nutritionButton = new Button("Nutrition");
		
		Button recipeMakerButton = new Button("New Recipe"), displayButton = new Button("Display Recipe"), 
				menu = new Button("Menu");
		
		/*
		VBox restrictionBar = new VBox();
		restrictionBar.setSpacing(5);
		restrictionBar.setPadding(new Insets(5));
		for (String tag : tags) {
			CheckBox checkBox = new CheckBox(tag);
			restrictionBar.getChildren().add(checkBox);
		}
		
		Button setRestrictions = new Button("Set Restrictions...");

		setRestrictions.setOnAction(e -> {
			Popup popup = new Popup();
			popup.getContent().add(restrictionBar);
            popup.setAutoHide(true);
            
            Window window = setRestrictions.getScene().getWindow();
            // Get the screen coordinates of the button
            Bounds bounds = setRestrictions.localToScreen(setRestrictions.getBoundsInLocal());

            // Set the X and Y coordinates of the popup to position it directly under the button
            popup.setX(bounds.getMinX());
            popup.setY(bounds.getMaxY());

            // Show the popup
            popup.show(window);

	/*	});
	     /*  VBox root = new VBox();
	        root.setSpacing(10);
	        root.setPadding(new Insets(10));
	        root.getChildren().addAll(setRestrictions);
	        Scene scene = new Scene(root, 300, 200);
	        userWindow.setScene(scene);*/
		
		//titleBar.getChildren().add(setRestrictions);
		//adds combo box for user icon. adds buttons.		
		getChildren().add(titleBar);
		titleBar.getChildren().add(comboBox);
		getChildren().add(backButton);
		getChildren().add(nutritionButton);
		getChildren().add(recipeMakerButton);
		getChildren().add(displayButton);

		getChildren().add(menu);

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
		
		
		backButton.setOnAction(e -> {
			//should take us back to startGUI
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
