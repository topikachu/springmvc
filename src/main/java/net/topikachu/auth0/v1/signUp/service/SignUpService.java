package net.topikachu.auth0.v1.signUp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.topikachu.auth0.v1.signUp.exception.UserExistsException;
import net.topikachu.auth0.v1.signUp.vo.Auth0Payload;
import net.topikachu.auth0.v1.signUp.vo.Auth0Response;
import net.topikachu.auth0.v1.signUp.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

/**
 * Created by gongy on 2016/11/28.
 */
@Service
public class SignUpService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    public Auth0Response signUp(User user ) {
        try {
            Auth0Payload auth0Payload = new Auth0Payload();
            auth0Payload.setClientId("yr8NgRgjqlvsRQzUktsA1aq11C4jF2la");
            auth0Payload.setEmail(user.getEmail());
            auth0Payload.setPassword(user.getPassword());
            auth0Payload.setConnection("Username-Password-Authentication");
            ResponseEntity<Auth0Response> response = restTemplate.postForEntity("https://gongyi.auth0.com/dbconnections/signup", auth0Payload, Auth0Response.class);
            return response.getBody();
        } catch (HttpClientErrorException exception) {
            String error = exception.getResponseBodyAsString();
            String code="";
            try {
                Map map=objectMapper.readValue(error,Map.class);
                code= (String) map.get("code");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (code.equals("user_exists")) {
                throw new UserExistsException(user.getEmail(), exception);
            }else{
                throw exception;
            }

        }
    }
}
