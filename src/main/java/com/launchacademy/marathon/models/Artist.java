package com.launchacademy.marathon.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="artists")
@NoArgsConstructor
@Getter
@Setter
public class Artist {
  @Id
  @SequenceGenerator(name="artist_generator", sequenceName = "artists_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "artist_generator")
  @Column(name="id", nullable = false, unique = true)
  private Long id;

  @Column(name="name", nullable = false)
  private String name;

  @OneToMany(mappedBy = "artist")
  @JsonIgnoreProperties("artist")
  private List<Song> songs;
}
