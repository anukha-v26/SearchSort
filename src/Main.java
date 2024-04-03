import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;
public class Main extends PApplet {
    ArrayList<Song> data = new ArrayList<Song>();
    private int bottom;
    private int top;
    private int middle;
    private int x = 15;
    private int y = 20;
    private int index = 0;
    private  Song target;
    private String input = "";
    private boolean found = false;
    private boolean notExist = false;
    private boolean notYet = false;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public static Main app;

    public Main() {
        app = this;
    }

    public void settings() {
        size(1450, 400);
    }



    public void setup() {
        background(255);
        Table table = loadTable("data/songData.csv", "header");
        for (TableRow row : table.rows()) {
            int iD =  row.getInt("iD"); // obtain iD
            //int iD = row.getInt("iD"); // obtain iD
            String songName = row.getString("Name"); // obtain song name
            String artist = row.getString("Artist"); // obtain artist
            int streams = row.getInt("streams"); // obtain artist
            data.add(new Song(iD, songName, artist, streams, x, y, 255));
            x+=110;
        }
        x = 0;
        top = data.size() - 1;
    }
    public void draw() {
        background(255);
        for (int i = 0; i < data.size(); i++){
            data.get(i).display();
            fill(0);
        }
        Main.app.textSize(20);
        text("Instructions", 680, 240);
        Main.app.textSize(14);
        text(input, 933, 280);
        text("1. Click 2 to sort", 650, 260);
        text("2. Enter a song title in lowercase and click enter: ", 650, 280);
        text("3. Click 3 to search for your song! ", 650, 300);
        text("4. Click 4 to reset!", 650, 320);
        if(found == true){
            text("found at index " + middle, 690, 150);
        }else if(notExist == true){
            text("does not exist", 690, 150);
        }else if(notYet == true){
            text("not found yet", 690, 150);
        }
    }

    private int binarySearchIterative() {
        middle = (top + bottom) / 2;
        Song current = data.get(middle);
        if (target.compareTo(current) == 0) {
            return middle;
        } else if (target.compareTo(current) == -1) {
            top = middle - 1;
            return top;
        } else {
            bottom = middle + 1;
            return bottom;
        }
    }

    private void selectionSort() {
        for (int curIndex = 0; curIndex < data.size() - 1; curIndex++) {
            int minIndex = findMin(curIndex);
            swap(curIndex, minIndex);
        }
        for(int i = 0; i<data.size(); i++){
        }
    }
    private int findMin(int startingIndex) {
        int minIndex = startingIndex;
        for (int i = minIndex + 1; i < data.size(); i++) {
            if (data.get(i).compareTo(data.get(minIndex)) == -1) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    private void swap( int a, int b) {
        Song temp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, temp);
        int tempx = data.get(a).getX();
        data.get(a).setX(data.get(b).getX());
        data.get(b).setX(tempx);
    }

    private int binarySearchRecursive(int target, int bottom, int top){
        if (bottom <= top) {
            int middle = (bottom+top)/2;
            if ((data.get(middle).getiD())  > target)
            {
                binarySearchRecursive(target, bottom, middle - 1);
            }
            else if ((data.get(middle).getiD()) < target)
            {
                binarySearchRecursive(target, middle+1, top);
            }
            else
            {
                return middle;
            }
        }
        return -1;
    }
    public void reset(){
        Table table = loadTable("data/songData.csv", "header");
        for (TableRow row : table.rows()) {
            int iD =  row.getInt("iD"); // obtain iD
            String songName = row.getString("Name"); // obtain song name
            String artist = row.getString("Artist"); // obtain artist
            int streams = row.getInt("streams"); // obtain artist
            data.add(new Song(iD, songName, artist, streams, x, y, 255));
            x+=110;
        }
        x = 0;
        top = data.size() - 1;
    }

    public void keyPressed() {
        if(key == '2'){
           selectionSort();
        }
        if(key != '2' && key != '3' && key!= ENTER && key != RETURN && key != '4') {
            input += key;
        }if(key == RETURN || key == ENTER){
            if (input.equals("seven")) {
                target = data.get(0); //assigning target to data at index of "seven" (not creating a new Song object for target)
            } else if (input.equals("lala")) {
                target = data.get(1);
            } else if (input.equals("vampire")) {
                target = data.get(2);
            } else if (input.equals("cruel summer")) {
                target = data.get(3);
            } else if (input.equals("where she goes")) {
                target = data.get(4);
            } else if (input.equals("sprinter")) {
                target = data.get(5);
            } else if (input.equals("ella baila sola")) {
                target = data.get(6);
            } else if (input.equals("columbia")) {
                target = data.get(7);
            } else if (input.equals("fukumean")) {
                target = data.get(8);
            } else if (input.equals("la bebe")) {
                target = data.get(9);
            } else if (input.equals("un x100to")) {
                target = data.get(10);
            } else if (input.equals("super shy")) {
                target = data.get(11);
            } else if (input.equals("flowers")) {
                target = data.get(12);
            }else{
                notExist = true;
            }
        } if(key == '3' && notExist == false) {
            data.get(middle).changeColor(255);
            if (binarySearchIterative() == middle) {
                data.get(middle).changeColor(0);
                found = true;
            } else if (middle == 0 || middle == data.size()-1) {
                data.get(middle).changeColor(0);
            } else {
                data.get(middle).changeColor(0);
                notYet = true;
            }
        }if(key == '4'){
            x = 20;
            y = 20;
            bottom = 0;
            top = data.size()-1;
            found = false;
            notExist = false;
            notYet = false;
            data.clear();
            reset();
            input = "";
        }
    }
}