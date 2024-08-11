package org.pictura.sample_chat_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
public class SampleChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleChatApplication.class, args);
    }

}
