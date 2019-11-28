package com.dssd.videconf;

import com.dssd.videconf.model.Interno;
import com.dssd.videconf.model.Participante;
import com.dssd.videconf.model.Solicitud;
import com.dssd.videconf.model.TipoParticipante;
import com.dssd.videconf.model.Unidad;
import com.dssd.videconf.repository.GenericRepository;
import com.dssd.videconf.service.BonitaService;
import com.dssd.videconf.service.SolicitudService;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoconfApplicationTests {

    @Autowired
    private BonitaService bonitaService;

    @Autowired
    private SolicitudService solicitudService;

    @Test
    public void userTest() throws UserNotFoundException {
        User user = this.bonitaService.getUser("luis");
        List<UserMembership> userMemberships = this.bonitaService.getUserMembership(user.getId());
        List<CustomUserInfo> customUserInfo = this.bonitaService.getCustomUserData(user.getId());

        Assert.assertEquals("Luis", user.getFirstName());
        Assert.assertEquals("member", userMemberships.get(0).getRoleName());
        Assert.assertEquals("Administrativo", userMemberships.get(0).getGroupName());
        Assert.assertEquals("31793935", customUserInfo.get(0).getValue());
    }

    @Test
    public void processTest() throws ActivityInstanceNotFoundException, UserNotFoundException, ProcessDefinitionNotFoundException, ProcessExecutionException, ProcessActivationException, UpdateException, InterruptedException {
        User user = this.bonitaService.getUser("luis");
        long processDefinitionID = this.bonitaService.getSolicitudEntrevistaProcessID();
        ProcessInstance processInstance = this.bonitaService.startProcess(user.getId(), processDefinitionID);
        Thread.sleep(1000);

        List<ActivityInstance> activityInstances = this.bonitaService.getActivities(processInstance.getId());

        Assert.assertEquals("Inciar Solicitud", activityInstances.get(0).getName());

        this.bonitaService.completeActivity(activityInstances.get(0).getId());
        Thread.sleep(1000);

        activityInstances = this.bonitaService.getActivities(processInstance.getId());

        Assert.assertEquals("Solicitar Dia y Ubicacion WS-Catedra", activityInstances.get(0).getName());
    }

    @Test
    public void modelPersistanceTest() {
        Unidad unidad = new Unidad();
        unidad.setNumeroUnidad(999L);
        unidad.setNombre("Unidad 999");
        unidad.setCoordenadas("COORD");
        unidad.setEmail("email");

        TipoParticipante tipo = new TipoParticipante();
        tipo.setTipo("multi");

        Participante participante = new Participante();
        participante.setNombre("Federico");
        participante.setApellido("Pacheco");
        participante.setEmail("f@pacheco.com");
        participante.setTipo(tipo);

        Interno interno = new Interno();
        interno.setUnidad(unidad);
        interno.setNombre("interno");
        interno.setApellido("apellido");
        interno.setEmailRepresentante("email@repre");

        Solicitud solicitud = new Solicitud();
        solicitud.setFecha(new Date(System.currentTimeMillis()));
        solicitud.setHora(Time.valueOf(LocalTime.now()));
        solicitud.setAbogado(participante);
        solicitud.setInterno(interno);
        solicitud.setJuez(participante);
        solicitud.setProcurador(participante);
        solicitud.setSolicitante(participante);
        solicitud.setUnidad(unidad);

        solicitud = this.solicitudService.save(solicitud);

        Assert.assertNotNull(solicitud.getId());
    }

}
