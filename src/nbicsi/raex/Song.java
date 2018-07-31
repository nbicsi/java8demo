package nbicsi.raex;

import java.util.Objects;

public class Song {

  private String title;
  private String artist;
  private Genre genre;
  private int durationInSeconds;
  private double rating;
  private boolean favorited;

  public Song(String title, String artist, Genre genre, int durationInSeconds, double rating,
      boolean favorited) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.durationInSeconds = durationInSeconds;
    this.rating = rating;
    this.favorited = favorited;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public int getDurationInSeconds() {
    return durationInSeconds;
  }

  public void setDurationInSeconds(int durationInSeconds) {
    this.durationInSeconds = durationInSeconds;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public boolean isFavorited() {
    return favorited;
  }

  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Song song = (Song) o;
    return durationInSeconds == song.durationInSeconds &&
        rating == song.rating &&
        favorited == song.favorited &&
        Objects.equals(title, song.title) &&
        Objects.equals(artist, song.artist) &&
        Objects.equals(genre, song.genre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, artist, genre, durationInSeconds, rating, favorited);
  }

  @Override
  public String toString() {
    return "Song{" +
        "title='" + title.toUpperCase() + '\'' +
        ", artist='" + artist + '\'' +
        ", genre='" + genre + '\'' +
        ", duration=" + durationInSeconds + 's' +
        ", rating=" + rating +
        ", favorited=" + favorited +
        '}';
  }
}
