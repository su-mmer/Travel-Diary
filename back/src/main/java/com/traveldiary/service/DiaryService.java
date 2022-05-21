package com.traveldiary.service;

import org.springframework.stereotype.Service;
import com.traveldiary.data.dto.DiaryDto;
import com.traveldiary.data.requestdata.RequestDiaryData;
import com.traveldiary.domain.Diary;
import com.traveldiary.exception.DiaryJpaException;
import com.traveldiary.exception.errorcode.DiaryJpaErrorCode;
import com.traveldiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

  private final DiaryRepository diaryRepository;

  public DiaryDto getDiaryById(Long id) throws DiaryJpaException {
    Diary diary = diaryRepository.findById(id)
        .orElseThrow(() -> new DiaryJpaException(DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getMsg(),
            DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getCode()));

    return new DiaryDto(diary);
  }

  @Transactional
  public DiaryDto saveDiary(RequestDiaryData data) {
    Diary diary = Diary.builder()
        .title(data.getTitle())
        .content(data.getContent())
        .build();
    return new DiaryDto(diaryRepository.save(diary));
  }

  @Transactional
  public DiaryDto updateDiary(Long id, RequestDiaryData data) throws DiaryJpaException {
    Diary diary = diaryRepository.findById(id)
        .orElseThrow(() -> new DiaryJpaException(DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getMsg(),
            DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getCode()));

    diary.updateDiaryData(data.getTitle(), data.getContent());
    return new DiaryDto(diary);
  }

  @Transactional
  public void deleteDiary(Long id) throws DiaryJpaException {
    Diary diary = diaryRepository.findById(id)
        .orElseThrow(() -> new DiaryJpaException(DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getMsg(),
            DiaryJpaErrorCode.CANNOT_FOUND_DIARY.getCode()));

    diaryRepository.delete(diary);
  }
}
