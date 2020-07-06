package com.example.toyproject.Service;


import java.util.List;

import com.example.toyproject.Entity.YoutubeChannelInfo;

public interface YoutubeChannelService {

    void save(YoutubeChannelInfo channelInfo);
    void update(YoutubeChannelInfo channelInfo);
    YoutubeChannelInfo get(long id);
    YoutubeChannelInfo getByChannelId(String channelId);
    List<YoutubeChannelInfo> getAll();

}
