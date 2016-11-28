package net.topikachu.auth0.v1.signUp;

import com.google.common.io.ByteStreams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by gongy on 2016/11/28.
 */
@RunWith(SpringRunner.class)
@RestClientTest({SignUpServiceTest.class})
@AutoConfigureWebClient(registerRestTemplate = true)
public class SignUpServiceTest {
    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private SignUpService signUpService;
    @Before
    public void setUp() throws Exception {
        this.server.reset();
    }
    @Test
    public void signUp() throws Exception {
        this.server.expect(requestTo("https://gongyi.auth0.com/dbconnections/signup"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess(getClassPathResource("auth0Response.json"),
                        MediaType.APPLICATION_JSON));
        Auth0Payload auth0Payload=new Auth0Payload();
        auth0Payload.setClientId("clientId1");
        auth0Payload.setEmail("sb@sw.com");
        auth0Payload.setPassword("password1");
        Auth0Response response = signUpService.signUp(auth0Payload);
        assertThat(response.getEmail()).isEqualTo("sb@sw.com");
        assertThat(response.getId()).isEqualTo("583bad4d850fdd9b633b5f01");
    }

    private byte[] getClassPathResource(String s) throws IOException {

        InputStream stream = this.getClass().getResourceAsStream(s);
        return ByteStreams.toByteArray(stream);
    }


}