import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NutritionGUI extends VBox{
	
	public NutritionGUI() {
		nutrition();
	}
	
	public void nutrition() {
		final Stage nutritionWindow = new Stage();
		Label carbs = new Label(), protein = new Label(), fat = new Label();
		nutritionWindow.setTitle("Nutrition"); 
		
		Circle circle = new Circle(50,Color.GRAY);
		getChildren().add(circle);
		setAlignment(Pos.CENTER);
		
		 widthProperty().addListener((obs, oldVal, newVal) -> {
	            // Update the radius of the circle to be half the width of the pane
	            circle.setRadius(newVal.doubleValue() / 4);
	        });
		
	    widthProperty().addListener((obs, oldVal, newVal) -> {
            // Update the radius of the circle to be half the width of the pane
            circle.setRadius(newVal.doubleValue() / 4);
        });
		
	    
	    Arc proteinArc = new Arc();
	    Arc carbArc = new Arc();
	    Arc fatArc = new Arc();
	    
	    proteinArc.setCenterX(circle.getCenterX());
        proteinArc.setCenterY(circle.getCenterY());
        proteinArc.setRadiusX(circle.getRadius());
        proteinArc.setRadiusY(circle.getRadius());
        proteinArc.setStartAngle(0);
        proteinArc.setLength(120);
        proteinArc.setType(ArcType.ROUND);
        proteinArc.setStroke(Color.BLUE);
        proteinArc.setStrokeWidth(5);
        // Scale the arc's properties with the width of the VBox
        widthProperty().addListener((obs, oldVal, newVal) -> {
            proteinArc.setRadiusX(newVal.doubleValue() / 4);
            proteinArc.setRadiusY(newVal.doubleValue() / 4);
            proteinArc.setCenterX(newVal.doubleValue() / 2);
            proteinArc.setCenterY(newVal.doubleValue() / 2);
            proteinArc.setStrokeWidth(newVal.doubleValue() / 50);
        });
	    setStyle("-fx-background-color: silver;");
	    
	    getChildren().add(proteinArc);

	}
	

	
}
