package playList;

import java.text.DecimalFormat;

/**
 * Created by Грам on 05.03.2017.
 */
public class Song {

   private String title;
   private  double duration;


    public Song(String title) {
        this.title = title;
        this.duration=Math.random();
        this.duration=Double.parseDouble(new DecimalFormat("##.##").format(duration));
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
