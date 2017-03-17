package com.playList;

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

      com.playList.Album album1 = new Album("First album");
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
      LinkedList<Song> playList = new LinkedList<Song>();
        PlayList playList1=new PlayList();
        com.playList.Albums myAlbums = new com.playList.Albums();
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
       // playList1.addInOrder(com.playList,"Love",myAlbums.createAlbum("MyFirstAlbum"));
      /*  playList1.addInOrder(com.playList,"Love",album1);
        playList1.addInOrder(com.playList,"Done",album1);
        playList1.addInOrder(com.playList,"Albret",album2);
        playList1.addInOrder(com.playList,"Bike",album2);
        playList1.showPlaylist(com.playList);
        playList1.removeSong(com.playList,"Done");
        playList1.showPlaylist(com.playList);*/
       /*

        myAlbums.createAlbum("My Second Album").printListOfSongs();
        myAlbums.createAlbum("My Third Album").printListOfSongs();
*/


    }

    public static boolean addInOrder(LinkedList<Song> songs, String songName, Album album) {
        if (album.songExist(songName)>=0) {
            ListIterator<Song> songListIterator = songs.listIterator();
            while (songListIterator.hasNext()) {
                int comparison = songListIterator.next().getTitle().compareTo(songName);
                if (comparison == 0) {
                    System.out.println("Can't execute, song already exist");
                    return false;
                } else if (comparison > 0) {
                    songListIterator.previous();
                    songListIterator.add(new Song(songName));
                    System.out.println("added " + songName + " to playlist");
                    return true;
                } else if (comparison < 0) {

                }
            }
            songListIterator.add(new Song(songName));
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

    public void showPlaylist(LinkedList<Song> songs) {
        Iterator<Song> i = songs.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }
        System.out.println("=============================");
    }

    public void playSong(LinkedList<Song>songs) {
        boolean quit=false;
        boolean goForward=true;
        ListIterator<Song> songListIterator = songs.listIterator();
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty...");
        } else {
                System.out.println("Now playing " + songListIterator.next().toString());
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
                               System.out.println("Now playing "+songListIterator.next().toString());
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
                    case 3:
                        if(!goForward){
                           // if(songListIterator)
                        }
                    case 5:
                        if(songs.size()>0){
                            System.out.println("Current song was removed");
                            songListIterator.remove();
                            if(songListIterator.hasNext()){
                                System.out.println("Now playing "+songListIterator.next());
                            }else if(songListIterator.hasPrevious()){
                                System.out.println("Now playing "+songListIterator.previous());
                            }
                        }
                        break;
                    case 6:
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
                "3 - skip next track\n"+
                "4 - skip previous track\n"+
                "5 - remove current track\n"+
                "6 - print menu options");

    }
}

