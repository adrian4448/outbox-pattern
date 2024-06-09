package com.adrianm.scheduler_outbox.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.adrianm.model.Outbox;
import org.adrianm.model.service.OutboxService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class OutboxEventSender {

    private final KafkaTemplate kafkaTemplate;
    private final OutboxService outboxService;

    @Transactional
    public void sendEvent(Outbox outbox) {
        var record = new ProducerRecord(outbox.getTopic(), outbox.getMessageContent());
        record.headers().add("event-type", outbox.getEventType().toString().getBytes(StandardCharsets.UTF_8));

        outboxService.setOutboxRecordSend(outbox);
        kafkaTemplate.send(record);
    }

}
