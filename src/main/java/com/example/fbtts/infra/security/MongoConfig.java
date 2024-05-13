package com.example.fbtts.infra.security;

import com.example.fbtts.entity.ObjectIdToLongConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Collections;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Collections.singletonList(new ObjectIdToLongConverter()));
    }
}