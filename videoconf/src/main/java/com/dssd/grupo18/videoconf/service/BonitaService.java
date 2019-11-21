package com.dssd.grupo18.videoconf.service;

import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.ContractDataNotFoundException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserMembershipCriterion;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.session.APISession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BonitaService {

    @Autowired
    private APISession apiSession;

    @Autowired
    private ProcessAPI processAPI;

    @Autowired
    private IdentityAPI identityAPI;

    public ProcessInstance startProcess(long userId, long processDefinitionId) throws UserNotFoundException, ProcessDefinitionNotFoundException, ProcessExecutionException, ProcessActivationException {
        return this.processAPI.startProcess(userId, processDefinitionId);
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

    public void setCaseVariable(long caseId, String name, String value) throws UpdateException {
        Map<String, Serializable> values = new HashMap<>();
        values.put(name, value);
        this.processAPI.updateActivityInstanceVariables(caseId, values);
    }

    public void getVariable(long caseId, String name) throws ContractDataNotFoundException {
        this.processAPI.getUserTaskContractVariableValue(caseId, name);
    }

    public User getUser(long userId) throws UserNotFoundException {
        return this.identityAPI.getUser(userId);
    }

    public List<UserMembership> getUserMembership(long userId) {
        return this.identityAPI.getUserMemberships(userId, 0, 10, UserMembershipCriterion.ROLE_NAME_ASC);
    }

    public List<CustomUserInfo> getCustomUserData(long userId) {
        return this.identityAPI.getCustomUserInfo(userId, 0, 10);
    }

}
