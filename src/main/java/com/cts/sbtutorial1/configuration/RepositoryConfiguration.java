package com.cts.sbtutorial1.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.cts.sbtutorial1.domain"})
@EnableJpaRepositories(basePackages = {"com.cts.sbtutorial1.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
