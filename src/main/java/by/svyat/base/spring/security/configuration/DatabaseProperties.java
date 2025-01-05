package by.svyat.base.spring.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseProperties {
    @Value("${spring.datasource.url}")
    public String dbUrl;

    @Value("${spring.datasource.username}")
    public String dbUsername;

    @Value("${spring.datasource.password}")
    public String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    public String dbDriver;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    public Integer maxPoolSize;

    @Value("${spring.datasource.hikari.minimum-idle}")
    public Integer minIdle;

    @Value("${spring.datasource.hikari.idle-timeout}")
    public Integer idleTimeout;

    @Value("${spring.datasource.hikari.max-lifetime}")
    public Integer maxLifetime;
}
