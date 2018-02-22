import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class StepPane extends Pane {
    Label count = new Label("00000");

    public StepPane(){
        Pane steps = new Pane();
        steps.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");

        //Label
        Label panelabel = new Label("Steps Count");
        panelabel.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");

        //Show count number

        count.relocate(30,20);
        count.setStyle("-fx-font: 50 arial; -fx-text-fill: rgb(0,200,0); -fx-background-color: white;");

        //Set size
        steps.setPrefSize(200,100);

        //Add to pane
        getChildren().addAll(steps, count, panelabel);
    }

    public void update(int steps_count){
        count.setText(String.format("%05d",steps_count));
    }
}
