package cn.pipipan.eisproject.brokergatewayquery.config;

import cn.pipipan.eisproject.brokergatewayquery.filter.JWTBasicFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/orderBlotters").authenticated()
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTBasicFilter(authenticationManager()));
    }
}
