package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailService;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Donald F. Coffin on 5/30/17.
 */
@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/Git/dfcoffin/.devopsbuddy/application-dev.properties")
public class DevelopmentConfig {

    @Value("${stripe.test.private.key}")
    private String stripeDevKey;

    @Bean
    public EmailService emailService() {
        return new MockEmailService();
    }

    public ServletRegistrationBean h2ConsoleServletRegistration() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
        bean.addUrlMappings("/console/*");
        return bean;
    }

    @Bean
    public String stripeKey() {
        return stripeDevKey;
    }
}
