package com.example.toyproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyproject.Entity.YouTubeVideoInfo;
import com.example.toyproject.repository.YoutubeVideoInfoRepository;

@Service
public class YoutubeVideoInfoServiceImpl implements YoutubeVideoInfoService {

    @Autowired
    private YoutubeVideoInfoRepository youtubeVideoInfoRepository;

    @Override
    public void save(YouTubeVideoInfo videoInfo) {
        youtubeVideoInfoRepository.save(videoInfo);
    }

    @Override
    public void update(YouTubeVideoInfo videoInfo) {
        youtubeVideoInfoRepository.save(videoInfo);
    }

    @Override
    public YouTubeVideoInfo getByVideoId(String videoId) {
        return youtubeVideoInfoRepository.findByVideoId(videoId);
    }

    @Override
    public YouTubeVideoInfo get(long id) {
        return youtubeVideoInfoRepository.findById(id).get();
    }

    @Override
    public List<YouTubeVideoInfo> getAll() {
        return youtubeVideoInfoRepository.findAll();
    }
}
