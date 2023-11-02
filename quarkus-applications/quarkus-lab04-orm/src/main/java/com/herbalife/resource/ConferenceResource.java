package com.herbalife.resource;

import com.herbalife.dto.TopicDto;
import com.herbalife.entity.Topic;
import com.herbalife.service.ConferenceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/conference")
public class ConferenceResource {
    @Inject
    private ConferenceService conferenceService;

    @GET
    @Path("/topics")
    public List<Topic> getAllTopics() {
        return conferenceService.getAllTopics();
    }

    @POST
    @Path("/topics")
    public Topic addTopic(TopicDto topicDto) {
        return conferenceService.addTopic(topicDto.title(), topicDto.duration());
    }
    
    @DELETE
    @Path("/topics")
    public void deleteTopic(@FormParam("title") String title) {
        conferenceService.deleteTopic(title);
    }
}
