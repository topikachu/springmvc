package net.topikachu.auth0.v1.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gongy on 2016/11/28.
 */
@Service
public class SignUpService {
    @Autowired
    private RestTemplate restTemplate;
    public Auth0Response signUp(Auth0Payload auth0Payload){
        ResponseEntity<Auth0Response> response = restTemplate.postForEntity("https://gongyi.auth0.com/dbconnections/signup", auth0Payload, Auth0Response.class);
        return response.getBody();
    }
}
