package org.adrianm.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OutboxEvent extends ApplicationEvent {
    private String topic;
    private String messageContent;

    public OutboxEvent(Object source, String topic, String messageContent) {
        super(source);
        this.topic = topic;
        this.messageContent = messageContent;
    }
}
