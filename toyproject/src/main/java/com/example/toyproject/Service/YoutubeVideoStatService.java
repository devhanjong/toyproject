package com.example.toyproject.Service;


import java.util.List;

import com.example.toyproject.Entity.YoutubeVideoStatistics;

public interface YoutubeVideoStatService {
    void save(YoutubeVideoStatistics videoStatistics);
    void update(YoutubeVideoStatistics videoInfo);
    YoutubeVideoStatistics get(long id);
    List<YoutubeVideoStatistics> getAll();
}
