package com.mediscreen.risk.proxies;

import com.mediscreen.risk.DTO.NotesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "notes" ,  url = "notes:2222")
public interface NotesProxy {

    @GetMapping(value = "getNotesByPatient/{patientId}")
    List<NotesDTO> getNotesByPatientId(@PathVariable("patientId") Integer patientId);
}
