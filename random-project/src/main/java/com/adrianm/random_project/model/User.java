package com.adrianm.random_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.adrianm.OutboxModelListener;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(OutboxModelListener.class)
@Table(name = "tbl_user")
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "tbl_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    @Column
    private String name;
}
