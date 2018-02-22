import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GridPane extends Pane {
    //16 Blocks
    TextField[][] blocks = new TextField[4][4];

    public GridPane(){
        Pane grid = new Pane();
        grid.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");

        //Initialize blocks
        for(byte row = 0; row < 4; row ++){
            for(byte column = 0; column < 4; column ++){
                blocks[row][column] = new TextField();
                blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: GRAY; -fx-text-fill: WHITE;");
                blocks[row][column].relocate(25+column*190,25+row*190);
                blocks[row][column].setPrefSize(180,180);
                blocks[row][column].setAlignment(Pos.CENTER);
                blocks[row][column].setDisable(true);
            }
        }

        //Label
        Label panelabel = new Label("Grid");
        panelabel.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");

        //Set size
        grid.setPrefSize(800,800);

        //Add to pane
        for(byte row = 0; row < 4; row ++){
            for(byte column = 0; column < 4; column ++){
                grid.getChildren().add(blocks[row][column]);
            }
        }
        getChildren().addAll(grid, panelabel);

    }

    public void update(int[][] target_grid){
        for(int row = 0; row < 4; row ++){
            for(int column = 0; column < 4; column ++){
                //Set Color
                switch(target_grid[row][column]){
                    case 0:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: GRAY; -fx-text-fill: WHITE;");
                        break;
                    case 2:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #DC143C; -fx-text-fill: WHITE;");
                        break;
                    case 4:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #FA8072; -fx-text-fill: WHITE;");
                        break;
                    case 8:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #FFA500; -fx-text-fill: WHITE;");
                        break;
                    case 16:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #B8860B; -fx-text-fill: WHITE;");
                        break;
                    case 32:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #6B8E23; -fx-text-fill: WHITE;");
                        break;
                    case 64:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #8FBC8F; -fx-text-fill: WHITE;");
                        break;
                    case 128:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #20B2AA; -fx-text-fill: WHITE;");
                        break;
                    case 256:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #00CED1; -fx-text-fill: WHITE;");
                        break;
                    case 512:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #4682B4; -fx-text-fill: WHITE;");
                        break;
                    case 1024:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #6495ED; -fx-text-fill: WHITE;");
                        break;
                    case 2048:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #1E90FF; -fx-text-fill: WHITE;");
                        break;
                    case 4096:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #8A2BE2; -fx-text-fill: WHITE;");
                        break;
                    case 8192:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #7B68EE; -fx-text-fill: WHITE;");
                        break;
                    default:
                        blocks[row][column].setStyle("-fx-font: 52 arial; -fx-background-color: #32CD32; -fx-text-fill: WHITE;");
                        break;
                }
                //Set Text
                if(target_grid[row][column] == 0){
                    blocks[row][column].setText(" ");
                }else{
                    blocks[row][column].setText(target_grid[row][column] + "");
                }
            }
        }
    }
}
