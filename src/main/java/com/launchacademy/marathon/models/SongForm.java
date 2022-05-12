package com.launchacademy.marathon.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Getter
@Setter
@Component
public class SongForm {

  @NotBlank
  private String title;

  private String genre;

  @NotNull
  private Integer releaseYear;

  @NotNull
  private Boolean explicitContent;

  @NotNull
  private Long artistId;

}
