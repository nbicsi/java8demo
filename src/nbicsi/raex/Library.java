package nbicsi.raex;

import java.util.List;

public class Library {

  private String title;
  private List<Playlist> playlists;

  public Library(String title, List<Playlist> playlists) {
    this.title = title;
    this.playlists = playlists;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Playlist> getPlaylists() {
    return playlists;
  }

  public void setPlaylists(List<Playlist> playlists) {
    this.playlists = playlists;
  }
}
