package com.mediscreen.risk.controller;


import com.mediscreen.risk.DTO.RiskLevelDTO;
import com.mediscreen.risk.service.PatientRiskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiskController {

    private static final Logger logger = LogManager.getLogger(RiskController.class);

    @Autowired
    private PatientRiskService patientRiskService;

    @GetMapping("/asses/id/{patientId}")
    public String getRiskLevel(@PathVariable("patientId") Integer patientId) {

        String riskLevel =  patientRiskService.getPatientRisk(patientId);

        return riskLevel;

    }

    @GetMapping("/asses/family/{familyName}")
    public List<RiskLevelDTO> getRiskLevel(@PathVariable("familyName") String familyName) {

        return patientRiskService.getFamilyRiskLevel(familyName);

    }
}
