package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Artist;
import java.util.List;

public interface ArtistService {


  List<Artist> findAll();

  Artist findById(Long id);

  void save(Artist artist1);

  Artist findByName(String name);
}
