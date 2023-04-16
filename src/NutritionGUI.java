import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NutritionGUI extends Pane{
	//once the user is complete remove numbers
	double carbs = 100;
	double protein = 57;
	double fat = 170;
	double weight = 180;
	double calConstant = 15;
	
	//initiates vars will take User as parameter 
	public NutritionGUI() {
		//carbs = user.getCarbs();
		//fat = user.getFat();
		//protein = user.getProtien();
		// weight = user.getweigth();
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
		final Stage nutritionWindow = new Stage();
		nutritionWindow.setTitle("Nutrition"); 
		//creates list for the pie chart. 
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("Protien", proteinDailyValue()),
						new PieChart.Data("Carbs", carbDailyValue()),
						new PieChart.Data("Fat", fatDailyValue()));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Macros");	
		getChildren().add(chart);
	    setStyle("-fx-background-color: whitesmoke;");
  
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
