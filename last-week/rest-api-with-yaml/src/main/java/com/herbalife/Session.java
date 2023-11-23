package com.herbalife;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;

@ApplicationScoped
@ConfigMapping(prefix = "sessions")
public interface Session {
    Map<Integer, List<String>> topics();
    Map<Integer, List<String>> moreTopics();

    //List<Topic> topicsList();
}
