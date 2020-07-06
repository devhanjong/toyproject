package com.example.toyproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.toyproject.Entity.CrawlingInfo;
import com.example.toyproject.repository.CrawlingInfoRepository;

@Service
public class CrawlingInfoServiceImpl implements  CrawlingInfoService {

    @Autowired
    private CrawlingInfoRepository crawlingInfoRepository;

    @Override
    public void save(CrawlingInfo crawlingInfo) {
        crawlingInfoRepository.save(crawlingInfo);
    }

    @Override
    public void update(CrawlingInfo crawlingInfo) {
        crawlingInfoRepository.save(crawlingInfo);
    }

    @Override
    public CrawlingInfo get(long id) {
        return crawlingInfoRepository.getOne(id);
    }

    @Override
    public CrawlingInfo getBySearchKey(String searchKey) {
        return crawlingInfoRepository.findBySearchKey(searchKey);
    }

    @Override
    public List<CrawlingInfo> getAll() {
        return crawlingInfoRepository.findAll();
    }
}
