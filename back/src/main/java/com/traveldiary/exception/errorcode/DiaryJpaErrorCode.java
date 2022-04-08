package com.traveldiary.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiaryJpaErrorCode {

  CANNOT_FOUND_DIARY("CANNOT_FOUND_DIARY", 1000000);


  private final String msg;
  private final int code;
}
