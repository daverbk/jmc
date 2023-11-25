package playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        return findSong(title) == null && songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int position, LinkedList<Song> playlist) {
        int index = position - 1;
        if (index >= songs.size() || index < 0) {
            return false;
        }

        Song songToAdd = songs.get(index);
        return songs.contains(songToAdd)
                && (playlist.contains(songToAdd)
                || playlist.add(songToAdd));
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song songToAdd = findSong(title);
        return songs.contains(songToAdd)
                && (playlist.contains(songToAdd)
                || playlist.add(songToAdd));
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }
}
