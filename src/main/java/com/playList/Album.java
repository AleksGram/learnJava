package com.playList;

import java.util.ArrayList;
import java.util.Scanner;


public class Album {
    private String albumName;
    private ArrayList<Song> songs;

    Scanner scanner =new Scanner(System.in);

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs=new ArrayList<Song>();

    }

    public String getAlbumName() {
        return albumName;
    }

    public int songExist(String songTitle) {
       for (int i = 0; i < this.songs.size(); i++) {
           //for (Song checkSong: this.songs) alternative loop

               if (songTitle.equals(this.songs.get(i).getTitle())) {
                return i;
            }
        }
             return -1;
    }

    public boolean addSongToAlbum(String songTitle){
        if(songExist(songTitle)>=0){
            System.out.println("Can't execute! "+songTitle+" already exist...");
            return false;
        }else{
            this.songs.add(new Song(songTitle));
            System.out.println(songTitle+" was added to "+this.getAlbumName());
        }
        return true;
    }
    public boolean removeSong(String songTitle){
        int songIndex=songExist(songTitle);
        if(songIndex>=0){
            songs.remove(songIndex);
            System.out.println("The "+songTitle+" was removed");
            return true;
        }else{
            System.out.println(songTitle+" dosen't exist in album!");
        }
        return false;
    }


    public void printListOfSongs(){
        System.out.println("*** "+this.getAlbumName()+" ***");
        for(int i=0;i<songs.size();i++){
            System.out.println((i+1)+" "+songs.get(i).getTitle());

        }
        System.out.println("##########################");
    }

}
