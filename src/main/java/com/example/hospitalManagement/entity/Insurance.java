package com.example.hospitalManagement.entity;

import com.example.hospitalManagement.service.PatientService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 50)
    private String policyName;

    @Column(nullable = false,length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validUntill;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    @ToString.Exclude
    @JsonIgnore
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "insurance")
    @ToString.Exclude
    @JsonIgnore
    private Patient patient;//Inverse site

}
