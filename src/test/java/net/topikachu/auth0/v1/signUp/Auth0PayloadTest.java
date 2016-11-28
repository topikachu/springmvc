package net.topikachu.auth0.v1.signUp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gongy on 2016/11/28.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class Auth0PayloadTest {


    @Autowired
    private JacksonTester<Auth0Payload> jsonAuth0Payload;
    @Autowired
    private JacksonTester<Auth0Response> jsonAuth0Response;



    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void serializeAuth0PayloadJson() throws Exception {
        Auth0Payload auth0Payload=new Auth0Payload();
        auth0Payload.setClientId("clientId1");
        auth0Payload.setEmail("sb@sw.com");
        auth0Payload.setPassword("password1");
        assertThat(this.jsonAuth0Payload.write(auth0Payload)).isEqualTo("auth0Payload.json");
    }

    @Test
    public void deserializeAuth0ResponseJson() throws Exception {
        Auth0Response auth0Response=new Auth0Response();
        auth0Response.setEmail("sb@sw.com");
        auth0Response.setEmailVerified(false);
        auth0Response.setId("583bad4d850fdd9b633b5f01");
        assertThat(this.jsonAuth0Response.read("auth0Response.json")).isEqualTo(auth0Response);
    }
}
