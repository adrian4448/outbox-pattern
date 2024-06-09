package org.adrianm.model.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.adrianm.model.Outbox;
import org.adrianm.model.enums.EventType;

import java.util.List;

public interface OutboxService {
    void createOutboxRegister(Outbox outbox) throws JsonProcessingException;
    List<Outbox> getOutboxByEventType(EventType eventType);
    void setOutboxRecordSend(Outbox outbox);
}
