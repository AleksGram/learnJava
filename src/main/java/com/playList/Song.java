package playList;

/**
 * Created by Грам on 05.03.2017.
 */
public class Song {
   private String title;
   private  double duration;

    public Song(String title) {
        this.title = title;
        this.duration=Math.random();
    }

    public String getTitle() {
        return title;
    }
    public void printSongInfo(){
        System.out.println(title+" --- "+duration);

    }
}
