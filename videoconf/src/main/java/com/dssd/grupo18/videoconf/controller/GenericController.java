package com.dssd.grupo18.videoconf.controller;

import com.dssd.grupo18.videoconf.model.GenericModel;
import com.dssd.grupo18.videoconf.repository.GenericRepository;
import com.dssd.grupo18.videoconf.service.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public abstract class GenericController<M extends GenericModel, S extends GenericService<M, GenericRepository<M>>> {

    private GenericService<M, GenericRepository<M>> service;

    public GenericController(GenericService<M, GenericRepository<M>> service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping
    public List<M> findAll() {
        return this.service.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public M getOne(@PathVariable Long id) {
        return this.service.getOne(id);
    }

}
