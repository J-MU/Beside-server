package com.hackathon.beside.common.config;

import com.hackathon.beside.auth.JwtRepository;
import com.hackathon.beside.common.jwt.JwtFilter;
import com.hackathon.beside.common.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;
    private final JwtRepository redisRepository;

    @Override
    public void configure(final HttpSecurity builder) {
        final JwtFilter filter = new JwtFilter(tokenProvider, redisRepository);

        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
