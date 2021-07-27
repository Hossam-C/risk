package com.mediscreen.risk.service;


import com.mediscreen.risk.DTO.NotesDTO;

import java.util.List;

public interface NotesService {

    public List<NotesDTO> getNotesByPatientId(Integer patientId);
 }
