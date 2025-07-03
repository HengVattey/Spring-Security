package cab.example.springcoretechnologies.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      //Lamda Expression
        httpSecurity
                .csrf(cs->cs.disable())
                .formLogin(formlogin->
                 formlogin.defaultSuccessUrl("/default")
        ).authorizeHttpRequests(
                auth->auth.requestMatchers("/default").permitAll()
                        .requestMatchers("/user").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/Customer").hasAnyRole("CUSTOMER","USER","ADMIN")
        );
        //.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
