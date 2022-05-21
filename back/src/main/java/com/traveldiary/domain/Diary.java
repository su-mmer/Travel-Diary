package com.traveldiary.domain;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity(name = "diary")
@NoArgsConstructor
@AllArgsConstructor
public class Diary {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @Column(name = "create_time")
  private LocalDateTime createTime;

  @OneToMany(mappedBy = "diary")
  private Set<ImageFile> imageFiles;

  public void updateDiaryData(String title, String content) {
    this.title = title;
    this.content = content;
  }

}
