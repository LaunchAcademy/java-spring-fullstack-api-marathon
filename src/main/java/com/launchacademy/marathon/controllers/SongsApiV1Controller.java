package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.exceptionHandling.SongNotCreatedException;
import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.models.SongForm;
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
@RequestMapping("/api/v1/songs")
public class SongsApiV1Controller {

  private SongService songService;

  @Autowired
  public SongsApiV1Controller(SongService songService) {
    this.songService = songService;
  }

  @PostMapping
  public ResponseEntity<Map<String, Song>> createSong(@RequestBody SongForm songForm){
    try {
      Song persistedSong = songService.createSong(songForm);
      Map<String,Song> dataMap = new HashMap<>();
      dataMap.put("song", persistedSong);
      return new ResponseEntity<Map<String,Song>>(dataMap, HttpStatus.CREATED);
    } catch(IllegalArgumentException e) {
      throw new SongNotCreatedException();
    }
  }

}
