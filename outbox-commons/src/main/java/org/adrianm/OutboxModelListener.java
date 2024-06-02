package org.adrianm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.PostPersist;

public class OutboxModelListener {

    @PostPersist
    private void sendEvent(Object model) throws JsonProcessingException {
        System.out.println("Enviando evento " + new ObjectMapper().writeValueAsString(model));
    }
}
