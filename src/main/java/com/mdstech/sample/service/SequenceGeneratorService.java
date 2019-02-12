package com.mdstech.sample.service;

import org.springframework.stereotype.Service;

@Service
public interface SequenceGeneratorService {
    Long generateSequence(String seqName);
}
