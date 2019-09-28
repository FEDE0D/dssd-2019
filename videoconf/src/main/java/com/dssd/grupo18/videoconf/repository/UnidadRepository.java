package com.dssd.grupo18.videoconf.repository;

import com.dssd.grupo18.videoconf.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Long> {

}
