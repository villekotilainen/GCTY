package gcty.root.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests ( authorize -> authorize
            .requestMatchers ("/","/index/**").permitAll()
            .anyRequest().authenticated()
            )
            .formLogin ( formlogin -> formlogin
                .loginPage("/login")
                .defaultSuccessUrl("/index", true).permitAll()
            )
            .logout (logout -> logout
                .permitAll()
        );

        return http.build();

        }
    }
