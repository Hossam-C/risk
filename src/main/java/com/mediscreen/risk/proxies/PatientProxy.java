package com.mediscreen.risk.proxies;

import com.mediscreen.risk.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient" ,  url = "patient:1111")
public interface PatientProxy {

    @GetMapping(value = "/getPatient/{id}")
    PatientDTO getPatient(@PathVariable("id") Integer id);

    @GetMapping(value = "/patientByFamily/{name}")
    List<PatientDTO> getPatientsByName(@PathVariable("name") String name);
}
