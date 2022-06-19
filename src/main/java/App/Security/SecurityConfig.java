package App.Security;

import App.Service.Impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsServiceImpl userDetailsService;
    private PasswordEncoder passwordEncoder;
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/passenger/registration", "/flight/search/borders").permitAll()
                .antMatchers("/flight/delete", "/route/delete", "/passenger/all").hasAuthority("ADMIN")
                .antMatchers("/ticket/buying", "/passenger/delete").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
    }
}