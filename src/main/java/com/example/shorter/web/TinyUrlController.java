package com.example.shorter.web;

import com.example.shorter.utils.SchemaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TinyUrlController {

    @Autowired
    TinyUrlService tinyUrlService;

    @GetMapping(value = "/get/tinyUrl")
    public String generateTinyUrl(@RequestParam("url") String url, HttpServletRequest httpServletRequest) {
        try {
            return httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/" + httpServletRequest.getContextPath() + "/tinyUrl/" + tinyUrlService.getShortUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping(value = "/tinyUrl/{shortUrl}")
    public void redirectToOriginalPage(@PathVariable("shortUrl") String shortUrl, HttpServletResponse response) {
        try {
            String url = tinyUrlService.fetchCompleteUrl(shortUrl);
            if (SchemaEnum.containsSchemaRegex(url))
                response.sendRedirect(url);
            else
                response.sendRedirect("http://" + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}