package com.dssd.videconf.repository;

import com.dssd.videconf.model.GenericModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<M extends GenericModel> extends JpaRepository<M, Long> {
}
