package org.adrianm.model.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.adrianm.model.Outbox;
import org.adrianm.model.enums.EventType;
import org.adrianm.model.repository.OutboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OutboxServiceImpl implements OutboxService {

    @Autowired
    private OutboxRepository outboxRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createOutboxRegister(Outbox model) {
        outboxRepository.save(model);
    }

    @Override
    public List<Outbox> getOutboxByEventType(EventType eventType) {
        Outbox outboxFilter = Outbox
                .builder()
                .eventType(eventType)
                .eventCreated(false)
                .build();

        return outboxRepository.findAll(Example.of(outboxFilter));
    }

    @Override
    @Transactional
    public void setOutboxRecordSend(Outbox outbox) {
        outbox.eventCreated();
        outboxRepository.save(outbox);
    }
}
