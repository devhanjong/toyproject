package com.example.toyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.Entity.YouTubeVideoInfo;

@Repository
public interface YoutubeVideoInfoRepository extends JpaRepository<YouTubeVideoInfo,Long> {
    YouTubeVideoInfo findByVideoId(String videoId);
}
