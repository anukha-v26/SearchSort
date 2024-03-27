public class Song implements Comparable{
    private String songName;
    private String artist;
    private int streams;
    private int iD;
    private int x, y, size, index;
    private int fillColor;

    public Song(int iD, String songName, String artist, int streams, int x, int y, int size, int index, int fillColor){
        this.songName = songName;
        this.artist = artist;
        this.streams = streams;
        this.iD = iD;
        this.x = x;
        this.y = y;
        this.size = size;
        this.index = index;
        this.fillColor = fillColor;

    }
    public void display(){
        Main.app.fill(fillColor);
        Main.app.rect(x, y, 80, 80);
    }

    @Override
    public int compareTo(Object anotherObject){
        Song y = (Song) anotherObject;
        if (this.streams < ((Song) anotherObject).streams){
            return -1;
        } else if (this.streams > ((Song)anotherObject).streams){
            return 1;
        } else {
            return 0;
        }
    }
    public int getStreams(){
        return streams;
    }
    public void changeColor(){
       fillColor = 255;
    }
    public int getFillColor(){
        return fillColor;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

}

