package com.dssd.grupo18.videoconf;

import com.dssd.grupo18.videoconf.model.Interno;
import com.dssd.grupo18.videoconf.model.Unidad;
import com.dssd.grupo18.videoconf.service.InternoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoconfApplicationTests {

    @Autowired
    private InternoService internoService;

    @Test
    public void contextLoads() {
        Unidad unidad = new Unidad();
        unidad.setNombre("Nombre");
        unidad.setCoordenadas("coords");
        unidad.setNumeroUnidad(12L);
        unidad.setEmail("em");

        Interno interno = new Interno();
        interno.setNombre("Federico");
        interno.setApellido("Pachuelo");
        interno.setEmailRepresentante("federico@gmail.com");

        interno.setUnidad(unidad);

        this.internoService.save(interno);
        System.out.println(interno.getId());
    }

}
