package cab.example.springcoretechnologies.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class InMemoryConfig {
    private final PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager()
    {
        UserDetails user= User.withUsername("user")
                .password(passwordEncoder.encode("123"))
                .roles("USER")
                .build();
        UserDetails admin=User.withUsername("admin")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN", "USER")
                .build();
        UserDetails customer=User.withUsername("customer")
                .password(passwordEncoder.encode("123456"))
                .roles("CUSTOMER")
                .build();


        return  new InMemoryUserDetailsManager(user,admin,customer);


    }

}
