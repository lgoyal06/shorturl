package com.example.shorter.web;

import java.io.IOException;

public interface DBOperations {

    String save(String completeUrl) throws IOException;

    String fetchOriginalUrl(String shortUrl) throws IOException;


}
