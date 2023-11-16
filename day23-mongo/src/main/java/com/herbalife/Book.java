package com.herbalife;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "books", database = "training")
public class Book {
    @BsonId
    private ObjectId id;
    @BsonProperty("title")
    private String title;
    @BsonProperty("author")
    private String author;
    @BsonProperty("price")
    private double price;
}
