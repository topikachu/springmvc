package net.topikachu.auth0.v1.signUp;

import net.topikachu.auth0.v1.signUp.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

/**
 * Created by 禕 on 2016/11/27.
 */
@RestController
@RequestMapping("/api/v1/signUp")
public class SignUpController {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> post(@RequestBody User user) {
        user.setId("id1");

        return ResponseEntity.ok(user);

    }


}
