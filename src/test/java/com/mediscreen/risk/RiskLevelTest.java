package com.mediscreen.risk;

import com.mediscreen.risk.DTO.NotesDTO;
import com.mediscreen.risk.DTO.PatientDTO;
import com.mediscreen.risk.service.NotesService;
import com.mediscreen.risk.service.PatientRiskService;
import com.mediscreen.risk.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class RiskLevelTest {

    @Autowired
    PatientRiskService patientRiskService;

    @MockBean
    PatientService patientService;

    @MockBean
    NotesService notesService;

    private PatientDTO patientDTO1 = new PatientDTO();
    private PatientDTO patientDTO2 = new PatientDTO();
    private PatientDTO patientDTO3 = new PatientDTO();

    private NotesDTO notesDTO1 = new NotesDTO();
    private NotesDTO notesDTO2 = new NotesDTO();
    private NotesDTO notesDTO3 = new NotesDTO();
    private NotesDTO notesDTO4 = new NotesDTO();
    private NotesDTO notesDTO5 = new NotesDTO();
    private NotesDTO notesDTO6 = new NotesDTO();
    private NotesDTO notesDTO7 = new NotesDTO();
    private NotesDTO notesDTO8 = new NotesDTO();





    @BeforeEach
    public void setup() {

        //Patient H age > 30

        patientDTO1.setId(1);
        patientDTO1.setPrenom("test1");
        patientDTO1.setNom("TEST1");
        patientDTO1.setAdressePostale("1 rue des tests");
        patientDTO1.setNumeroDeTelephone("0605040302");
        LocalDate aujourdhui = LocalDate.now();
        LocalDate birthDate = aujourdhui.minusYears(35L);
        patientDTO1.setDateDeNaissance(birthDate);
        patientDTO1.setGenre("H");

        //Patient F age < 30
        patientDTO2.setId(2);
        patientDTO2.setPrenom("test2");
        patientDTO2.setNom("TEST2");
        patientDTO2.setAdressePostale("2 rue des tests");
        patientDTO2.setNumeroDeTelephone("0605040302");
        LocalDate aujourdhui2 = LocalDate.now();
        LocalDate birthDate2 = aujourdhui2.minusYears(20L);
        patientDTO2.setDateDeNaissance(birthDate2);
        patientDTO2.setGenre("F");

        //Patient H age < 30
        patientDTO3.setId(3);
        patientDTO3.setPrenom("test3");
        patientDTO3.setNom("TEST3");
        patientDTO3.setAdressePostale("3 rue des tests");
        patientDTO3.setNumeroDeTelephone("0605040302");
        LocalDate aujourdhui3 = LocalDate.now();
        LocalDate birthDate3 = aujourdhui3.minusYears(20L);
        patientDTO3.setDateDeNaissance(birthDate3);
        patientDTO3.setGenre("H");

        //Notes
        notesDTO1.setPracticionerNotes("Hémoglobine A1C");
        notesDTO2.setPracticionerNotes("Microalbumine");
        notesDTO3.setPracticionerNotes("Taille");
        notesDTO4.setPracticionerNotes("Poids");
        notesDTO5.setPracticionerNotes("Fumeur");
        notesDTO6.setPracticionerNotes("Anormal");
        notesDTO7.setPracticionerNotes("Cholestérol");
        notesDTO8.setPracticionerNotes("Rechute");






    }

    @Test
    public void getPatientRiskBorderlineNone(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO1);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("None");
    }


    @Test
    public void getPatientRiskBorderline1Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO1);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("Borderline");
    }

    @Test
    public void getPatientRiskBorderline2Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO2);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("Borderline");
    }

    @Test
    public void getPatientRiskBorderline3Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);
        notesDTOList.add(notesDTO3);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO3);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("Borderline");
    }

    @Test
    public void getPatientRiskInDanger1Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);
        notesDTOList.add(notesDTO3);
        notesDTOList.add(notesDTO4);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO3);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("In Danger");
    }

    @Test
    public void getPatientRiskInDanger2Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);
        notesDTOList.add(notesDTO3);
        notesDTOList.add(notesDTO4);
        notesDTOList.add(notesDTO5);
        notesDTOList.add(notesDTO6);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO2);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("In Danger");
    }

    @Test
    public void getPatientRiskInDanger3Test(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);
        notesDTOList.add(notesDTO3);
        notesDTOList.add(notesDTO4);
        notesDTOList.add(notesDTO5);
        notesDTOList.add(notesDTO6);
        notesDTOList.add(notesDTO7);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO1);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("In Danger");
    }

    @Test
    public void getPatientRiskEalyOnsetTest(){

        List<NotesDTO> notesDTOList = new ArrayList<>();
        notesDTOList.add(notesDTO1);
        notesDTOList.add(notesDTO2);
        notesDTOList.add(notesDTO3);
        notesDTOList.add(notesDTO4);
        notesDTOList.add(notesDTO5);
        notesDTOList.add(notesDTO6);
        notesDTOList.add(notesDTO7);
        notesDTOList.add(notesDTO8);

        Mockito.when(patientService.getPatient(any())).thenReturn(patientDTO1);
        Mockito.when(notesService.getNotesByPatientId(any())).thenReturn(notesDTOList);

        assertThat(patientRiskService.getPatientRisk(1)).isEqualTo("Early onset");
    }

    @Test
    public void getFamilyRiskLevel(){

        PatientDTO patientDTO1 = new PatientDTO();
        patientDTO1.setId(1);
        patientDTO1.setPrenom("test1");
        patientDTO1.setNom("TEST1");
        patientDTO1.setAdressePostale("1 rue des tests");
        patientDTO1.setNumeroDeTelephone("0605040302");
        LocalDate aujourdhui = LocalDate.now();
        LocalDate birthDate = aujourdhui.minusYears(35L);
        patientDTO1.setDateDeNaissance(birthDate);
        patientDTO1.setGenre("H");

        NotesDTO notesDTO10 = new NotesDTO();
        notesDTO10.setPatientId(1);
        notesDTO10.setPracticionerNotes("Anormal");

        NotesDTO notesDTO11 = new NotesDTO();
        notesDTO11.setPatientId(1);
        notesDTO11.setPracticionerNotes("Fumeur");

        List<NotesDTO> notesDTOList1 = new ArrayList<>();
        notesDTOList1.add(notesDTO10);
        notesDTOList1.add(notesDTO11);


        PatientDTO patientDTO2 = new PatientDTO();
        patientDTO2.setId(2);
        patientDTO2.setPrenom("test2");
        patientDTO2.setNom("TEST1");
        patientDTO2.setAdressePostale("1 rue des tests");
        patientDTO2.setNumeroDeTelephone("0605040302");
        LocalDate today = LocalDate.now();
        LocalDate birthDate2 = today.minusYears(25L);
        patientDTO2.setDateDeNaissance(birthDate);
        patientDTO2.setGenre("F");

        NotesDTO notesDTO20 = new NotesDTO();
        notesDTO20.setPatientId(2);
        notesDTO20.setPracticionerNotes("Hémoglobine A1C");

        NotesDTO notesDTO21 = new NotesDTO();
        notesDTO21.setPatientId(2);
        notesDTO21.setPracticionerNotes("Fumeur");

        List<NotesDTO> notesDTOList2 = new ArrayList<>();
        notesDTOList2.add(notesDTO20);
        notesDTOList2.add(notesDTO21);

        List<PatientDTO> patientDTOList = new ArrayList<>();
        patientDTOList.add(patientDTO1);
        patientDTOList.add(patientDTO2);

        Mockito.when(patientService.getPatientsByName("TEST1")).thenReturn(patientDTOList);

        Mockito.when(patientService.getPatient(1)).thenReturn(patientDTO1);
        Mockito.when(patientService.getPatient(2)).thenReturn(patientDTO2);


        Mockito.when(notesService.getNotesByPatientId(1)).thenReturn(notesDTOList1);
        Mockito.when(notesService.getNotesByPatientId(2)).thenReturn(notesDTOList2);

        System.out.println(patientRiskService.getFamilyRiskLevel("TEST1"));

        assertThat(patientRiskService.getFamilyRiskLevel("TEST1").get(0).getRiskLevel()).isEqualTo("Borderline");
        assertThat(patientRiskService.getFamilyRiskLevel("TEST1").get(1).getRiskLevel()).isEqualTo("Borderline");

    }

}
