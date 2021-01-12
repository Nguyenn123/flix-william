package com.william;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("frontend/**").addResourceLocations("classpath:/static/frontend/");
        registry.addResourceHandler("admin/backend/**").addResourceLocations("classpath:/static/backend/");
        registry.addResourceHandler("database/videos/**").addResourceLocations("classpath:/static/database/videos/");
        registry.addResourceHandler("database/images/**").addResourceLocations("classpath:/static/database/images/");
        registry.addResourceHandler("database/videosTrailer/**").addResourceLocations("classpath:/static/database/videosTrailer/");
    }
}