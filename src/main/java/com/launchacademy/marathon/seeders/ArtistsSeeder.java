package com.launchacademy.marathon.seeders;

import com.launchacademy.marathon.models.Artist;
import com.launchacademy.marathon.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArtistsSeeder {

  private ArtistService artistService;

  @Autowired
  public ArtistsSeeder(
      ArtistService artistService) {
    this.artistService = artistService;
  }

  public void seed() {
    if (artistService.findAll().size() == 0) {
      Artist artist1 = new Artist();
      artist1.setName("Ed Sheeran");
      artistService.save(artist1);

      Artist artist2 = new Artist();
      artist2.setName("Tom Petty");
      artistService.save(artist2);

      Artist artist3 = new Artist();
      artist3.setName("Kelly McFarling");
      artistService.save(artist3);
    }
  }
}
