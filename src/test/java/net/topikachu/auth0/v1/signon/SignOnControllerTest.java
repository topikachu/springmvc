package net.topikachu.auth0.v1.signon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 禕 on 2016/11/27.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SignOnController.class)
public class SignOnControllerTest {

   // @Autowired
    private MockMvc mvc;
    @Autowired

    private FilterChainProxy springSecurityFilterChain;

    @Autowired

    private WebApplicationContext webApplicationContext;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(springSecurityFilterChain)
                .build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getUser() throws Exception {
        String content = "{\n" +
                "  \"email\": \"sb@sw.com\",\n" +
                "  \"password\": null,\n" +
                "  \"id\": \"id1\"\n" +
                "}";
        this.mvc.perform(get("/api/v1/signOn/id1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(content));
    }
}