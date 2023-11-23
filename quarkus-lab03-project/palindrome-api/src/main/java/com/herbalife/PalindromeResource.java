package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/palindrome")
public class PalindromeResource {
    @GET
    @Path("/{word}")
    public boolean isPalindrome(@PathParam("word") String word) {
       return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}
