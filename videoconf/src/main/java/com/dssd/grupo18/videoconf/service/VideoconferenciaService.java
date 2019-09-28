package com.dssd.grupo18.videoconf.service;

import com.dssd.grupo18.videoconf.model.Videoconferencia;
import com.dssd.grupo18.videoconf.repository.VideoconferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoconferenciaService {

    @Autowired
    private VideoconferenciaRepository repository;

    public List<Videoconferencia> list() {
        return this.repository.findAll();
    }

}
