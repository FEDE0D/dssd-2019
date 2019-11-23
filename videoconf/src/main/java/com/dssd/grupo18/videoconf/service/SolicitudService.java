package com.dssd.grupo18.videoconf.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.session.APISession;
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
     *
     * @param apiSession
     * @param activityInstanceId
     * @param nroCausa
     * @param motivo
     * @param unidadId
     * @param fecha
     * @param hora
     * @param juezId
     * @param internoId
     * @param abogadoId
     * @param procuradorId
     * @return
     */
    public Solicitud create(APISession apiSession, long activityInstanceId, long nroCausa, String motivo, long unidadId,
        String fecha, String hora, long juezId, long internoId, long abogadoId, long procuradorId)
        throws UpdateException, UserTaskNotFoundException, ContractViolationException, FlowNodeExecutionException,
        UserNotFoundException, BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException {

        // TODO save to DB
        Solicitud solicitud = new Solicitud();
        solicitud.setId(88L);

        List<UserMembership> userMemberships = this.bonitaService.getUserMembership(apiSession.getUserId());
        List<CustomUserInfo> userInfo = this.bonitaService.getCustomUserData(apiSession.getUserId());

        Map<String, Serializable> variables = new HashMap<>();
        variables.put("confirmacion", true);
        variables.put("resultadowscatedra", true);
        variables.put("schedule", "");
        variables.put("solicitudFecha", fecha);
        variables.put("solicitudHora", hora);
        variables.put("solicitudUnidad", String.valueOf(unidadId));
        String dni = userInfo.stream().filter(info -> info.getDefinition().getName().equalsIgnoreCase("dni")).findFirst()
            .get().getValue();
        variables.put("userDni", dni != null ? dni : "0");
        variables.put("userIdRol", String.valueOf(userMemberships.get(0).getRoleId()));

        this.bonitaService.setActivityVariables(apiSession, activityInstanceId, variables);
        this.bonitaService.setCaseVariable(apiSession, activityInstanceId,
            BonitaService.converToInput("idsolicitudInput.idsolicitud", solicitud.getId().intValue()));

        return solicitud;
    }
}
