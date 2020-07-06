package com.example.toyproject.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyproject.Entity.YoutubeVideoStatistics;
import com.example.toyproject.repository.YoutubeVideoStatisticsRepository;

@Service
public class YoutubeVideoStatServiceImpl implements YoutubeVideoStatService {

    @Autowired
    private YoutubeVideoStatisticsRepository youtubeVideoStatisticsRepository;

    @Override
    public void save(YoutubeVideoStatistics videoStatistics) {
        youtubeVideoStatisticsRepository.save(videoStatistics);
    }

    @Override
    public void update(YoutubeVideoStatistics videoStatistics) {
        youtubeVideoStatisticsRepository.save(videoStatistics);
    }

    @Override
    public YoutubeVideoStatistics get(long id) {
        return youtubeVideoStatisticsRepository.findById(id).get();
    }

    @Override
    public List<YoutubeVideoStatistics> getAll() {
        return youtubeVideoStatisticsRepository.findAll();
    }
}
