package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.repositories.ArtistsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistDatabaseService implements ArtistService {

  private ArtistsRepository repository;

  @Autowired
  public ArtistDatabaseService(ArtistsRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Artist> findAll() {
    return (List<Artist>) repository.findAll();
  }

  @Override
  public Artist findById(Long id) {
    Optional<Artist> foundArtist = repository.findById(id);
//    if (foundArtist.isPresent()) {
//      return foundArtist.get();
//    }
//    return null;
    return foundArtist.orElse(null);
  }

  @Override
  public void save(Artist artist) {
    repository.save(artist);
  }

  @Override
  public Artist findByName(String name) {
    return repository.findByName(name);
  }
}
