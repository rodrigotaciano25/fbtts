package com.example.fbtts.entity;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ObjectIdToLongConverter implements Converter<ObjectId, Long> {
    @Override
    public Long convert(ObjectId objectId) {
        return objectId.getDate().getTime();
    }
}
