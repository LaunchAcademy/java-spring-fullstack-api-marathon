package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Artist;
import java.util.List;
import java.util.Optional;

public interface ArtistService {

  List<Artist> findAll();

  void save(Artist artist);

  Optional<Artist> findById(Long id);

  Optional<Artist> findByName(String artistName);
}
