package nbicsi.raex;

import static java.lang.System.currentTimeMillis;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static nbicsi.raex.Genre.POP;
import static nbicsi.raex.Genre.ROCK;
import static nbicsi.raex.SongProviderService.songs;

import com.sun.org.apache.bcel.internal.generic.NEW;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8App {

  Library library = new Library("All my stuff", new ArrayList<>());

  public void run() {

    System.out.println(" --- java 8 app started ---\n");

    // todo: read me
    // load all song from the internet
    System.out.println("Everything out there:");
    songs.forEach(System.out::println);

    System.out.println("Total length of all songs: "
        + songs.stream().mapToInt(Song::getDurationInSeconds).reduce(0, (a, b) -> a + b) + "s");

    System.out.println("\nSong length stats in seconds: "
        + songs.stream().mapToInt(Song::getDurationInSeconds).summaryStatistics());

    // todo: read me
    // show how many songs there are in each genre
    songs.stream()
        .collect(groupingBy(Song::getGenre)) // produces a map
        .forEach(
            // key is the genre, value is the list of songs in that genre
            (genre, songsInGenre) -> System.out.format("\n%s has %d songs.", genre, songsInGenre.size())
        );

    System.out.println("\n------------------- playlists -------------------");
    // make rock playlist
    Playlist rockPlaylist = measureExec("Creating rock playlist",
        () -> new Playlist("Rock out", songs.stream().filter(isOfGenre(ROCK)).collect(toList()))
    );

    // make pop playlist
    Playlist popPlaylist = measureExec("Creating pop playlist",
        () -> new Playlist("Fun times", songs.stream().filter(isOfGenre(POP)).collect(toList()))
    );

    // make fav playlist
    Playlist favoritesPlaylist = measureExec("Creating favorites playlist",
        () -> new Playlist("FAVS", songs.stream().filter(Song::isFavorited).collect(toList()))
    );

    // I like my favorites sorted
    favoritesPlaylist.setSongs(
        measureExec("Sorting favorites",
            () -> favoritesPlaylist.getSongs()
                    .stream()
                    .sorted((s1, s2) -> s1.getRating() >= s2.getRating() ? 1 : -1)
                    .collect(toList()))
    );

    library.getPlaylists().addAll(asList(rockPlaylist, popPlaylist, favoritesPlaylist));

    System.out.format("========================== %s ==========================\n", library.getTitle());
    library.getPlaylists()
        .stream()
        .flatMap(playlist -> playlist.getSongs().stream())
        .forEach(System.out::println);

    System.out.println("\n--- java 8 app finished ---");

  }

  private Predicate<Song> isOfGenre(Genre genre) {
    return song -> song.getGenre() == genre;
  }

   // todo: read me
  /**
   * @param code the code for which the execution time will be measured
   * @param output provide a way to consume the measured value (log in our case)
   * @return the result of the executed code
   */
  private <T> T measureExec(String details, Supplier<T> code, Consumer<String> output) {
    long startTime = currentTimeMillis();
    // executes the code and get the result
    T result = code.get();
    try {
      // pretend to work real hard (get data from a server, DB, etc. )
      Thread.sleep(new Random().nextInt(500));
    } catch (InterruptedException ignored) {}
    output.accept("- Execution of '" + details + "' took  " + (currentTimeMillis() - startTime) + "ms");
    return result;
  }

  // todo: read me
  /**
   * defaults the output method to logging to console
   * see {@link #measureExec(String, Supplier, Consumer)} for details
   */
  private <T> T measureExec(String details, Supplier<T> code) {
    return measureExec(details, code, System.out::println);
  }


}
