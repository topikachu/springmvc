package net.topikachu.auth0.v1.signUp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 禕 on 2016/11/27.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SignUpController.class)
public class SignUpControllerTest {

     @Autowired
    private MockMvc mvc;

    @MockBean
    private SignUpService signUpService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void singUp() throws Exception {
        Auth0Response auth0Response=new Auth0Response();
        auth0Response.setId("auth0id");
        auth0Response.setEmail("sb@sw.com");
        auth0Response.setEmailVerified(false);
        given(signUpService.signUp(any(Auth0Payload.class))).willReturn(auth0Response);
        String content = "{\n" +
                "  \"email\": \"sb@sw.com\",\n" +
                "  \"password\": \"password1\"\n" +
                "}";
        this.mvc.perform(post("/api/v1/signUp").contentType(MediaType.APPLICATION_JSON).content(content).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(content));
    }
}