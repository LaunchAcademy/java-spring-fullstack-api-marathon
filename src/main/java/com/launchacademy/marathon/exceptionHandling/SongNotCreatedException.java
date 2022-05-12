package com.launchacademy.marathon.exceptionHandling;

public class SongNotCreatedException extends RuntimeException{

  public SongNotCreatedException() {
    super("Could not create song");
  }
}
