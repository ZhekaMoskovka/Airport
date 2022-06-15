package App.Security;

import App.Service.Impl.UserDetailsServiceImpl;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Setter(onMethod=@__({@Autowired}))
    private UserDetailsServiceImpl userDetailsService;
    @Setter(onMethod=@__({@Autowired}))
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
                .antMatchers("/registration/").permitAll()
                .antMatchers("/search/flight/borders/").permitAll()
                .antMatchers("/delete/flight/").hasAuthority("ADMIN")
                .antMatchers("/delete/route/").hasAuthority("ADMIN")
                .antMatchers("/passenger/all/").hasAuthority("ADMIN")
                .antMatchers("/buying-tickets/").hasAuthority("USER")
                .antMatchers("/delete/passenger/").hasAuthority("USER")
                .antMatchers("/hello/").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
    }
}