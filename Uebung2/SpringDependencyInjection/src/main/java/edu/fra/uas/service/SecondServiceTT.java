package edu.fra.uas.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondServiceTT {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SecondServiceTT.class);

    @Autowired
    private CounterService counterService;

    public void doCount() {
        log.info("SecondService: doCount() aufgerufen.");
        counterService.count();
    }
}
