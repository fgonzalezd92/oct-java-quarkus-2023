package com.herbalife.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrainingService {
    public String getInformation(String title) {
        Log.debugv("Title: {0}", title);
        if(title == null || title.isEmpty() || title.equalsIgnoreCase("null")) {
            Log.errorv("Title is null or empty: {0}", title);
            return "Title is null or empty";
        } else {
            Log.infov("Loading information about {0}", title);
            return "This is a training about " + title;
        }

    }
}
