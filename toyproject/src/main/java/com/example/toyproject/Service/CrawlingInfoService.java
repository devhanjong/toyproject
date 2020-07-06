package com.example.toyproject.Service;



import java.util.List;

import com.example.toyproject.Entity.CrawlingInfo;

public interface CrawlingInfoService {
    void save(CrawlingInfo crawlingInfo);
    void update(CrawlingInfo crawlingInfo);
    CrawlingInfo get(long id);
    CrawlingInfo getBySearchKey(String searchKey);
    List<CrawlingInfo> getAll();
}
