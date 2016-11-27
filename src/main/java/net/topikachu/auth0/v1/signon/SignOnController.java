package net.topikachu.auth0.v1.signon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;

/**
 * Created by 禕 on 2016/11/27.
 */
@RestController
@RequestMapping("/api/v1/signOn")
public class SignOnController {
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> post(@RequestBody User user) {
        user.setId("id1");
        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable String id) {
        User user = new User();
        user.setEmail("sb@sw.com");
        user.setId("id1");
        return ResponseEntity.ok(user);
    }
}
