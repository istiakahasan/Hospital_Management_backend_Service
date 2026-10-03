package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.dto.BloodGroupStatus;
import com.example.hospitalManagement.dto.CPatientInfo;
import com.example.hospitalManagement.dto.PatientInfo;
import com.example.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

   @Query("select p.id as id,p.name as name ,p.email as email from Patient p")
    List<PatientInfo> getAllPatinentInfo();
    @Query("select new com.example.hospitalManagement.dto.CPatientInfo(p.id,p.name) "+ "from Patient p")
   List<CPatientInfo> getAllPatientsInfoConcrete();
    @Query("select new com.example.hospitalManagement.dto.BloodGroupStatus(p.bloodGroup,"+"COUNT(p))from Patient p group by p.bloodGroup order by COUNT(p) ")
    List<BloodGroupStatus> getBloodGroupStatus();
    @Query("select p from patient p LEFT JOIN FETCH p.appointments")
    List<Patient> getAllPatintsWithAppointments();
    
}
