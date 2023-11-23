package com.herbalife.repository;

import com.herbalife.entity.Topic;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class TopicRepository implements PanacheRepositoryBase<Topic, Integer> {
    public boolean hasTopicWithTitle(String title) {
        //select count(*) from topics where title = 'Java'; Native SQL
        //HQL; Query the entity classes and their properties and NOT the tables and columns
        String query = "from Topic t where t.title = ?1"; //select * from topics where title = 'Java';
        long count = count(query, title);
        return count > 0;
    }

    public Optional<Topic> findByTitle(String title) {
        String query = "from Topic t where t.title = ?1";
        return find(query, title).firstResultOptional();
    }
}
