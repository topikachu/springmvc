package net.topikachu.auth0.config;


import org.springframework.boot.actuate.info.GitInfoContributor;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 禕 on 2016/11/27.
 */
@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    GitInfoContributor getGitInfoContributor() throws IOException {
        Properties properties = new Properties();
        try (InputStream is = AppConfig.class.getClassLoader().getResourceAsStream("git.properties")) {
            if (is != null) {
                properties.load(is);
            }

        }


        GitProperties gitProperties = new GitProperties(properties);
        return new GitInfoContributor(gitProperties);
    }

}
