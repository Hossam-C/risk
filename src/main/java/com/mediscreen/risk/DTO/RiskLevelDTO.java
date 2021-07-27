package com.mediscreen.risk.DTO;


import org.springframework.stereotype.Component;

@Component
public class RiskLevelDTO {

    private Integer patientId;

    private String riskLevel;

    public RiskLevelDTO() {
    }

    public RiskLevelDTO(Integer patientId, String riskLevel) {
        this.patientId = patientId;
        this.riskLevel = riskLevel;
    }


    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
