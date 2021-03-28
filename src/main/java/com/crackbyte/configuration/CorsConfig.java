package com.crackbyte.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.*;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig extends OncePerRequestFilter {

    @Value("${custom.cors.allowOrigin:*}")
    private String allowOrigin;

    @Value("${custom.cors.allowMethods:GET, POST, PUT, DELETE, OPTIONS}")
    private String allowMethods;

    @Value("${custom.cors.allowHeaders:Content-Type,X-preferedLanguage,RequestTimeZone,X-XSRF-TOKEN,RequestTime}")
    private String allowHeaders;

    @Value("${custom.cors.allowCredentials:true}")
    private String allowCredentials;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, allowOrigin);
        if (HttpMethod.OPTIONS.toString().equalsIgnoreCase(request.getMethod())) {
            response.addHeader(ACCESS_CONTROL_ALLOW_METHODS, allowMethods);
            response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, allowHeaders);
            response.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, allowCredentials);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }


}
