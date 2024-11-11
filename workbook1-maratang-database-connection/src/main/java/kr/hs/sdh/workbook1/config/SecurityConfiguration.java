package kr.hs.sdh.workbook1.config;

import kr.hs.sdh.workbook1.entity.Account;
import kr.hs.sdh.workbook1.entity.Member;
import kr.hs.sdh.workbook1.entity.Role;
import kr.hs.sdh.workbook1.provider.AccountAuthenticationProvider;
import kr.hs.sdh.workbook1.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SecurityConfiguration {

    private final LoginService loginService;

    public SecurityConfiguration(LoginService loginService) {
        this.loginService = loginService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authenticationProvider(this.accountAuthenticationProvider())
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/lotteria-example").authenticated()
                        .requestMatchers("/login").anonymous()
                        .requestMatchers("/fonts/**", "/images/**", "/styles/**", "/scripts/**").permitAll().anyRequest().authenticated()
                )
                .formLogin(config -> config
                        .loginPage("/login")
                        .loginProcessingUrl("/login-processing")
                        .defaultSuccessUrl("/lotteria-example")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .failureHandler((request, response, exception) -> {
                            exception.printStackTrace();
                            response.sendRedirect("/login");
                        })
                )
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.contentEquals(rawPassword);
            }

        };

    }

    @Bean
    AuthenticationProvider accountAuthenticationProvider() {
        AccountAuthenticationProvider accountAuthenticationProvider = new AccountAuthenticationProvider();

        accountAuthenticationProvider.setUserDetailsService(id -> {
            final Account account = this.loginService.getMember(id);

            if (id.isEmpty() || account == null) {
                final String message = "%s 아이디를 가진 사용자를 찾을 수 없습니다.".formatted(id);
                throw new UsernameNotFoundException(message);
            }

            Set<Role> roles = this.loginService.getRoles(id);
            String[] roleCode = new String[roles.size()];
            int index = 0;

            for (Role role : roles) {
                roleCode[index] = role.getCode();
            }

            return User.withUsername(account.getId())
                    .password(account.getPassword())
                    .roles(roleCode)
                    .build();
        });
        
        accountAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());

        return accountAuthenticationProvider;
    }
}