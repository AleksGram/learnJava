package playList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Created by Грам on 05.03.2017.
 */
public class PlayList {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

      playList.Album album1 = new Album("First album");
        Album album2 = new Album("Second album");
        album1.addSongToAlbum("Love");
        album1.addSongToAlbum("Heart");
        album1.addSongToAlbum("Sweet");

        album1.addSongToAlbum("Car");
        album1.addSongToAlbum("Bike");
        album1.addSongToAlbum("Track");

      /*  Albums myAlbums = new Albums();
        myAlbums.addAlbum(album1.getAlbumName());
        myAlbums.addAlbum(album2.getAlbumName());
        System.out.println(myAlbums.songExistInAlbums("Love"));*/
      LinkedList<String> playList = new LinkedList<String>();
        PlayList playList1=new PlayList();
        playList.Albums myAlbums = new playList.Albums();
        playList1.addInOrder(playList,"Love",album1);
        playList1.addInOrder(playList,"Heart",album1);
        playList1.addInOrder(playList,"Sweet",album1);
        playList1.addInOrder(playList,"Car",album1);
        playList1.addInOrder(playList,"Bike",album1);
        playList1.addInOrder(playList,"Track",album1);

        playList1.showPlaylist(playList);
        playList1.playSong(playList);

       // myAlbums.createAlbum("My First Album").printListOfSongs();
       // myAlbums.addAlbum("My First Album");
       // playList1.addInOrder(playList,"Love",myAlbums.createAlbum("MyFirstAlbum"));
      /*  playList1.addInOrder(playList,"Love",album1);
        playList1.addInOrder(playList,"Done",album1);
        playList1.addInOrder(playList,"Albret",album2);
        playList1.addInOrder(playList,"Bike",album2);
        playList1.showPlaylist(playList);
        playList1.removeSong(playList,"Done");
        playList1.showPlaylist(playList);*/
       /*

        myAlbums.createAlbum("My Second Album").printListOfSongs();
        myAlbums.createAlbum("My Third Album").printListOfSongs();
*/


    }

    public static boolean addInOrder(LinkedList<String> songs, String songName, Album album) {
        if (album.songExist(songName)>=0) {
            ListIterator<String> songListIterator = songs.listIterator();
            while (songListIterator.hasNext()) {
                int comparison = songListIterator.next().compareTo(songName);
                if (comparison == 0) {
                    System.out.println("Can't execute, song already exist");
                    return false;
                } else if (comparison > 0) {
                    songListIterator.previous();
                    songListIterator.add(songName);
                    System.out.println("added " + songName + " to playlist");
                    return true;
                } else if (comparison < 0) {

                }
            }
            songListIterator.add(songName);
            System.out.println("added " + songName + " to playlist");
            return true;
        }else
        System.out.println("Can't execute "+songName+" doesn't exist in albums");
        return false;
    }


    public static boolean removeSong(LinkedList<String> songs, String songName) {
        ListIterator<String> songListIterator = songs.listIterator();
        while (songListIterator.hasNext()) {
            int comparison = songListIterator.next().compareTo(songName);
            if (comparison == 0) {
                songListIterator.remove();
                System.out.println(songName + " was removed from playlist");
                return true;
            }

        }
        System.out.println("Can't find " + songName + " operation's aborted");
        return false;
    }

    public void showPlaylist(LinkedList<String> songs) {
        Iterator<String> i = songs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("=============================");
    }

    public void playSong(LinkedList<String>songs) {
        boolean quit=false;
        boolean goForward=true;
        ListIterator<String> songListIterator = songs.listIterator();
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty...");
        } else {
                System.out.println("Now playing " + songListIterator.next());
                printMenu();
            while (!quit) {
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action){
                    case 0:
                        System.out.println("Stop music... OFF");
                        quit=true;
                        break;
                    case 1:
                       if(!goForward){
                           if(songListIterator.hasNext()) {
                               songListIterator.next();
                           }
                               goForward=true;
                           }
                           if(songListIterator.hasNext()){
                               System.out.println("Now playing "+songListIterator.next());
                       }else{
                               System.out.println("It's the END of the playlist!");
                               goForward=false;
                           }
                           break;
                    case 2:
                        if(goForward) {
                            if(songListIterator.hasPrevious()) {
                                songListIterator.previous();
                            }
                            goForward = false;
                        }
                        if(songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous());
                        } else {
                            System.out.println("We are at the start of the list");
                            goForward = true;
                        }
                        break;
                    case 5:
                        printMenu();
                        break;
                }

            }

        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 -  next track\n" +
                "2 -  previous track\n" +
                "3 - skip next ttrack\n"+
                "4 - skip previous ttrack\n"+
                "5 - print menu options");
    }
}

