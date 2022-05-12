package com.launchacademy.marathon.seeders;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.services.SongService;
import com.launchacademy.marathon.services.ArtistService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongsSeeder {
  private final ArtistService artistService;
  private final SongService songService;

  @Autowired
  public SongsSeeder(
      ArtistService artistService, SongService songService) {
    this.artistService = artistService;
    this.songService = songService;
  }

  public void seed() {
     if (((List<Song>)songService.findAll()).size() == 0) {
       Artist ed = artistService.findByName("Ed Sheeran");
       Artist tom = artistService.findByName("Tom Petty");
       Artist kelly = artistService.findByName("Kelly McFarling");

       Song edSong = new Song();
       edSong.setTitle("Shivers");
       edSong.setGenre("Pop");
       edSong.setReleaseYear(2021);
       edSong.setExplicitContent(false);
       edSong.setArtist(ed);
       songService.save(edSong);

       Song tomSong = new Song();
       tomSong.setTitle("Free Fallin'");
       tomSong.setGenre("Rock");
       tomSong.setReleaseYear(2021);
       tomSong.setExplicitContent(false);
       tomSong.setArtist(tom);
       songService.save(tomSong);

       Song kellySong1 = new Song();
       kellySong1.setTitle("Both");
       kellySong1.setGenre("Folk/Country");
       kellySong1.setReleaseYear(2017);
       kellySong1.setExplicitContent(false);
       kellySong1.setArtist(kelly);
       songService.save(kellySong1);

       Song kellySong2 = new Song();
       kellySong2.setTitle("Birds");
       kellySong2.setGenre("Folk/Country");
       kellySong2.setReleaseYear(2021);
       kellySong2.setExplicitContent(false);
       kellySong2.setArtist(kelly);
       songService.save(kellySong2);
     }
  }
}
