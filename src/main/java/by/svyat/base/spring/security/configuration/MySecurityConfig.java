package by.svyat.base.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    DataSource dataSource;

    public MySecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (user) -> user
                        .requestMatchers("/employees_info/**").hasAnyRole("MANAGER", "HR", "EMPLOYEE")
                        .requestMatchers("/manager_info/**").hasRole("MANAGER")
                        .requestMatchers("/hr_info/**").hasRole("HR")
                        .anyRequest().permitAll()
        ).formLogin(Customizer.withDefaults());

        return http.build();
    }
}
