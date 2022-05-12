package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.repositories.ArtistsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistDatabaseService implements ArtistService{
  private ArtistsRepository artistsRepository;

  @Autowired
  public ArtistDatabaseService(
      ArtistsRepository artistsRepository) {
    this.artistsRepository = artistsRepository;
  }

  @Override
  public List<Artist> findAll() {
    return (List<Artist>)artistsRepository.findAll();
  }

  @Override
  public void save(Artist artist) {
    artistsRepository.save(artist);
  }

  @Override
  public Optional<Artist> findById(Long id) {
    return artistsRepository.findById(id);
  }

  @Override
  public Optional<Artist> findByName(String artistName) {
    return artistsRepository.findByName(artistName);
  }
}
