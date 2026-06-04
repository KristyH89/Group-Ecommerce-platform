package com.lexicon.ecommerceplatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(max = 100)
    private String nickname;

    @Column(name = "phone_number", nullable = false, length = 100)
    @Size(max = 100)
    private String phoneNumber;

    @Column(length = 500)
    private String bio;

    @OneToOne(mappedBy = "profile")
    private Customer customer;
}