package com.traveldiary.data.dto;

import com.traveldiary.domain.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DiaryDto {
  private Long id;
  private String title;
  private String content;

  public DiaryDto(Diary diary) {
    this.id = diary.getId();
    this.title = diary.getTitle();
    this.content = diary.getContent();
  }
}
