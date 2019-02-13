package com.mdstech.sample;

import com.mdstech.sample.config.TestMongoConfig;
import com.mdstech.sample.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestMongoConfig.class})
@TestPropertySource("classpath:application-test.properties")
public class SpringUnitTestCaseHelper {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testContextInitialization() {
        assertThat(customerService, is(notNullValue()));
    }
}
