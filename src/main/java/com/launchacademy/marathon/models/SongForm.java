package com.launchacademy.marathon.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
@ToString
public class SongForm {

  private String title;
  private String genre;
  private Integer releaseYear;
  private Boolean explicitContent;
  private Long artistId;

}
