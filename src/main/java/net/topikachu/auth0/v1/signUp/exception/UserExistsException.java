package net.topikachu.auth0.v1.signUp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gongy on 2016/11/28.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistsException extends  RuntimeException {
    public UserExistsException(String email) {
        this(email,null);
    }

    public UserExistsException(String email, Throwable cause) {
        super("User exists '" + email + "'.",cause);
    }
}
