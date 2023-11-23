package com.herbalife.resource;

import com.herbalife.service.PalindromeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/word")
public class WordResource {

    @Inject
    private PalindromeService palindromeService;
    @GET
    @Path("/{word}")
    public String checkPalindrome(@PathParam("word") String word) throws URISyntaxException, IOException, InterruptedException {
        boolean result = palindromeService.isPalindrome(word);
        if (result) {
            return word + " is a palindrome";
        } else {
            return word + " is not a palindrome";
        }
    }
}
