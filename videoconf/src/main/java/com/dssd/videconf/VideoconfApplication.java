package com.dssd.videconf;

import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.platform.LoginException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideoconfApplication {

    public static void main(String[] args) throws BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException, LoginException {
        SpringApplication.run(VideoconfApplication.class, args);
    }

}
