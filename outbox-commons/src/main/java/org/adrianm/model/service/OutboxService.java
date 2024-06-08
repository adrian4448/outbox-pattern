package org.adrianm.model.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.adrianm.model.Outbox;

public interface OutboxService {
    void createOutboxRegister(Outbox outbox) throws JsonProcessingException;
}
