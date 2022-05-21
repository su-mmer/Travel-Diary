package com.traveldiary.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.traveldiary.data.dto.DiaryDto;
import com.traveldiary.data.requestdata.RequestDiaryData;
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
      return ResponseEntity.ok(diaryService.getDiaryById(id));
    } catch (DiaryJpaException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  /************************
   * POST *
   ************************/
  @PostMapping("/diary")
  public ResponseEntity<DiaryDto> saveDiary(RequestDiaryData data) {
    return ResponseEntity.ok(diaryService.saveDiary(data));
  }

  /************************
   * PUT *
   ************************/
  @PutMapping("/diary/{id}")
  public ResponseEntity<DiaryDto> updateDiary(@PathVariable("id") Long id, RequestDiaryData data) {
    try {
      DiaryDto diaryDto = diaryService.updateDiary(id, data);
      return ResponseEntity.ok(diaryDto);
    } catch (DiaryJpaException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  /************************
   * DELETE *
   ************************/
  @DeleteMapping("/diary/{id}")
  public ResponseEntity<DiaryDto> deleteDiary(@PathVariable Long id) {
    try {
      diaryService.deleteDiary(id);
      return ResponseEntity.ok(null);
    } catch (DiaryJpaException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }
}
