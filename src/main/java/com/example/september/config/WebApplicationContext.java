package com.example.september.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example.september.config.web",
        "com.example.september.domain.member.api",
})
public class WebApplicationContext {

}
