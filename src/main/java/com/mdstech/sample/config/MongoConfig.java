package com.mdstech.sample.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.mdstech.sample.repository")
public class MongoConfig extends AbstractMongoConfiguration
{

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList("com.mdstech.sample.domain");
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "testdb";
    }
}
