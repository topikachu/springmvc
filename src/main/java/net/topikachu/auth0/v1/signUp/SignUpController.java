package net.topikachu.auth0.v1.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 禕 on 2016/11/27.
 */
@RestController
@RequestMapping("/api/v1/signUp")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> post(@RequestBody User user) {

        Auth0Payload auth0Payload=new Auth0Payload();
        auth0Payload.setClientId("yr8NgRgjqlvsRQzUktsA1aq11C4jF2la");
        auth0Payload.setEmail("yi.gong@hpe.com");
        auth0Payload.setPassword("password1");
        auth0Payload.setConnection("Username-Password-Authentication");

        Auth0Response response= signUpService.signUp(auth0Payload);
        user.setId(response.getId());
        return ResponseEntity.ok(user);

    }


}
