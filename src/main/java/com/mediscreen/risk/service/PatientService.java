package com.mediscreen.risk.service;

import com.mediscreen.risk.DTO.PatientDTO;

import java.util.List;

public interface PatientService {

    public PatientDTO getPatient(Integer patienId);


    public List<PatientDTO> getPatientsByName(String name);
}
