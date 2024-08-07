package com.springBoot.ProjectTracker.configuration;

import com.springBoot.ProjectTracker.utility.mapper.UserMapper;
import com.springBoot.ProjectTracker.utility.mapper.UserMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();

    }
}
