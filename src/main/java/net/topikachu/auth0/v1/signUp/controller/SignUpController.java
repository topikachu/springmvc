package net.topikachu.auth0.v1.signUp.controller;

import net.topikachu.auth0.v1.signUp.service.SignUpService;
import net.topikachu.auth0.v1.signUp.vo.Auth0Payload;
import net.topikachu.auth0.v1.signUp.vo.Auth0Response;
import net.topikachu.auth0.v1.signUp.vo.User;
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



        Auth0Response response= signUpService.signUp(user);
        User responseUser=new User();
        responseUser.setId(response.getId());
        responseUser.setEmail(response.getEmail());
        return ResponseEntity.ok(responseUser);

    }


}
