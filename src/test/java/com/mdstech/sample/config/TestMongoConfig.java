package com.mdstech.sample.config;

//import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
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
//@ConditionalOnProperty(name = "inmemory.monogodb.datatbase")
@ComponentScan(basePackages = {"com.mdstech.sample.service", "com.mdstech.sample.events", "com.mdstech.sample.domain"})
public class TestMongoConfig {

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoDbFactory(mongoClient));
    }

    @Bean
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
        return new SimpleMongoDbFactory(mongoClient, "test");
    }

    @Bean(destroyMethod="shutdown")
    public MongoServer mongoServer() {
        MongoServer mongoServer = new MongoServer(new MemoryBackend());
        mongoServer.bind();
        return mongoServer;
    }

    @Bean(destroyMethod="close")
    public MongoClient mongoClient(MongoServer mongoServer) {
        return new MongoClient(new ServerAddress(mongoServer.getLocalAddress()));
    }

    @Value("${inmemory.monogodb.datatbase}")
    private String database;

//    @Override
//    protected Collection<String> getMappingBasePackages() {
//        return Collections.singletonList("com.mdstech.sample.domain");
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new Fongo(getDatabaseName()).getMongo();
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return database;
//    }
}
