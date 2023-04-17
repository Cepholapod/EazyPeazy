import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NutritionGUI extends Pane{
	//once the user is complete remove numbers
	private Stage nutritionStage;
	double carbs = 100;
	double protein = 57;
	double fat = 170;
	double weight = 180;
	double calConstant = 15;
	User user = new User();
	//initiates vars will take User as parameter 
	public NutritionGUI(User user) {
		this.user = user;
		//carbs = user.getCarbs();
		//fat = user.getFat();
		//protein = user.getProtein();
		// weight = user.getweight();
		nutrition();
	}
	/**
	 * sets up the nutrition window and creates a pie chart based off of the 
	 * macros the user intakes from a meal.
	 * @ZACH
	 * other work will have to be done outside of this class for it to work properly @USER
	 *  
	 */
	public void nutrition() {
		final Stage nutritionStage = new Stage();
		this.nutritionStage = nutritionStage;
		nutritionStage.setTitle("Nutrition");
		Button backButton = new Button("Back");
		//creates list for the pie chart. 
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Protien", proteinDailyValue()),
						new PieChart.Data("Carbs", carbDailyValue()),
						new PieChart.Data("Fat", fatDailyValue()));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Macros");	
		getChildren().add(chart);
		getChildren().add(backButton);
	    setStyle("-fx-background-color: whitesmoke;");
		backButton.setOnAction(e -> {
			Scene scene2  = new Scene(new UserGUI(user), 500,500);
			nutritionStage.setScene(scene2);
			nutritionStage.setTitle(user.getUsername());
			nutritionStage.close();
			nutritionStage.show();
			
		});
	}
	
	public double fatDailyValue () {
		//calculates the total fat taken in by the amount needed by cal count
		double percentFat = this.fat/(.3*(this.weight * calConstant));	
		return percentFat;	
	}
	
	public double carbDailyValue () {
		//calculates the total carbs taken in by the amount needed by cal count
		double percentCarb = this.carbs/(.3*(this.weight * calConstant));
		
		return percentCarb;		
		}

	public double proteinDailyValue () {
		//calculates the total protein taken in by the amount needed by cal count
		double percentProtein = this.protein/(.4*(this.weight * calConstant));
	
		return percentProtein;
	}
	
}
