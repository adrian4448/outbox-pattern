package org.adrianm.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrianm.model.annotations.OutboxTopic;
import org.adrianm.model.enums.EventType;
import org.adrianm.model.event.EventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OutboxModelListener {

    private ApplicationEventPublisher publisher;

    @PostPersist
    public void sendPersistEvent(Object model) throws JsonProcessingException {
        sendEvent(model, EventType.CREATE);
    }

    @PostRemove
    public void sendRemoveEvent(Object model) throws JsonProcessingException {
        sendEvent(model, EventType.DELETE);
    }

    @PostUpdate
    public void sendUpdateEvent(Object model) throws JsonProcessingException {
        sendEvent(model, EventType.UPDATE);
    }

    private void sendEvent(Object model, EventType eventType) throws JsonProcessingException {
        String messageContent = new ObjectMapper().writeValueAsString(model);
        String topic = model.getClass().getAnnotation(OutboxTopic.class).value();

        OutboxEvent outboxEvent = new OutboxEvent(this, topic, eventType, messageContent);

        getApplicationEventPublisher().getPublisher().publishEvent(outboxEvent);
    }

    private EventPublisher getApplicationEventPublisher() {
        return AppContextUtil.getBean(EventPublisher.class);
    }
}
