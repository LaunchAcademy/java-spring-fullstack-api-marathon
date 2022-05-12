package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.models.SongForm;
import com.launchacademy.marathon.repositories.SongsRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongDatabaseService implements SongService {
  private SongsRepository songsRepository;
  private ArtistService artistService;

  @Autowired
  public SongDatabaseService(SongsRepository songsRepository,
      ArtistService artistService) {
    this.songsRepository = songsRepository;
    this.artistService = artistService;
  }

  public Optional<Song> findById(Long id) {
    return songsRepository.findById(id);
  }

  public void save(Song song) {
    songsRepository.save(song);
  }

  @Override
  public Song createSong(SongForm songForm) {
    Song song = new Song();
    song.setTitle(songForm.getTitle());
    song.setGenre(songForm.getGenre());
    song.setReleaseYear(songForm.getReleaseYear());
    song.setExplicitContent(songForm.getExplicitContent());

    Optional<Artist> artist = artistService.findById(songForm.getArtistId());
    if(artist.isPresent()) {
      song.setArtist(artist.get());
    }

    return songsRepository.save(song);
  }

  public Iterable<Song> findAll() {
    return songsRepository.findAll();
  }
}
