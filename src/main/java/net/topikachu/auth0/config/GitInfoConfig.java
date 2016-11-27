package net.topikachu.auth0.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.GitInfoContributor;
import org.springframework.boot.actuate.info.InfoPropertiesInfoContributor;
import org.springframework.boot.info.GitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by 禕 on 2016/11/27.
 */
@Configuration
@ComponentScan
@PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true)
public class GitInfoConfig {

    @Bean
    GitInfoContributor getGitInfoContributor(@Value("${git.branch:}") String branch, @Value("${git.commit.id:}") String commitId) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("branch", branch);
        properties.setProperty("commit.id", commitId);


        GitProperties gitProperties = new GitProperties(properties);
        return new GitInfoContributor(gitProperties, InfoPropertiesInfoContributor.Mode.SIMPLE);
    }

}
