package com.example.hospitalManagement.entity;

import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private LocalDate birthDate;

    private String email;
    private String gender;
    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade =CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "Patient_insurance")
    private Insurance insurance;//owning site

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,fetch = FetchType.EAGER)//inverse site
//    @ToString.Exclude
    private Set<Appointment> appointments=new HashSet<>();
}
