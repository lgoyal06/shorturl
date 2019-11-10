package com.example.shorter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TinyUrlServiceImpl implements TinyUrlService {

    @Autowired
    private DBOperations dbOperations;

    @Override
    public String getShortUrl(String url) throws IOException {
        String shortUrl = dbOperations.save(url);
        return shortUrl;
    }

    @Override
    public String fetchCompleteUrl(String shortUrl) throws IOException {
        return dbOperations.fetchOriginalUrl(shortUrl);
    }
}
