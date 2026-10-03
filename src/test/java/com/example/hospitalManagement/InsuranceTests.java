package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Appointment;
import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.service.AppointmentService;
import com.example.hospitalManagement.service.InsuranceService;
import com.example.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;
    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder().provider("HDFV Ergo").policyName("HDFC_23G").validUntill(LocalDate.of(2030,1,1)).build();
        var updatedInsurance=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(updatedInsurance);
//        patientService.deletePatient(1L);
        var patient=insuranceService.removeInsuranceToPatient(1L);
        System.out.println(patient);
    }
    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder().
                appointmentTime(LocalDateTime.of(2025,11,1,0,22,0)).appointmentReason("cancer").build();
    var updatedApppointment= appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedApppointment);
        patientService.deletePatient(1L);
    }
}
