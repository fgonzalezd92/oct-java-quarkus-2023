package com.herbalife;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

@ApplicationScoped
public class BookRepository implements PanacheMongoRepositoryBase<Book, ObjectId> {
}
