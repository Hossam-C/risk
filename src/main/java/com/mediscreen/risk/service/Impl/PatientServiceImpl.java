package com.mediscreen.risk.service.Impl;

import com.mediscreen.risk.DTO.PatientDTO;
import com.mediscreen.risk.proxies.PatientProxy;
import com.mediscreen.risk.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientProxy patientProxy;

    @Override
    public PatientDTO getPatient(Integer patientId) {

        return  patientProxy.getPatient(patientId);
    }

    @Override
    public List<PatientDTO> getPatientsByName(String name){
        return patientProxy.getPatientsByName(name);
    }

}
