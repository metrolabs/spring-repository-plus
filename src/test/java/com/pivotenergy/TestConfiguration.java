package com.pivotenergy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages="com.pivotenergy")
@EnableJpaRepositories
@EnableJpaAuditing
public class TestConfiguration {
}
