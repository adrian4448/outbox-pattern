package com.adrianm.scheduler_outbox.scheduler;

import com.adrianm.scheduler_outbox.service.OutboxEventSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.adrianm.model.Outbox;
import org.adrianm.model.enums.EventType;
import org.adrianm.model.service.OutboxService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class OutboxScheduler {

    private final OutboxService outboxService;
    private final OutboxEventSender outboxEventSender;

    @Scheduled(fixedRate = 5000)
    public void sendOutboxCreatedEvent() {
        log.info("OutboxScheduller :: Enviando eventos de criacao");
        List<Outbox> outboxList = outboxService.getOutboxByEventType(EventType.CREATE);

        outboxList.forEach(outbox -> {
            outboxEventSender.sendEvent(outbox);
        });
    }

    @Scheduled(fixedRate = 5000)
    public void sendOutboxDeletedEvent() {
        log.info("OutboxScheduller :: Enviando eventos de delecao");

        List<Outbox> outboxList = outboxService.getOutboxByEventType(EventType.DELETE);

        outboxList.forEach(outbox -> {
            outboxEventSender.sendEvent(outbox);
        });
    }

    @Scheduled(fixedRate = 5000)
    public void sendOutboUpdateEvent() {
        log.info("OutboxScheduller :: Enviando eventos de delecao");

        List<Outbox> outboxList = outboxService.getOutboxByEventType(EventType.UPDATE);

        outboxList.forEach(outbox -> {
            outboxEventSender.sendEvent(outbox);
        });
    }
}
