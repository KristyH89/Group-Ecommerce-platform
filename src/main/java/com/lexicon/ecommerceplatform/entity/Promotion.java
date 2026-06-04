package com.lexicon.ecommerceplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @Column(name = "start_date",  nullable = false)
    private LocalDate startDate;


    @Column(name = "end_date",   nullable = false)
    private LocalDate endDate;

}
