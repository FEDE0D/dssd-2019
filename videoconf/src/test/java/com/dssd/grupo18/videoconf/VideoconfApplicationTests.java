package com.dssd.grupo18.videoconf;

import com.dssd.grupo18.videoconf.service.BonitaService;
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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoconfApplicationTests {

    @Autowired
    private BonitaService bonitaService;

    @Test
    public void userTest() throws UserNotFoundException {
        User user = this.bonitaService.getUser(201L);
        List<UserMembership> userMemberships = this.bonitaService.getUserMembership(201L);
        List<CustomUserInfo> customUserInfo = this.bonitaService.getCustomUserData(201L);

        Assert.assertEquals("Luis", user.getFirstName());
        Assert.assertEquals("member", userMemberships.get(0).getRoleName());
        Assert.assertEquals("Administrativo", userMemberships.get(0).getGroupName());
        Assert.assertEquals("31793935", customUserInfo.get(0).getValue());
    }

    @Test
    public void activityTest() throws ActivityInstanceNotFoundException, UserNotFoundException, ProcessDefinitionNotFoundException, ProcessExecutionException, ProcessActivationException, UpdateException {
        ProcessInstance processInstance = this.bonitaService.startProcess(201L, 8898186255584386231L);
        List<ActivityInstance> activityInstances = this.bonitaService.getActivities(processInstance.getId());

        Assert.assertEquals("Inciar Solicitud", activityInstances.get(0).getDisplayName());

        this.bonitaService.completeActivity(activityInstances.get(0).getId());

        activityInstances = this.bonitaService.getActivities(processInstance.getId());

        Assert.assertEquals("Solicitar Dia y Ubicacion WS-Catedra", activityInstances.get(0).getDisplayName());
    }

}
