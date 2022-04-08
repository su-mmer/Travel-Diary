package com.traveldiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "diary")
public class Diary {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
