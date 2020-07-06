package com.example.toyproject.Service;


import java.util.List;

import com.example.toyproject.Entity.YouTubeVideoInfo;

public interface YoutubeVideoInfoService {
    void save(YouTubeVideoInfo videoInfo);
    void update(YouTubeVideoInfo videoInfo);
    YouTubeVideoInfo getByVideoId(String videoId);
    YouTubeVideoInfo get(long id);
    List<YouTubeVideoInfo> getAll();
}
