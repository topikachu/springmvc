package net.topikachu.auth0.v1.signon;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by 禕 on 2016/11/27.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class UserTest {
    private User user;

    @Autowired
    private JacksonTester<User> json;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setEmail("sb@sw.com");
        user.setPassword("password1");
        user.setId("id1");
        this.user = user;
    }

    @Test
    public void serializeJson() throws Exception {
        assertThat(this.json.write(user)).isEqualTo("user.json");
    }

    @Test
    public void deserializeJson() throws Exception {
        assertThat(this.json.read("user.json")).isEqualTo(this.user);
    }
}
