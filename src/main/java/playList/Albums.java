package playList;

import java.util.ArrayList;

import static playList.PlayList.scanner;


public class Albums {

    private ArrayList<Album> albums;

    public Albums() {
        this.albums = new ArrayList<Album>();
    }


    public String getAlbumName(int albumIndex) {
        return albums.get(albumIndex).getAlbumName();
    }

    private int findAlbum(String albumName) {
        for (int i = 0; i < albums.size(); i++) {
            if (albumName.equals(albums.get(i).getAlbumName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAlbum(String albumName) {
        if (findAlbum(albumName) >= 0) {
            System.out.println("Can't execute " + albumName + " already exist");
            return false;
        } else {
            albums.add(new Album(albumName));
            System.out.println(albumName + " was added to albums list");
        }
        return true;
    }

    public Album createAlbum(String albumName) {
        Album newAlbum = new Album(albumName);
        System.out.println("How many songs " + albumName + " will be included?");
        int quantityOfSongs = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < quantityOfSongs; i++) {
            System.out.println("Type the name of the " + (i + 1) + " song:");
            String songName = scanner.nextLine();
            newAlbum.addSongToAlbum(songName);
        }
        return newAlbum;
    }

    public boolean songExistInAlbums(String songName) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).songExist(songName) >= 0) {
                return true;
            }
        }
        return false;
    }
}
