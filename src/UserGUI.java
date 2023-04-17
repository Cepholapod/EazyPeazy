import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class UserGUI extends TilePane{
	
	private Image userImage;
	private ImageView userView;
	private String[] imageTitles = {"Blue icon","green icon","Orange icon","Pink icon"};
	private String title;
	private ImageView[] userImages = { new ImageView("UserImage/UserBlue.PNG"),new ImageView("UserImage/UserGreen.PNG"),
			new ImageView("UserImage/UserOrange.PNG"),new ImageView("UserImage/UserPink.PNG")};
	private ComboBox<String> comboBox = new ComboBox<>();
	
	
	public UserGUI () {
		
		final Stage userWindow = new Stage();
		main main = new main();
		VBox titleBar = new VBox();//box for user image
		titleBar.setAlignment(Pos.CENTER);
		
		title = userWindow.getTitle();
		Label label = new Label(title);//label for user image.
		titleBar.getChildren().add(label);
		Button backButton = new Button("Back"), nutritionButton = new Button("Nutrition");
		
		Button recipeMakerButton = new Button("New Recipe"), displayButton = new Button("Display Recipe");
		
		
		getChildren().add(titleBar);
		titleBar.getChildren().add(comboBox);
		getChildren().add(backButton);
		getChildren().add(nutritionButton);
		getChildren().add(recipeMakerButton);
		getChildren().add(displayButton);
		
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
			Scene scene2  = new Scene(new NutritionGUI(), 640,640);
			userWindow.setScene(scene2);
			userWindow.setTitle("Nutrition");
			userWindow.show();
		});
		
		recipeMakerButton.setOnAction(e -> {
			Scene scene3 = new Scene(new RecipeMakerGUI(), 500,500);
			userWindow.setScene(scene3);
			userWindow.setTitle("Recipe Maker");
			userWindow.show();
		});
		
//		displayButton.setOnAction(e -> {
//			Scene scene4 = new Scene(new SingleRecipeGUI(), 640, 640);
//			userWindow.setScene(scene4);
//			userWindow.setTitle("Recipe Viewer");
//			userWindow.show();
//		});
		
		setStyle("-fx-background-color: whitesmoke");
		
	}
	
	public Image getUserImage() {
		return this.userImage;
	}
	
	
}
