package com.dssd.grupo18.videoconf.configuration;


import org.bonitasoft.engine.api.ApiAccessType;
import org.bonitasoft.engine.api.IdentityAPI;
import org.bonitasoft.engine.api.LoginAPI;
import org.bonitasoft.engine.api.ProcessAPI;
import org.bonitasoft.engine.api.TenantAPIAccessor;
import org.bonitasoft.engine.api.UserAPI;
import org.bonitasoft.engine.exception.BonitaHomeNotSetException;
import org.bonitasoft.engine.exception.ServerAPIException;
import org.bonitasoft.engine.exception.UnknownAPITypeException;
import org.bonitasoft.engine.platform.LoginException;
import org.bonitasoft.engine.session.APISession;
import org.bonitasoft.engine.session.impl.APISessionImpl;
import org.bonitasoft.engine.util.APITypeManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static org.bonitasoft.engine.api.TenantAPIAccessor.getIdentityAPI;
import static org.bonitasoft.engine.api.TenantAPIAccessor.getProcessAPI;

@Configuration
public class BonitaConfiguration {

    @Value("${bonita.url}")
    private String bonitaURL;

    @Value("${bonita.app}")
    private String bonitaApp;

    @Value("${bonita.user.username}")
    private String username;

    @Value("${bonita.user.password}")
    private String password;

    @Bean
    public APISession getApiSession() throws BonitaHomeNotSetException, ServerAPIException, UnknownAPITypeException, LoginException {
        Map<String, String> settings = new HashMap();
        settings.put("server.url", this.bonitaURL);
        settings.put("application.name", this.bonitaApp);
        APITypeManager.setAPITypeAndParams(ApiAccessType.HTTP, settings);
        LoginAPI loginAPI = TenantAPIAccessor.getLoginAPI();
        return loginAPI.login(this.username, this.password);
    }

    @Bean
    public ProcessAPI getProcessApi() throws LoginException, ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException {
        return getProcessAPI(this.getApiSession());
    }

    @Bean
    public UserAPI getUserApi() throws LoginException, ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException {
        return getIdentityAPI(this.getApiSession());
    }

    @Bean
    public IdentityAPI getIdentifyAPI() throws LoginException, ServerAPIException, BonitaHomeNotSetException, UnknownAPITypeException {
        return getIdentityAPI(this.getApiSession());
    }

}
