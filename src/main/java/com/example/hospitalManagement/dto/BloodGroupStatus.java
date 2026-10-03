package com.example.hospitalManagement.dto;

import com.example.hospitalManagement.entity.type.BloodGroupType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
public class BloodGroupStatus {
    private  final BloodGroupType bloodGroupType;
    private final Long count;

}
