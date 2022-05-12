package com.launchacademy.marathon.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "songs")
@NoArgsConstructor
@Getter
@Setter
public class Song {
  @Id
  @SequenceGenerator(name="song_generator", sequenceName = "songs_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "song_generator")
  @Column(name="id", nullable = false, unique = true)
  private Long id;

  @Column(name="title", nullable = false)
  private String title;

  @Column(name="genre")
  private String genre;

  @Column(name="release_year", nullable = false)
  private Integer releaseYear;

  @Column(name="explicit_content", nullable = false)
  private Boolean explicitContent;

  @ManyToOne
  @JoinColumn(name = "artist_id", nullable = false)
  @JsonIgnoreProperties("songs")
  private Artist artist;
}
