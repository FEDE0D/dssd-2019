package com.dssd.grupo18.videoconf;

import com.dssd.grupo18.videoconf.service.BonitaService;
import org.bonitasoft.engine.bpm.flownode.ActivityInstance;
import org.bonitasoft.engine.bpm.flownode.ActivityInstanceNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessDefinitionNotFoundException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.bpm.process.ProcessInstance;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.exception.UpdateException;
import org.bonitasoft.engine.identity.CustomUserInfo;
import org.bonitasoft.engine.identity.User;
import org.bonitasoft.engine.identity.UserMembership;
import org.bonitasoft.engine.identity.UserNotFoundException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoconfApplicationTests {

    @Autowired
    private BonitaService bonitaService;

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

}
