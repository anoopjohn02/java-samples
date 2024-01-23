package anoop.test.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist.
 * Otherwise, the playlist will end with the last song which points to null.
 *
 * Implement a function isInRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.
 *
 * For example, the following code prints "true" as both songs point to each other.
 */

//Time limit exceeded
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        return isInRepeating(new ArrayList<>());
    }

    public boolean isInRepeating(List<Song> uniqueSongs) {
        if(uniqueSongs.contains(this)){
            return true;
        }
        uniqueSongs.add(this);
        return nextSong != null && nextSong.isInRepeating(uniqueSongs);
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("tiger");

        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}
