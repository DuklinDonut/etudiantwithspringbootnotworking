package open.opendevup;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
     public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN","USER");
    	 auth.inMemoryAuthentication().withUser("prof1").password("123").roles("PROF");
    	 auth.inMemoryAuthentication().withUser("et1").password("123").roles("ETUDIANT");
    	 auth.inMemoryAuthentication().withUser("sco1").password("123").roles("SCOLARITE");
    	 
     }
     
     @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	     .authorizeRequests()
    	                .anyRequest()
    	                      .authenticated()
    	                             .and()
    	                               .formLogin()
    	                                   .loginPage("/login")
    	                                        .permitAll();
    }
}
