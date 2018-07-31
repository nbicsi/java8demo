package nbicsi.raex;

import static nbicsi.raex.Genre.POP;
import static nbicsi.raex.Genre.ROCK;
import static nbicsi.raex.SongProviderService.songs;

import java.util.ArrayList;
import java.util.Random;

public class ClassicApp {

  Library library = new Library("All my stuff", new ArrayList<>());

  public void run() throws InterruptedException {
    System.out.println(" --- classic app started ---\n");
    // load all song from the internet
    for (int i = 0; i < songs.size(); i++){
      System.out.println(songs.get(i));
    }

    // make rock playlist
    long startTime = System.currentTimeMillis();
    Playlist rockPlaylist = new Playlist("Rock out", new ArrayList<>());
    for (int i = 0; i < songs.size(); i++) {
      if (songs.get(i).getGenre() == ROCK) {
        rockPlaylist.getSongs().add(songs.get(i));
      }
    }
    Thread.sleep(new Random().nextInt(500));
    System.out.println("execution time: " + (System.currentTimeMillis() - startTime) + "ms");

    // make rock playlist
    startTime = System.currentTimeMillis();
    Playlist popPlaylist = new Playlist("fun times", new ArrayList<>());
    for (int i = 0; i < songs.size(); i++) {
      if (songs.get(i).getGenre() == POP){
        popPlaylist.getSongs().add(songs.get(i));
      }
    }
    Thread.sleep(new Random().nextInt(500));
    System.out.println("execution time: " + (System.currentTimeMillis() - startTime) + "ms");

    // make rock playlist
    startTime = System.currentTimeMillis();
    Playlist favoritesPlaylist = new Playlist("FAVS", new ArrayList<>());
    for (int i = 0; i < songs.size(); i++) {
      if (songs.get(i).isFavorited()) {
        favoritesPlaylist.getSongs().add(songs.get(i));
      }
    }
    Thread.sleep(new Random().nextInt(500));
    System.out.println("execution time: " + (System.currentTimeMillis() - startTime) + "ms");

    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < favoritesPlaylist.getSongs().size() -1; i++){
        if(favoritesPlaylist.getSongs().get(i).getRating() >
            favoritesPlaylist.getSongs().get(i+1).getRating()){
            Song temp = favoritesPlaylist.getSongs().get(i);
            favoritesPlaylist.getSongs().set(i, favoritesPlaylist.getSongs().get(i+1));
            favoritesPlaylist.getSongs().set(i+1, temp);
            isSorted = false;
        }
      }
    }

    library.getPlaylists().add(rockPlaylist);
    library.getPlaylists().add(popPlaylist);
    library.getPlaylists().add(favoritesPlaylist);

    for (Playlist playlist : library.getPlaylists()){
      System.out.println(playlist.getTitle() + ":");
      for (Song song : playlist.getSongs())
        System.out.println("\t" + song);
    }


    System.out.println("\n--- classic app finished ---");
  }
}
