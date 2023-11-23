package com.herbalife.service;

import com.herbalife.config.PalindromeApiConfig;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class PalindromeService {

    @Inject
    private PalindromeApiConfig palindromeApiConfig;

    private String palindromeApiUrl;

    @PostConstruct
    public void init() {
        palindromeApiUrl = "http://" + palindromeApiConfig.host() + ":" + palindromeApiConfig.port() + "/" + palindromeApiConfig.baseUrl();
    }

    public boolean isPalindrome(String word) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest req = HttpRequest
                .newBuilder(new URI(palindromeApiUrl + "/" + word))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newBuilder().build().send(req, HttpResponse.BodyHandlers.ofString());
        boolean result = Boolean.parseBoolean(response.body());
        return result;
    }
}
