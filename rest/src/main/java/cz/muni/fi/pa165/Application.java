package cz.muni.fi.pa165;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextListener;

import cz.muni.fi.pa165.entity.Account;
import cz.muni.fi.pa165.enums.ERole;
import cz.muni.fi.pa165.sampledata.SampleDataConfiguration;
import cz.muni.fi.pa165.services.AccountService;

/**
 * @author opontes
 */
@SpringBootApplication
@Import(SampleDataConfiguration.class)
@ComponentScan(basePackages = {"cz.muni.fi.pa165.controller", "cz.muni.fi.pa165.facade", "cz.muni.fi.pa165.services", "cz.muni.fi.pa165.dao", "cz.muni.fi.pa165.validation"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(RequestContextListener.class);
    }

    @Bean
    CommandLineRunner init(final AccountService accountService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... arg0) throws Exception {
                accountService.create(new Account("user", "user", ERole.USER));
                accountService.create(new Account("admin", "admin", ERole.ADMIN));
            }
        };
    }

    @Configuration
    class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @SuppressWarnings("SpringJavaAutowiringInspection")
        @Autowired
        AccountService accountService;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService());
        }

        @Bean
        UserDetailsService userDetailsService() {
            return new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    Account account = accountService.getByName(username);
                    if (account != null) {
                        return new User(account.getName(), account.getPassword(), true, true, true, true,
                                AuthorityUtils.createAuthorityList(account.getRole().name()));
                    } else {
                        throw new UsernameNotFoundException("could not find the account '"
                                + username + "'");
                    }
                }
            };
        }
    }

    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final String ADMIN = ERole.ADMIN.name();
        private final String USER = ERole.USER.name();

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().and().authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(ADMIN)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(ADMIN)

                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(ADMIN)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(ADMIN)

                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(ADMIN)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(ADMIN)

                    .antMatchers(HttpMethod.DELETE, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(ADMIN)
                    .antMatchers(HttpMethod.DELETE, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.DELETE, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(ADMIN)
                    .antMatchers(HttpMethod.DELETE, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(ADMIN)

                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(USER)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(USER)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(USER)
                    .antMatchers(HttpMethod.POST, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(USER)

                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(USER)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(USER)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(USER)
                    .antMatchers(HttpMethod.GET, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(USER)

                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_ABILITIES).hasRole(USER)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_GHOSTS).hasRole(USER)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_HAUNTINGS).hasRole(USER)
                    .antMatchers(HttpMethod.PUT, "/pa165" + ApiUris.ROOT_URI_HOUSES).hasRole(USER)

                    .anyRequest().authenticated().and()
                    .csrf().disable();
        }
    }

}
