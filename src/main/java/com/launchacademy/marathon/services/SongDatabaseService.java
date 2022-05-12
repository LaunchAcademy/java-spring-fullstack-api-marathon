package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.repositories.SongsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongDatabaseService implements SongService {
  private SongsRepository songsRepository;

  @Autowired
  public SongDatabaseService(SongsRepository songsRepository) {
    this.songsRepository = songsRepository;
  }

  public Optional<Song> findById(Long id) {
    return songsRepository.findById(id);
  }

  public void save(Song song) {
    songsRepository.save(song);
  }

  public Iterable<Song> findAll() {
    return songsRepository.findAll();
  }
}