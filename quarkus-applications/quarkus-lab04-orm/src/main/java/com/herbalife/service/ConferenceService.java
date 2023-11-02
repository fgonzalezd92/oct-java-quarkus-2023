package com.herbalife.service;

import com.herbalife.entity.Topic;
import com.herbalife.exception.TopicAlreadyExistsException;
import com.herbalife.exception.TopicNotFoundException;
import com.herbalife.repository.TopicRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ConferenceService {
    @Inject
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.listAll();
    }

    @Transactional
    public Topic addTopic(String title, int duration) {
        boolean topicExists = topicRepository.hasTopicWithTitle(title);
        if(topicExists) {
            throw new TopicAlreadyExistsException(title);
        }
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setDuration(duration);
        topicRepository.persist(topic);
        return topic;
    }

    @Transactional
    public void deleteTopic(String title) {
        Optional<Topic> optionalTopic = topicRepository.findByTitle(title);
        if(optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topicRepository.delete(topic);
        } else {
            throw new TopicNotFoundException(title);
        }

    }
}
