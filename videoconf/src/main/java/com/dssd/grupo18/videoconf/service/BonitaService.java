package com.dssd.grupo18.videoconf.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceNotFoundException;
import org.bonitasoft.engine.bpm.flownode.FlowNodeExecutionException;
import org.bonitasoft.engine.bpm.flownode.HumanTaskInstance;
import org.bonitasoft.engine.bpm.flownode.UserTaskNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ContractDataNotFoundException;
import org.bonitasoft.engine.exception.NotFoundException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserMembershipCriterion;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BonitaService {

    @Autowired
    private APISession apiSession;

    @Autowired
    private ProcessAPI processAPI;

    @Autowired
    private IdentityAPI identityAPI;

    @Value("${bonita.process.name}")
    private String process;

    @Value("${bonita.process.version}")
    private String processVersion;

    public APISession login(String username, String password)
        throws BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException, LoginException {
        return TenantAPIAccessor.getLoginAPI().login(username, password);
    }

    public ProcessInstance startProcess(long userId, long processDefinitionId) throws UserNotFoundException,
        ProcessDefinitionNotFoundException, ProcessExecutionException, ProcessActivationException {
        return this.processAPI.startProcess(userId, processDefinitionId);
    }

    public HumanTaskInstance getLastHumanTask(long processInstanceId, String taskName) throws NotFoundException {
        return this.processAPI.getLastStateHumanTaskInstance(processInstanceId, taskName);
    }

    public void assignUserTask(long userId, long userTaskId)
        throws UserTaskNotFoundException, FlowNodeExecutionException, ContractViolationException, UpdateException {
        this.processAPI.assignUserTask(userTaskId, userId);
    }

    public long getSolicitudEntrevistaProcessID(String name, String version) throws ProcessDefinitionNotFoundException {
        return this.processAPI.getProcessDefinitionId(name, version);
    }

    public long getSolicitudEntrevistaProcessID() throws ProcessDefinitionNotFoundException {
        return this.getSolicitudEntrevistaProcessID(this.process, this.processVersion);
    }

    public List<ActivityInstance> getActivities(long processInstanceId) {
        return this.processAPI.getActivities(processInstanceId, 0, 10);
    }

    public ActivityInstance getActivity(Long activityId) throws ActivityInstanceNotFoundException {
        return this.processAPI.getActivityInstance(activityId);
    }

    public void completeActivity(Long taskId) throws UpdateException {
        this.processAPI.setActivityStateByName(taskId, "completed");
    }

    public void setActivityVariables(long activityInstanceId, Map<String, Serializable> variables)
        throws UpdateException, BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException {
        this.processAPI.updateActivityInstanceVariables(activityInstanceId, variables);
    }

    public void setCaseVariable(long activityInstanceId, Map<String, Serializable> inputs)
        throws FlowNodeExecutionException, ContractViolationException, UserTaskNotFoundException {
        this.processAPI.executeUserTask(activityInstanceId, inputs);
    }

    public Serializable getVariable(long caseId, String name) throws ContractDataNotFoundException {
        return this.processAPI.getUserTaskContractVariableValue(caseId, name);
    }

    public User getUser(long userId) throws UserNotFoundException {
        return this.identityAPI.getUser(userId);
    }

    public User getUser(String username) throws UserNotFoundException {
        return this.identityAPI.getUserByUserName(username);
    }

    public List<UserMembership> getUserMembership(long userId) {
        return this.identityAPI.getUserMemberships(userId, 0, 10, UserMembershipCriterion.ROLE_NAME_ASC);
    }

    public List<CustomUserInfo> getCustomUserData(long userId) {
        return this.identityAPI.getCustomUserInfo(userId, 0, 10);
    }

    public static Map<String, Serializable> converToInput(String path, Serializable value) {
        Map<String, Serializable> root = new HashMap<>();
        Map<String, Serializable> node = new HashMap<>();
        node.put(path.split("\\.")[1], value);
        root.put(path.split("\\.")[0], (Serializable) node);
        return root;
    }
}
