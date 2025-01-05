package by.svyat.base.spring.security.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.zaxxer.hikari.HikariConfig;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "by.svyat.base.spring.security")
@EnableWebMvc
public class MyConfig {

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver(){{
            setPrefix("/WEB-INF/view/");
            setSuffix(".jsp");
        }};
    }

    @Bean
    public DataSource dataSource(DatabaseProperties properties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.dbUrl);
        config.setUsername(properties.dbUsername);
        config.setPassword(properties.dbPassword);
        config.setDriverClassName(properties.dbDriver);

        // Настройки пула соединений
        config.setMaximumPoolSize(properties.maxPoolSize);
        config.setMinimumIdle(properties.minIdle);
        config.setIdleTimeout(properties.idleTimeout);
        config.setMaxLifetime(properties.maxLifetime);

        return new HikariDataSource(config);
    }
}
