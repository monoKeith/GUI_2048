import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GraphicsUI extends Application{
    GridPane Gridpane = new GridPane();
    StepPane Steppane = new StepPane();
    Button restart = new Button("Initialize Game");

    //Grid
    Grid grid = new Grid();

    public void start(Stage primaryStage){
        Pane aPane = new Pane();

        //Resize button
        restart.setPrefSize(200,50);

        //Relocate grid pane
        Gridpane.relocate(10,10);
        //Relocate step pane
        Steppane.relocate(820,10);
        //Relocate button
        restart.relocate(820,760);
        //Handler
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid = new Grid();
                Steppane.update(grid.getMove_count());
                Gridpane.update(grid.getMap());
            }
        });

        //Set background color, add pane
        aPane.setStyle("-fx-background-color: white;");
        aPane.getChildren().addAll(Gridpane, Steppane, restart);

        //Scene
        Scene scene = new Scene(aPane, 1030,820);
        handler(scene);

        //Stage
        primaryStage.setTitle("2048 GUI");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Update
        Gridpane.update(grid.getMap());
    }

    private void handler(Scene scene){
        scene.setOnKeyPressed(ke -> {
            KeyCode keycode = ke.getCode();
            if(keycode.equals(KeyCode.S)){
                grid.controller("d");
            }
            if(keycode.equals(KeyCode.W)){
                grid.controller("u");
            }
            if(keycode.equals(KeyCode.A)){
                grid.controller("l");
            }
            if(keycode.equals(KeyCode.D)){
                grid.controller("r");
            }
            //Call Update
            Steppane.update(grid.getMove_count());
            Gridpane.update(grid.getMap());
        });
    }

    public static void main(String[] args){ launch(args); }
}
