package com.launchacademy.marathon.services;

import com.launchacademy.marathon.models.Song;
import com.launchacademy.marathon.models.SongForm;
import java.util.Optional;

public interface SongService {

	Iterable<Song> findAll();

	Optional<Song> findById(Long id);

	void save(Song song);

	Song createSong(SongForm songForm);
}
