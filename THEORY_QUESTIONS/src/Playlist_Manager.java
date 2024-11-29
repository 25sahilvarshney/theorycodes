import java.util.*;

public class Playlist_Manager {
    private List<String> songs;

    public Playlist_Manager() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public void removeSong(String title) {
        songs.remove(title);
    }

    public void swapSongs(int index1, int index2) {
        Collections.swap(songs, index1, index2);
    }

    public void displayPlaylist() {
        for (String song : songs) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {
        Playlist_Manager playlist = new Playlist_Manager();
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");
        playlist.swapSongs(0, 2);
        playlist.removeSong("Song B");
        playlist.displayPlaylist();
    }
}

