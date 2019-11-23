package com.dssd.grupo18.videoconf.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dssd.grupo18.videoconf.model.Solicitud;

@Service
public class SolicitudService {

    @Autowired
    BonitaService bonitaService;

    /**
     * Creates a new Solicitud and stores it on the DB
     * Also it will send this data to Bonita and continue on with the process
     *
     * @param activityInstanceId
     * @param nroCausa
     * @param motivo
     * @param solicitanteId
     * @param unidadId
     * @param fecha
     * @param hora
     * @param juezId
     * @param internoId
     * @param abogadoId
     * @param procuradorId
     * @return
     */
    public Solicitud create(long activityInstanceId, long nroCausa, String motivo, long solicitanteId, long unidadId,
        String fecha, String hora, long juezId, long internoId, long abogadoId, long procuradorId) throws UpdateException,
        UserTaskNotFoundException, ContractViolationException, FlowNodeExecutionException, UserNotFoundException {

        // TODO save to DB
        Solicitud solicitud = new Solicitud();
        solicitud.setId(88L);

        List<UserMembership> userMemberships = this.bonitaService.getUserMembership(solicitanteId);
        List<CustomUserInfo> userInfo = this.bonitaService.getCustomUserData(solicitanteId);

        Map<String, Serializable> variables = new HashMap<>();
        variables.put("confirmacion", true);
        variables.put("resultadowscatedra", true);
        variables.put("schedule", "");
        variables.put("solicitudFecha", fecha);
        variables.put("solicitudHora", hora);
        variables.put("solicitudUnidad", String.valueOf(unidadId));
        variables.put("userDni", userInfo.stream().filter(info -> info.getDefinition().getName().equalsIgnoreCase("dni"))
            .findFirst().get().getValue());
        variables.put("userIdRol", String.valueOf(userMemberships.get(0).getRoleId()));

        this.bonitaService.setActivityVariables(activityInstanceId, variables);
        this.bonitaService.setCaseVariable(activityInstanceId,
            BonitaService.converToInput("idsolicitudInput.idsolicitud", solicitud.getId().intValue()));

        return solicitud;
    }
}
