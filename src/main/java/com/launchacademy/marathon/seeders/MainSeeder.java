package com.launchacademy.marathon.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {
  private ArtistsSeeder artistsSeeder;
  private SongsSeeder songsSeeder;

  @Autowired
  public MainSeeder(ArtistsSeeder artistsSeeder, SongsSeeder songsSeeder) {
    this.songsSeeder = songsSeeder;
    this.artistsSeeder = artistsSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    artistsSeeder.seed();
    songsSeeder.seed();
  }
}
