package com.mm.boot.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.debug("Simple runner is executed.");
        // write some code.
    }
}
