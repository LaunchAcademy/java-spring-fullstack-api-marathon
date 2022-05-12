package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends CrudRepository<Song, Long> {
}
