package org.adrianm.model.repository;

import org.adrianm.model.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<Outbox, String> {
}
