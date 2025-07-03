package cab.example.springcoretechnologies.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      //Lamda Expression
        httpSecurity.authorizeHttpRequests(
                auth->auth.requestMatchers("/access").permitAll()
                        .requestMatchers("/user").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
        ).formLogin(formlogin->
                formlogin.defaultSuccessUrl("/access")
                );
                //.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
