package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Map;

@Path("/holiday")
public class HolidayResource {

    @ConfigProperty(name = "topic.name")
    String topicName;

    @ConfigProperty(name = "topic.duration")
    String topicDuration;

    @ConfigProperty(name = "topic.complexity")
    String topicComplexity;

    @Inject
    Session session;

    @GET
    @Path("/topics")
    public List<Topic> getTopics() {
        return null;
    }

    @GET
    @Path("/sessions")
    public Map<Integer, List<String>> getSessions() {
        return session.moreTopics();
    }

    @GET
    @Path("/topic")
    public String getTopic() {
        return "The topic of the day is: " + topicName + ". It will take " + topicDuration + " minutes to cover it. It has a complexity of " + topicComplexity + ".";
    }

    @GET
    public String getHoliday() {
        return "Today is a holiday in Mexico! 🇲🇽 🎉. Because of the Mexican Revolution. ";
    }

}
