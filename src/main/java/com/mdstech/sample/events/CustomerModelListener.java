package com.mdstech.sample.events;

import com.mdstech.sample.domain.Customer;
import com.mdstech.sample.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelListener extends AbstractMongoEventListener<Customer> {

    private final SequenceGeneratorService sequenceGeneratorService;


    @Autowired
    public CustomerModelListener(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        event.getSource().setId(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME));
    }
}
