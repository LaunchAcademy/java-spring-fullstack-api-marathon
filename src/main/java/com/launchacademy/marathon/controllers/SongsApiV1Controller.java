package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.exceptionHandling.SongNotCreatedException;
import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.models.SongForm;
import com.launchacademy.marathon.services.ArtistService;
import com.launchacademy.marathon.services.SongService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/songs")
public class SongsApiV1Controller {

  private SongService songService;
  private ArtistService artistService;

  @Autowired
  public SongsApiV1Controller(SongService songService,
      ArtistService artistService) {
    this.songService = songService;
    this.artistService = artistService;
  }

  @PostMapping
  public ResponseEntity<Map<String, Song>> createSong(@RequestBody SongForm songForm) {
    Artist artist = artistService.findById(songForm.getArtistId());
    Map<String, Song> dataMap = new HashMap<>();

    try {
      Song newSong = new Song();
      newSong.setTitle(songForm.getTitle());
      newSong.setArtist(artist);
      newSong.setGenre(songForm.getGenre());
      newSong.setReleaseYear(songForm.getReleaseYear());
      newSong.setExplicitContent(songForm.getExplicitContent());
      songService.save(newSong);
      dataMap.put("song", newSong);
    } catch(Exception ex) {
      throw new SongNotCreatedException();
    }

  return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
  }
}
