package edu.fra.uas.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

private static final org.slf4j.Logger log = LoggerFactory.getLogger(CounterService.class);
    private int count = 0;

public CounterService(){
    log.info("CounterService: Neue Instanz erstellt.");
}

public int count (){
    this.count++;

    log.info("CounterService: count() aufgerufen. Aktueller Wert: " + this.count);
    return this.count;
}

}
