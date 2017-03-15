package playList;

import java.text.DecimalFormat;


public class Song {

   private String title;
   private String duration;


    public Song(String title) {
        this.title = title;
        DecimalFormat value = new DecimalFormat("#.##");
        this.duration=value.format(Math.random());



    }

    public String getTitle() {
        return title;
    }
    public void printSongInfo(){
        System.out.println(title+" --- "+duration);

    }
public String toString(){
    return title+ ":"+ " "+duration;
}
}
