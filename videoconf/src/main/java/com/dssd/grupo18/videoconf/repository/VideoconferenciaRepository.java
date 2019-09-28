package com.dssd.grupo18.videoconf.repository;

import com.dssd.grupo18.videoconf.model.Videoconferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoconferenciaRepository extends JpaRepository<Videoconferencia, Long> {
}
