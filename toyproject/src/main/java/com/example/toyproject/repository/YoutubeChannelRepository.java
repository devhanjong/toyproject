package com.example.toyproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.toyproject.Entity.YoutubeChannelInfo;

@Repository
public interface YoutubeChannelRepository extends JpaRepository<YoutubeChannelInfo,Long> {
    public YoutubeChannelInfo findByChannelId(String channelId);
}
