package com.traveldiary.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diary_data")
public class DiaryData {

    @Id
    private Long id;
}