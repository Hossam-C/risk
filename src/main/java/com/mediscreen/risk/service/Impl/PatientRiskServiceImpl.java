package com.mediscreen.risk.service.Impl;


import com.mediscreen.risk.DTO.NotesDTO;
import com.mediscreen.risk.DTO.PatientDTO;
import com.mediscreen.risk.DTO.RiskLevelDTO;
import com.mediscreen.risk.service.NotesService;
import com.mediscreen.risk.service.PatientRiskService;
import com.mediscreen.risk.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PatientRiskServiceImpl implements PatientRiskService {

    private List<String> wordTrigger = Arrays.asList("Hémoglobine A1C","Microalbumine","Taille","Poids","Fumeur","Anormal", "Cholestérol","Vertige","Rechute","Réaction","Anticorps");

    @Autowired
    private PatientService patientService;

    @Autowired
    private NotesService notesService;

    @Override
    public String getPatientRisk(Integer patientId) {

        PatientDTO patientDTO = patientService.getPatient(patientId);

        int patientAge = getAge(patientDTO.getDateDeNaissance());

        String genre = patientDTO.getGenre();

        int numberOfTriggers = 0;

        if ( patientDTO !=null){

            List<NotesDTO> notesDTOList = notesService.getNotesByPatientId(patientId);

            for (NotesDTO notesDTO :notesDTOList){

                numberOfTriggers = numberOfTriggers + getNumberOfTriggers(notesDTO);
            }

        }

        String riskLevel = "None";

        if (numberOfTriggers < 2) {
            riskLevel = "None";
        } else if (numberOfTriggers < 6 && patientAge > 30) {
            riskLevel = "Borderline";
        } else if (numberOfTriggers < 3 && patientAge <= 30) {
            riskLevel = "Borderline";
        } else if (numberOfTriggers < 4 && patientAge <= 30) {
            riskLevel = "Borderline";
        } else if (numberOfTriggers < 5 && patientAge <= 30 && genre.contains("H")) {
            riskLevel = "In Danger";
        } else if (numberOfTriggers < 7 && patientAge <= 30 && genre.contains("F")) {
            riskLevel = "In Danger";
        } else if (numberOfTriggers < 8 && patientAge > 30) {
            riskLevel = "In Danger";
        } else {
            riskLevel = "Early onset";
        }

        return riskLevel;
    }


    @Override
    public List<RiskLevelDTO> getFamilyRiskLevel(String name){

        List<PatientDTO> patientDTOList = patientService.getPatientsByName(name);

        List<RiskLevelDTO> riskLevelDTOList = new ArrayList<>();

        for (PatientDTO patientDTO : patientDTOList){

            RiskLevelDTO riskLevelDTO = new RiskLevelDTO();
            String risk= getPatientRisk(patientDTO.getId());

            riskLevelDTO.setPatientId(patientDTO.getId());
            riskLevelDTO.setRiskLevel(risk);
            riskLevelDTOList.add(riskLevelDTO);

        }

        return riskLevelDTOList;

    }

    private int getAge(LocalDate birthdate) {
        LocalDate now = LocalDate.now(ZoneId.of("Europe/Paris"));
        return Period.between(birthdate, now).getYears();
    }

    private int getNumberOfTriggers(NotesDTO notesDTO){
        int triggers = 0;

        for (String t : wordTrigger)
        {
            if (notesDTO.getPracticionerNotes().toLowerCase().contains(t.toLowerCase())){
                triggers += 1;
            }
        }
        return triggers;
    }


}
