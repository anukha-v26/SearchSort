public class Song implements Comparable{
    private String songName;
    private String artist;
    private int streams;
    private int iD;
    private int x, y;
    private int fillColor;

    public Song(int iD, String songName, String artist, int streams, int x, int y,  int fillColor){
        this.songName = songName;
        this.artist = artist;
        this.streams = streams;
        this.iD = iD;
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
    }
    public Song(int iD){
        this.iD = iD;
    }
    public void display(){
        Main.app.textSize(13);
        Main.app.fill(fillColor, 200, 250);
        Main.app.rect(x, y, 100, 100);
        Main.app.fill(0);
        Main.app.text("iD " + iD, x + 3, y + 20);
        Main.app.text(streams, x +3, y + 40);
        Main.app.text(artist, x+3, y + 60);
        Main.app.text(songName, x+3, y + 80);
    }
    @Override
    public int compareTo(Object anotherObject){
        if (this.iD < ((Song) anotherObject).iD){
            return -1;
        } else if (this.iD > ((Song)anotherObject).iD){
            return 1;
        } else {
            return 0;
        }
    }
    public int getiD(){
        return iD;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){return x;}
    public void changeColor(int color){
       fillColor = color;
    }
}

