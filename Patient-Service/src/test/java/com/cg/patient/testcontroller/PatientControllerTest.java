package com.cg.patient.testcontroller;




import com.cg.patient.controller.PatientController;

import com.cg.patient.entity.Patient;
import com.cg.patient.service.IPatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Mock
    private IPatientService patientService;

    @InjectMocks
    private PatientController patientController;

    private Patient patient;

    @BeforeEach
    void setUp() {
    	patient = new Patient(3, "Aditi3", "indore");
        
    }
   
    @Test
    void testGetAllPatients() {
        when(patientService.findAllPatient()).thenReturn(Arrays.asList(patient));

        var patients = patientController.getallpatients();
        assertFalse(patients.isEmpty());
        assertEquals(1, patients.size());
        assertEquals("Aditi3", patients.get(0).getPname());
    }
   
   
    @Test
    void testGetPatientByParamId() {
        when(patientService.findPatientByID(1)).thenReturn(Optional.of(patient));

        var result = patientController.getpatientByid(1);
        assertTrue(result.isPresent());
        assertEquals("Aditi3", result.get().getPname());
    }

   

   
    @Test
    void testCreatePatient() {
        when(patientService.createPatient(patient)).thenReturn(patient);

        Patient createdProduct = patientController.createpatient(patient);
        assertNotNull(createdProduct);
        assertEquals("Aditi3", createdProduct.getPname());
    }

    @Test
    void testDeletePatient() {
        doNothing().when(patientService).deleteByIdPatient(1);

        patientController.deletePatient(1);

        verify(patientService, times(1)).deleteByIdPatient(1);
    }

    
//    @Test
//    void testUpdatePatient() throws ResourceNotFound {
//        when(patientService.updatePatient(patient, 3)).thenReturn(patient);
//
//        Patient updatedPatient = patientController.updatepatient(patient);
//        assertNotNull(updatedPatient);
//        assertEquals("Aditi3", updatedPatient.getPname());
//    }

 
    
}