import java.util.Random;

public class Grid {
    private int[][] map = new int[4][4];
    private int move_count = 0;
    Random random = new Random();

    public Grid(){
        //Fill all spaces as 0.
        for(int[] tmp_row: map){
            for(int tmp_column: tmp_row){
                tmp_column = 0;
            }
        }
        //Randomly generate two numbers on random places.
        generate_num();
        generate_num();
    }

    //Getter
    public int[][] getMap(){ return map; }
    public int getMove_count(){ return move_count; }

    //Generate random value of 2 or 4 on random location with 0.
    private void generate_num(){
        int target_x, target_y;
        while(true){
            target_x = random.nextInt(4);
            target_y = random.nextInt(4);
            if(map[target_y][target_x] == 0){
                map[target_y][target_x] = 2 + random.nextInt(2) * 2;
                break;
            }
        }
        System.out.println("Random Number Generated at [" + (target_x + 1) + ", " + (target_y + 1) + "]");
    }

    //Print out the map on console.
    public void showTextUI(){
        System.out.println("----------------------------");
        for(int row = 0; row < 4; row ++){
            System.out.print("   |");
            for(int column = 0; column < 4; column++){
                if (map[row][column] == 0) System.out.print("     ");
                else System.out.print(String.format("%4d", map[row][column]) + " ");
            }
            System.out.println("|");
        }
        System.out.println("----------------------------");
    }

    //Controller
    public void controller(String command){
        switch(command){
            case "d":
                if(down() && !isFull()){
                    generate_num();
                    move_count ++;
                }
                break;
            case "u":
                if(up() && !isFull()){
                    generate_num();
                    move_count ++;
                }
                break;
            case "l":
                if(left() && !isFull()){
                    generate_num();
                    move_count ++;
                }
                break;
            case "r":
                if(right() && !isFull()){
                    generate_num();
                    move_count ++;
                }
            default:
                break;
        }
    }

    //Game Over Detection
    private boolean isFull(){
        for(byte row = 0; row < 4; row ++){
            for(byte column = 0; column < 4; column ++){
                if(map[row][column] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    //Down
    private boolean down(){
        //Modification flag
        boolean modified = false;
        boolean gap_removed = gap_down();
        //Merge down
        for(byte row = 3; row > 0; row --){
            for(byte column = 0; column < 4; column++ ){
                if((map[row][column] == map[row-1][column])&&(map[row][column] != 0)){
                    map[row][column] *= 2;
                    map[row-1][column] = 0;
                    modified = true;
                }
            }
        }
        //Remove Gap
        if(modified) gap_down();
        //Return
        return modified || gap_removed;
    }

    private boolean gap_down(){
        //Modification flag
        boolean modified;
        boolean result = false;
        do{
            modified = false;
            for(byte row = 3; row > 0; row --){
                for(byte column = 0; column < 4; column ++){
                    if((map[row][column]==0)&&(map[row-1][column]!=0)){
                        map[row][column] = map[row-1][column];
                        map[row-1][column] = 0;
                        modified = true;
                        result = true;
                    }
                }
            }
        } while(modified);
        return result;
    }

    //Up
    private boolean up(){
        //Modification flag
        boolean modified = false;
        boolean gap_removed = gap_up();
        //Merge up
        for(byte row = 0; row < 3; row ++){
            for(byte column = 0; column < 4; column ++){
                if((map[row][column] == map[row+1][column])&&(map[row][column] != 0)){
                    map[row][column] *= 2;
                    map[row+1][column] = 0;
                    modified = true;
                }
            }
        }
        //Remove Gap
        if(modified) gap_up();
        //Return
        return modified || gap_removed;
    }

    private boolean gap_up(){
        //Modification flag
        boolean modified;
        boolean result = false;
        do{
            modified = false;
            for(byte row = 0; row < 3; row ++){
                for(byte column = 0; column < 4; column ++){
                    if((map[row][column]==0)&&(map[row+1][column]!=0)){
                        map[row][column] = map[row+1][column];
                        map[row+1][column] = 0;
                        modified = true;
                        result = true;
                    }
                }
            }
        } while(modified);
        return result;
    }

    //Left
    private boolean left(){
        //Modification flag
        boolean modified = false;
        boolean gap_removed = gap_left();
        //Merge left
        for(byte column = 0; column < 3; column ++){
            for(byte row = 0; row < 4; row ++){
                if((map[row][column] == map[row][column+1])&&(map[row][column] != 0)){
                    map[row][column] *= 2;
                    map[row][column+1] = 0;
                    modified = true;
                }
            }
        }
        //Remove Gap
        if(modified) gap_left();
        //Return
        return modified || gap_removed;
    }

    private boolean gap_left(){
        //Modification flag
        boolean modified;
        boolean result = false;
        do{
            modified = false;
            for(byte column = 0; column < 3; column ++){
                for(byte row = 0; row < 4; row ++){
                    if((map[row][column]==0)&&(map[row][column+1]!=0)){
                        map[row][column] = map[row][column+1];
                        map[row][column+1] = 0;
                        modified = true;
                        result = true;
                    }
                }
            }
        } while(modified);
        return result;
    }

    //Right
    private boolean right(){
        //Modification flag
        boolean modified = false;
        boolean gap_removed = gap_right();
        //Merge right
        for(byte column = 3; column > 0; column --){
            for(byte row = 0; row < 4; row ++){
                if((map[row][column] == map[row][column-1])&&(map[row][column] != 0)){
                    map[row][column] *= 2;
                    map[row][column-1] = 0;
                    modified = true;
                }
            }
        }
        //Remove Gap
        if(modified) gap_right();
        //Return
        return modified || gap_removed;
    }

    private boolean gap_right(){
        //Modification flag
        boolean modified;
        boolean result = false;
        do{
            modified = false;
            for(byte column = 3; column > 0; column --){
                for(byte row = 0; row < 4; row ++){
                    if((map[row][column]==0)&&(map[row][column-1]!=0)){
                        map[row][column] = map[row][column-1];
                        map[row][column-1] = 0;
                        modified = true;
                        result = true;
                    }
                }
            }
        }while(modified);
        return result;
    }

}
