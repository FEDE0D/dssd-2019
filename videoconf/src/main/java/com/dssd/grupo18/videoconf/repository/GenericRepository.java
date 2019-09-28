package com.dssd.grupo18.videoconf.repository;

import com.dssd.grupo18.videoconf.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<M extends GenericModel> extends JpaRepository<M, Long> {
}
