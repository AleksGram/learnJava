package com.innerClass;

import java.util.ArrayList;
import java.util.Scanner;


public class Album {
    private String albumName;
    private SongList songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new SongList();
    }

    public SongList getSongs() {
        return songs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void addSong(String title){
        this.songs.addSong(title);
    }
    public int findSong(String title){
        return this.songs.findSong(title);
    }

    public void printListOfSongs(){
        this.songs.print();
    }

    private class SongList {
        private ArrayList<Song> listSongs;

        public SongList() {
            this.listSongs = new ArrayList();
        }

        private int findSong(String songTitle) {
            for (int i = 0; i < listSongs.size(); i++) {
                if (listSongs.get(i).getTitle().equals(songTitle)) {
                    System.out.println(songTitle + " was finded");
                    return i;
                }


            }
            return -1;
        }

        private boolean addSong(String songTitle){
            if(findSong(songTitle)==-1){
                listSongs.add(new Song(songTitle));
                System.out.println(songTitle+" was added");
                return true;
            }else
                System.out.println("can't add");
            return false;
        }
        private void print (){
            for (int i=0;i<listSongs.size();i++){
                System.out.println(i+" "+listSongs.get(i).getTitle());
            }
        }
    }
}