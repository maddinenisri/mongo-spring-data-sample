package com.mdstech.sample.config;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.mdstech.sample.repository")
@ConditionalOnProperty(name = "inmemory.monogodb.datatbase")
public class TestMongoConfig extends AbstractMongoConfiguration {

    @Value("${inmemory.monogodb.datatbase}")
    private String database;

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList("com.mdstech.sample.domain");
    }

    @Override
    public MongoClient mongoClient() {
        return new Fongo(getDatabaseName()).getMongo();
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
