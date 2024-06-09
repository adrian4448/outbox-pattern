package org.adrianm.model;

import lombok.Getter;
import org.adrianm.model.enums.EventType;
import org.springframework.context.ApplicationEvent;

@Getter
public class OutboxEvent extends ApplicationEvent {
    private String topic;
    private String messageContent;
    private EventType eventType;

    public OutboxEvent(Object source, String topic, EventType eventType, String messageContent) {
        super(source);
        this.topic = topic;
        this.eventType = eventType;
        this.messageContent = messageContent;
    }
}
