package com.example.shorter.web;

import java.io.IOException;

public interface TinyUrlService {

    String getShortUrl(String url) throws IOException;

    String fetchCompleteUrl(String shortUrl) throws IOException;

}
