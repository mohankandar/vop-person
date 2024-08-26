package com.wynd.vop.person.config;

import com.wynd.vop.framework.security.HttpProperties;
import com.wynd.vop.person.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PersonCorsConfig {
    
    private PersonProperties personProperties;
    private HttpProperties httpProperties;
    
    public PersonCorsConfig(@Autowired PersonProperties personProperties,
        @Autowired HttpProperties httpProperties) {
        this.personProperties = personProperties;
        this.httpProperties = httpProperties;
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (httpProperties.getCors() != null && httpProperties.getCors().isEnabled()) {
                    // UIEnablement
                    // The usage of the word orIgIn in all lower case is problematic in the gen.sh script.
                    // After generation, the scripts will replace with all lower case version or camel case version and uncomment as necessary.
// UIEnablement         registry.addMapping("/api/v1/person/**").allowedOrIgIns(personProperties.getOrIgIns());
                }
            }
        };
    }
}
