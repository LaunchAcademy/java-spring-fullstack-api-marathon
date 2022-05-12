package com.launchacademy.marathon.exceptionHandling;

public class ArtistNotCreatedException extends RuntimeException{

  public ArtistNotCreatedException() {
    super("Could not create artist");
  }
}
