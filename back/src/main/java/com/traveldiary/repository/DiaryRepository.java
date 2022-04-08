package com.traveldiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.traveldiary.domain.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long>{

}
