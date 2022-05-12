package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Artist;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends CrudRepository<Artist, Long> {

  Optional<Artist> findByName(String name);

}
