package com.bsa.springdata.team;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

// TODO: Map table technologies to this entity
@Data
@Entity
@Table(name = "technologies")
public class Technology {
    @Id
    @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String link;
}
