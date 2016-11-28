package net.topikachu.auth0.v1.signUp.controller;

import net.topikachu.auth0.v1.signUp.controller.SignUpController;
import net.topikachu.auth0.v1.signUp.service.SignUpService;
import net.topikachu.auth0.v1.signUp.vo.Auth0Payload;
import net.topikachu.auth0.v1.signUp.vo.Auth0Response;
import net.topikachu.auth0.v1.signUp.vo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


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
        auth0Response.setEmail("sb1@sw.com");
        auth0Response.setEmailVerified(false);
        given(signUpService.signUp(any(User.class))).willReturn(auth0Response);
        String requestContent = "{\n" +
                "  \"email\": \"sb1@sw.com\",\n" +
                "  \"password\": \"password11\"\n" +
                "}";
        String responseContent = "{\n" +
                "  \"email\": \"sb1@sw.com\"\n" +

                "}";
        this.mvc.perform(post("/api/v1/signUp").contentType(MediaType.APPLICATION_JSON).content(requestContent).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(responseContent));
    }
}