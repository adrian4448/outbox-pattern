package org.adrianm.model.event.listener;

import lombok.RequiredArgsConstructor;
import org.adrianm.model.Outbox;
import org.adrianm.model.OutboxEvent;
import org.adrianm.model.service.OutboxServiceImpl;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class OutboxEventListener implements ApplicationListener<OutboxEvent> {
    private final OutboxServiceImpl outboxService;
    @Override
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onApplicationEvent(OutboxEvent event) {
        Outbox outbox = Outbox
                .builder()
                .topic(event.getTopic())
                .messageContent(event.getMessageContent())
                .build();

        outboxService.createOutboxRegister(outbox);
    }
}
