package com.launchacademy.marathon.repositories;

import com.launchacademy.marathon.models.Artist;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends CrudRepository<Artist, Long> {
  Artist findByName(String name);
}
