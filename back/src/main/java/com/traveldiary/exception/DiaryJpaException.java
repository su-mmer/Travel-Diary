package com.traveldiary.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryJpaException extends Exception {

  private static final long serialVersionUID = -4439545507908516097L;
  private final String msg;
  private final int code;

  @Builder
  public DiaryJpaException(String msg, int code) {
    super(msg);
    this.msg = msg;
    this.code = code;
  }
}
