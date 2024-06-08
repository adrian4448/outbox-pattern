package org.adrianm.model.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventPublisherConfiguration {

    @Bean
    public EventPublisher eventPublisher(ApplicationEventPublisher eventPublisher) {
        return new EventPublisher(eventPublisher);
    }
}
