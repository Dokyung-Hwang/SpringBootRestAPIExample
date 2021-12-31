package com.dk.bookReservation.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "lend")
public class Lend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant startOn;
    private Instant dueOn;

    @Enumerated(EnumType.ORDINAL)
    private LendStatus status;
}
