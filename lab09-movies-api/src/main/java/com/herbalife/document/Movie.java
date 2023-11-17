package com.herbalife.document;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "movies", database = "training")
public class Movie extends PanacheMongoEntityBase {
    @BsonId
    private ObjectId id;
    @BsonProperty("title")
    private String title;
    @BsonProperty("language")
    private String language;
    @BsonProperty("actors")
    private String actors;
    @BsonProperty("year")
    private int year;
}
