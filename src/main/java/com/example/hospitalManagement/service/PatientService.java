package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){
        Patient p1=patientRepository.findById(1L).orElseThrow();
        Patient p2=patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 +" "+p2);
    }
    @Transactional
    public void deletePatient(Long patientid){
        patientRepository.findById(patientid).orElseThrow();
        patientRepository.deleteById(patientid);

    }
}
