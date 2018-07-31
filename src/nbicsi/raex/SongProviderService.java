package nbicsi.raex;

import static java.util.Arrays.*;
import static nbicsi.raex.Genre.*;

import java.util.List;

public final class SongProviderService {

  private SongProviderService(){}

  // this goes to a server and gets the list of all song
  protected static final List<Song> songs = asList(
      new Song("lose yourself", "Marshal Mathers", HIP_HOP, 300, 8.2, true),
      new Song("highway to hell", "AC/DC", ROCK, 302, 8.9, false),
      new Song("whatever", "guta", MANELE, 402, 1.9, false),
      new Song("give a little", "ash", POP, 312, 7, false),
      new Song("nothing else matter", "metalica", ROCK, 312, 6, true),
      new Song("love to me", "dimention", DNB, 312, 7, false),
      new Song("Heavy Dirty Soul", "21 pilots", ROCK, 312, 8, true),
      new Song("breakfast at tiffany's", "Whatever", POP, 312, 7, false)
  );

}
