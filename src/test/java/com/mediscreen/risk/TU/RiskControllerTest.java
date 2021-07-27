package com.mediscreen.risk.TU;


import com.mediscreen.risk.DTO.RiskLevelDTO;
import com.mediscreen.risk.service.PatientRiskService;
import com.mediscreen.risk.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RiskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientRiskService patientRiskService;


    @Test
    public void getPatientRiskLevel() throws Exception{

        when(patientRiskService.getPatientRisk(any())).thenReturn("None");

        mockMvc.perform((get("/asses/id/1")))
                .andExpect(status().isOk());
    }

    @Test
    public void getPatientFamilyRiskLevel() throws Exception{

        RiskLevelDTO riskLevelDTO = new RiskLevelDTO(1,"None");
        RiskLevelDTO riskLevelDTO1 = new RiskLevelDTO(2,"In Danger");

        List<RiskLevelDTO> riskLevelDTOList = Arrays.asList(riskLevelDTO,riskLevelDTO1);

        when(patientRiskService.getFamilyRiskLevel(any())).thenReturn(riskLevelDTOList);

        mockMvc.perform((get("/asses/family/test")))
                .andExpect(status().isOk());
    }
}
