package com.adrianm.random_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.adrianm.model.OutboxModelListener;
import org.adrianm.model.annotations.OutboxTopic;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({ OutboxModelListener.class })
@OutboxTopic(value = "user-topic")
@Table(name = "tbl_user")
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "tbl_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @Column
    private String name;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;
}
