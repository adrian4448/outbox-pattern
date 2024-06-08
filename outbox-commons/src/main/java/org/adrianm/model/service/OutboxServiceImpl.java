package org.adrianm.model.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.adrianm.model.Outbox;
import org.adrianm.model.repository.OutboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
