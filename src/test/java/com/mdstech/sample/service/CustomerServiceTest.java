package com.mdstech.sample.service;

import com.mdstech.sample.SpringUnitTestCaseHelper;
import com.mdstech.sample.domain.Customer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class CustomerServiceTest extends SpringUnitTestCaseHelper {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testCRUD() {
        List<Customer> customers = customerService.findByLastName("Smith");
        assertThat(customers, is(notNullValue()));
        Customer customer1 = customerService.save(new Customer("test", "test1"));
        assertThat(customer1.getId(), is(notNullValue()));
    }

}
