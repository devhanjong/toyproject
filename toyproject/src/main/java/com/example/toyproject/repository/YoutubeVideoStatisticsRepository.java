package com.example.toyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.Entity.YoutubeVideoStatistics;

@Repository
public interface YoutubeVideoStatisticsRepository extends JpaRepository<YoutubeVideoStatistics,Long> {
}
