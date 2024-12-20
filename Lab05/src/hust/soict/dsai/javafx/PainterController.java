package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup toolGroup;
    
    @FXML
    private RadioButton Pen;
    
    @FXML
    private RadioButton Eraser;
//    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

   
//    void drawingAreaMouseDragged(MouseEvent event) {
//    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
//        drawingAreaPane.getChildren().add(newCircle);
//    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(Pen.isSelected()) {
    		drawWithPen(event);
    	}
    	else if(Eraser.isSelected()) {
    		erase(event);
    	}
    }

    @FXML
    void drawWithPen(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    void erase(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
        drawingAreaPane.getChildren().add(newCircle);
    }
}





