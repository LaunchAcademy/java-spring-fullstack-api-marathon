package com.launchacademy.marathon.exceptionHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
  @ExceptionHandler(value = { ArtistNotFoundException.class })
  public ResponseEntity<String> handleCategoryNotFoundException(ArtistNotFoundException ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

    @ExceptionHandler(value = { ArtistNotCreatedException.class })
  public ResponseEntity<Map<String, List>> handleArtistNotCreatedException(ArtistNotCreatedException ex) {
    System.out.println("Could not create Artist");
    List<String> errorList = new ArrayList<>();
    errorList.add(ex.getMessage());
    Map<String, List> responseBody = new HashMap<>();
    responseBody.put("errors", errorList);
    return new ResponseEntity<Map<String, List>>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
  }

    @ExceptionHandler(value = { SongNotCreatedException.class })
    public ResponseEntity<Map<String, List>> handleSongNotCreatedException(SongNotCreatedException ex) {
    System.out.println("Could not create Song");
    List<String> errorList = new ArrayList<>();
    errorList.add(ex.getMessage());
    Map<String, List> responseBody = new HashMap<>();
    responseBody.put("errors", errorList);
    return new ResponseEntity<Map<String, List>>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
