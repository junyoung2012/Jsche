/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsche.config;

import org.jsche.common.inteceptor.LoginInteceptor;
import org.jsche.common.inteceptor.TokenStageInteceptor;
import org.jsche.common.inteceptor.ValidTokenInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author myan
 */
@Configuration
public class CustomizedConfigureAdapter extends WebMvcConfigurerAdapter {

    @Bean
    public ValidTokenInteceptor validTokenInteceptor() {
        return new ValidTokenInteceptor();
    }

    @Bean
    public TokenStageInteceptor tokenStageInteceptor() {
        return new TokenStageInteceptor();
    }

    @Bean
    public LoginInteceptor loginInteceptor() {
        return new LoginInteceptor();
    }

    @Bean
    public CommonsMultipartResolver MultipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(validTokenInteceptor()).addPathPatterns("/**");
        registry.addInterceptor(tokenStageInteceptor()).addPathPatterns("/**");
        registry.addInterceptor(loginInteceptor()).addPathPatterns("/**");
    }

}
