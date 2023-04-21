import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NutritionGUI extends Pane{
	//once the user is complete remove numbers
	
	double carbs = 100;
	double protein = 57;
	double fat = 170;
	double weight = 180;
	double calConstant = 15;
	User user = new User();
	private ComboBox<String> mealCB = new ComboBox<>();
	private String[] mealTitle; 
	//initiates vars will take User as parameter 
	public NutritionGUI(User user) {
		this.user = user;
		nutrition();
	}
	/**
	 * sets up the nutrition window and creates a pie chart based off of the 
	 * macros the user intakes from a meal.
	 */
	public void nutrition() {
		final Stage nutritionStage = new Stage();
		
		nutritionStage.setTitle("Nutrition");
		//creates list for the pie chart. 
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Protien" + String.format(": %.2f", proteinDailyValue()*100)+ "%", proteinDailyValue()),
						new PieChart.Data("Carbs" + String.format(": %.2f", carbDailyValue()*100)+ "%", carbDailyValue()),
						new PieChart.Data("Fat" + String.format(": %.2f", fatDailyValue()*100) +"%", fatDailyValue()));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Macros");
		getChildren().add(chart);
	    setStyle("-fx-background-color: whitesmoke;");
	}
	
	public double fatDailyValue () {
		//calculates the total fat taken in by the amount needed by cal count
		double percentFat = user.getFat()/(.3*(this.weight * calConstant));	
		return percentFat;	
	}
	
	public double carbDailyValue () {
		//calculates the total carbs taken in by the amount needed by cal count
		double percentCarb = user.getCarbs()/(.3*(this.weight * calConstant));
		
		return percentCarb;		
		}

	public double proteinDailyValue () {
		//calculates the total protein taken in by the amount needed by cal count
		double percentProtein = user.getProtein()/(.4*(this.weight * calConstant));
	
		return percentProtein;
	}
	
	public void mealTitles(String[] title) {
		for(int i = 0; i<main.entrees.size(); i++) {
			
		}
		
	}
	
}
