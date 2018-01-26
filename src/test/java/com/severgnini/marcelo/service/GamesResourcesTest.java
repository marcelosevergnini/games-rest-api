package com.severgnini.marcelo.service;


import com.severgnini.marcelo.api.framework.config.JerseyConfig;
import com.severgnini.marcelo.api.framework.config.TestConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertTrue;


public class GamesResourcesTest extends JerseyTest {

    public static final String ASSERT_SERVICE_RUNNING_BODY = "Hello World, Working fine!!";

    private static final String RESOURCE_URL = "/games/";

    @Override
    protected Application configure() {
       ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
       return new JerseyConfig().property("contextConfig", context);
    }

    @Test
    public void serviceWorkingTest() {

        Response response  = target(RESOURCE_URL + "up").request().get(Response.class);
        response.getLocation();
        assertTrue("The Response Should be " + ASSERT_SERVICE_RUNNING_BODY, ASSERT_SERVICE_RUNNING_BODY.equals(response.readEntity(String.class)));

    }


}
