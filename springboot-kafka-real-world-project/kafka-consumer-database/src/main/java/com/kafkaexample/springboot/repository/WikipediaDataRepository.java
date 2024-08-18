package com.kafkaexample.springboot.repository;

import com.kafkaexample.springboot.entity.WikipediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikipediaDataRepository extends JpaRepository<WikipediaData, Long> {

}
