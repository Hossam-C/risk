package com.mediscreen.risk.service;

import com.mediscreen.risk.DTO.RiskLevelDTO;

import java.util.List;

public interface PatientRiskService {

    public String getPatientRisk(Integer patientId);

    public List<RiskLevelDTO> getFamilyRiskLevel(String name);
}
