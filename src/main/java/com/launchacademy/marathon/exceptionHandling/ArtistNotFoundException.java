package com.launchacademy.marathon.exceptionHandling;

public class ArtistNotFoundException extends RuntimeException{

  public ArtistNotFoundException() {
    super("No artist found with the provided ID");
  }
}
