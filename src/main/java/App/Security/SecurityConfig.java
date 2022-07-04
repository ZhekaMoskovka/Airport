package App.Security;

import App.Service.Impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .antMatchers(HttpMethod.POST, "/passenger").permitAll()
                .antMatchers("/flight/search/borders").permitAll()
                .antMatchers(HttpMethod.DELETE, "/flight", "/route", "/ticket").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/passenger", "/ticket").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/ticket").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE, "/passenger").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic();
    }
}