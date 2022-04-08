package com.traveldiary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.traveldiary.data.dto.DiaryDto;
import com.traveldiary.exception.DiaryJpaException;
import com.traveldiary.service.DiaryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DiaryController {

  private final DiaryService diaryService;

  /************************
   * GET *
   ************************/
  @GetMapping("/diary/{id}")
  public ResponseEntity<DiaryDto> getDiaryInfoById(@PathVariable("id") Long id) {
    try {
      return ResponseEntity.ok(diaryService.getDiary(id));
    } catch (DiaryJpaException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  /************************
   * POST *
   ************************/
  /************************
   * PUT *
   ************************/
  /************************
   * DELETE *
   ************************/
}
