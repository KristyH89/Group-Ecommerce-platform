package com.manjula.ecommerceplatform.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    @Size(max = 100)
    private String lastName;

    @Column(nullable = false, unique = true, length = 150)
    @Email
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false
    )
    @JoinColumn(
            name = "address_id",
            nullable = false
    )
    private Address address;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "profile_id")
    private UserProfile profile;

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();
}
