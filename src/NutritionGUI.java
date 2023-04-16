import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NutritionGUI extends Pane{
	
	double carbs = 100;
	double protein = 57;
	double fat = 170;
	double weight = 180;
	double calConstant = 15;
	
	
	public NutritionGUI() {
		//carbs = user.getCarbs();
		//fat = user.getFat();
		//protein = user.getProtien();
		// weight = user.getweigth();
		nutrition();
	}
	
	public void nutrition() {
		final Stage nutritionWindow = new Stage();
		Label carbs = new Label(), protein = new Label(), fat = new Label();
		nutritionWindow.setTitle("Nutrition"); 
		
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
		
		double percentFat = this.fat/(.3*(this.weight * calConstant));
		
		return percentFat *100;
		
	}
	
	public double carbDailyValue () {
		
		double percentCarb = this.carbs/(.3*(this.weight * calConstant));
		
		return percentCarb *100;
		
		}
	


	public double proteinDailyValue () {
	
		double percentProtein = this.protein/(.4*(this.weight * calConstant));
	
		return percentProtein * 100;
	
	}
	
}
