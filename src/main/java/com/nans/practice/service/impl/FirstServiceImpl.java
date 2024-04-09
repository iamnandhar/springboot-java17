package com.nans.practice.service.impl;

import com.nans.practice.service.FirstService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("firstService")
@Slf4j
public class FirstServiceImpl implements FirstService {

    @Override
    public void firstMethod() {
        log.info("hi within method");
    }
}
