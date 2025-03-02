package com.dmitryprod.producer.logging.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Field;

import static java.util.Optional.ofNullable;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
public class LoggingConfig {

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Logger getLogger(final InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(ofNullable(injectionPoint.getMethodParameter())
                                               .<Class>map(MethodParameter::getContainingClass)
                                               .orElseGet(() -> ofNullable(injectionPoint.getField())
                                                       .map(Field::getDeclaringClass)
                                                       .orElseThrow(IllegalArgumentException::new)
                                               )
        );
    }
}
