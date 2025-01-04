package by.svyat.base.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("svyat")
                        .password("svyat")
                        .roles("EMPLOYEE")
                        .build()
        );

        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("zaur")
                        .password("zaur")
                        .roles("HR")
                        .build()
        );

        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("nastya")
                        .password("nastya")
                        .roles("MANAGER")
                        .build()
        );

        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("viktor")
                        .password("viktor")
                        .roles("USER")
                        .build()
        );

        return manager;
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
