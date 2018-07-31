package nbicsi.raex;

import java.util.List;

public class Playlist {

  private String title;
  private List<Song> songs;

  public Playlist(String title, List<Song> songs) {
    this.title = title;
    this.songs = songs;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }
}
