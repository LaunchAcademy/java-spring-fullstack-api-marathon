package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.exceptionHandling.ArtistNotCreatedException;
import com.launchacademy.marathon.exceptionHandling.ArtistNotFoundException;
import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.services.ArtistService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistsApiV1Controller {

  private final ArtistService artistService;

  @Autowired
  public ArtistsApiV1Controller(ArtistService artistService) {
    this.artistService = artistService;
  }

  @GetMapping
  public ResponseEntity<Map<String, List<Artist>>> listArtists() {
    Map<String, List<Artist>> dataMap = new HashMap<>();
    dataMap.put("artists", artistService.findAll());
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Artist>> getArtist(@PathVariable Long id) {
    Optional<Artist> artist = artistService.findById(id);
    Map<String, Artist> dataMap = new HashMap<>();
    if (artist.isPresent()) {
      dataMap.put("artist", artist.get());
    } else {
      throw new ArtistNotFoundException();
    }
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Map<String, Artist>> create(@RequestBody Artist artist) {
    try {
      artistService.save(artist);
      Map<String, Artist> dataMap = new HashMap<>();
      dataMap.put("artist", artist);

      return new ResponseEntity<Map<String, Artist>>(dataMap, HttpStatus.CREATED);
    } catch (IllegalArgumentException ex) {
      throw new ArtistNotCreatedException();
    }
  }


}
