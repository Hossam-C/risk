package com.mediscreen.risk.service.Impl;


import com.mediscreen.risk.DTO.NotesDTO;
import com.mediscreen.risk.proxies.NotesProxy;
import com.mediscreen.risk.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesProxy notesProxy;

    @Override
    public List<NotesDTO> getNotesByPatientId(Integer patientId){

        return notesProxy.getNotesByPatientId(patientId);
    }
}
