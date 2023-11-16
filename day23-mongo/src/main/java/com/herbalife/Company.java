package com.herbalife;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "companies", database = "training")
public class Company extends PanacheMongoEntityBase {
    @BsonId
    private ObjectId id;
    @BsonProperty("name")
    private String name;
    @BsonProperty("ceo")
    private String ceo;
    @BsonProperty("employee_count")
    private long employeeCount;
}
