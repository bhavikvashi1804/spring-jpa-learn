package com.bhavik.jpa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "mail")
@Getter
@Setter
public class MailProperties {

    private String ip;
    private String userName;
    private String subject;

    @Override
    public String toString() {
        return "MailProperties{" +
                "ip='" + ip + '\'' +
                ", userName='" + userName + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
