package com.codestates.main.other.config;

import com.codestates.main.other.filter.JwtAuthenticationFilter;
import com.codestates.main.other.filter.JwtVerificationFilter;
import com.codestates.main.other.handler.MemberAuthenticationFailureHandler;
import com.codestates.main.other.handler.MemberAuthenticationSuccessHandler;
import com.codestates.main.other.jwt.JwtTokenizer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final JwtTokenizer jwtTokenizer;
    private final CorsFilter corsFilter;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class); // BasicAuthenticationFilter 이전에 내가 만든 FirstFilter 적용
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .apply(new CustomDsl()) // 추가
                .and()
                .authorizeHttpRequests(authorize -> authorize  // (3) 추가
                                .antMatchers(HttpMethod.GET, "/member/get").hasRole("USER")
                                .antMatchers("/my-page/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.POST,"/posts/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/posts/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.PATCH,"/posts/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.POST,"/answers/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/answers/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.PATCH,"/answers/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.POST,"/comments/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.DELETE,"/comments/**").hasAnyRole("USER", "ADMIN")
                                .antMatchers(HttpMethod.PATCH,"/comments/**").hasAnyRole("USER", "ADMIN")
//                                .anyRequest().authenticated()
//                                )
//                                .oauth2Login(withDefaults());
                                .anyRequest().permitAll());
                //.authorizeRequests()
                //.antMatchers("/answer/**")
                //.access("hasRole('관리자') or hasRole('일반 유저')")
                //.anyRequest()
                //.permitAll();
        return http.build();
    }

    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            JwtAuthenticationFilter jwtAuthenticationFilter =new JwtAuthenticationFilter(authenticationManager,jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/member/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer);


            builder
                    .addFilter(corsFilter)
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);
        }
    }
}
