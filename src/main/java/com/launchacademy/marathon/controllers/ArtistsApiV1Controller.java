package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.exceptionHandling.ArtistNotCreatedException;
import com.launchacademy.marathon.exceptionHandling.ArtistNotFoundException;
import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.services.ArtistService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistsApiV1Controller {

  private ArtistService service;

  @Autowired
  public ArtistsApiV1Controller(ArtistService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<Map<String, List<Artist>>> listArtists() {
    Map<String,List<Artist>> dataMap =new HashMap<>();
    dataMap.put("artists", service.findAll());
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Map<String, Artist>> addArtist(@RequestBody Artist artist) {
    try{
      Map<String, Artist> dataMap = new HashMap<>();
      service.save(artist);
      dataMap.put("artist", artist);
      return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
    }catch(Exception ex){
      throw new ArtistNotCreatedException();
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Artist>> getArtist(@PathVariable Long id){
    Map<String, Artist> dataMap = new HashMap<>();
    Artist result = service.findById(id);

    if(result == null){
      throw new ArtistNotFoundException();
    }

    dataMap.put("artist", result);
    return new ResponseEntity<>(dataMap, HttpStatus.OK);
  }
}
