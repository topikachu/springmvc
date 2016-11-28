package net.topikachu.auth0.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by gongy on 2016/11/28.
 */
@Configuration
public class ApplicationConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
