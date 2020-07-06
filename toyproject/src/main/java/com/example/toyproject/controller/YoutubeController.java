package com.example.toyproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.toyproject.Entity.YouTubeVideoInfo;
import com.example.toyproject.Entity.YoutubeChannelInfo;
import com.example.toyproject.Entity.YoutubeVideoStatistics;
import com.example.toyproject.Service.YoutubeApiService;
import com.example.toyproject.Service.YoutubeChannelService;
import com.example.toyproject.Service.YoutubeVideoInfoService;
import com.example.toyproject.Service.YoutubeVideoStatService;
import com.example.toyproject.repository.YoutubeChannelRepository;
import com.example.toyproject.repository.YoutubeVideoInfoRepository;
import com.example.toyproject.repository.YoutubeVideoStatisticsRepository;

@RestController
@RequestMapping("youtube")
public class YoutubeController {
 @Autowired
 YoutubeVideoInfoRepository youtubeVideoInfoRepository;
 
 @Autowired
 YoutubeChannelRepository youtubeChannelRepository;
 
 @Autowired
 YoutubeVideoStatisticsRepository youtubeVideoStatisticsRepository;
    @Autowired
    YoutubeApiService youtubeApiService;

    @Autowired
    YoutubeVideoInfoService youtubeVideoInfoService;

    @Autowired
    YoutubeChannelService youtubeChannelService;

    @Autowired
    YoutubeVideoStatService youtubeVideoStatService;

    @GetMapping(value = "crawl/{keyword}/{pageToCrawl}")
    public String crawlVideo(@PathVariable String keyword, @PathVariable long pageToCrawl) {
        return youtubeApiService.crawlYoutubeVideoInfo(keyword,pageToCrawl);
    }

    @GetMapping
    public List<YouTubeVideoInfo> getAll(){
    	
        return youtubeVideoInfoService.getAll();
    }

    @GetMapping(value = "{id}")
    public YouTubeVideoInfo getOne(@PathVariable long id){
    	
    	
        return youtubeVideoInfoService.get(id);
    }

    @GetMapping(value = "channel")
    public List<YoutubeChannelInfo> getAllChannel(){
        return youtubeChannelService.getAll();
    }

    @GetMapping(value = "channel/{id}")
    public YoutubeChannelInfo getChannel(@PathVariable long id){
        return youtubeChannelService.get(id);
    }

    @GetMapping(value = "stat")
    public List<YoutubeVideoStatistics> getAllstat(){
        return youtubeVideoStatService.getAll();
    }

    @GetMapping(value = "stat/{id}")
    public YoutubeVideoStatistics getStats(@PathVariable long id){
        return youtubeVideoStatService.get(id);
    }
   
    	
		
    	
    
    
    

}
