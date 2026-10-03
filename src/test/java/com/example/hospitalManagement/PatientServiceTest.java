package com.example.hospitalManagement;


import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.PatientRepository;
import com.example.hospitalManagement.service.PatientService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;


    @Test
    public void testPatient(){
//        List<Patient> patientList=patientRepository.findAll();

//        List<CPatientInfo> patientList=patientRepository.getAllPatientsInfoConcrete();
//        List<BloodGroupStatus> patientList=patientRepository.getBloodGroupStatus();
//        for (var p:patientList){
//            System.out.println(p);
//            patientService.testPatientTransaction();

        List<Patient> patientLists=patientRepository.getAllPatintsWithAppointments();
        for (var p:patientLists){
            System.out.println(p);
        }



        }
    }
