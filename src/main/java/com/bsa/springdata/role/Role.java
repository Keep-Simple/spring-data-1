package com.bsa.springdata.role;

import com.bsa.springdata.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "UUID") @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String code;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
