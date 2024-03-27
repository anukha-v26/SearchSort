import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;
public class Main extends PApplet{
    ArrayList<Song> data = new ArrayList<Song>();
    private int bottom;
    private int top;
    private int x = 40;
    private int y = 40;
    private int size = 80;
    private int index = 0;
    private Song target;
    public static void main(String[] args) {PApplet.main("Main");}
    public static Main app;
    public Main(){app = this;}
    public void settings(){
        size(640, 520);
    }
    public void draw(){}
    public void setup() {
        background(255);
        Table table = loadTable("data/songData.csv", "header");
        for (TableRow row : table.rows()) {
            int iD = row.getInt("iD"); // obtain iD
            String songName = row.getString("Name"); // obtain song name
            String artist = row.getString("Artist"); // obtain artist
            int streams = row.getInt("streams"); // obtain artist
            data.add(new Song(iD, songName, artist, streams, x, y, size, index, 0));
        }
       /*
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                randomState = CellState.DEAD;
                double rand = Math.random();
                if(rand > 0.5 && row != 0 && col != 0 && row != cells.length-1 && col != cells[0].length -1){
                    randomState = CellState.ALIVE;
                }
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;
                cells[row][col] = new Cell(x, y, CELL_SIZE, row, col, randomState, rules);
            }
        }*/
    }

    private int binarySearchIterative(){
        int middle = (top+bottom)/2;
        Song current = data.get(middle);
        if(target.compareTo(current) == 0){
            return middle;
        }else if(target.compareTo(current) == 1){
            top = middle+1;
            return top;
        }else{
            bottom = middle-1;
            return bottom;
        }
    }

    public void keyPressed(){
        if (key == 'a'){
            binarySearchIterative();
        }
    }

    public void assignXY(){
        for(int i = 0; i< data.size(); i++){
            if(i == 4 || i == 9 || i == 14){
                x = 40;
                y += 120;
                data.get(i).setX(x);
                data.get(i).setY(y);
            }else{
                x+= 120;
                data.get(i).setX(x);
            }
        }
    }
}