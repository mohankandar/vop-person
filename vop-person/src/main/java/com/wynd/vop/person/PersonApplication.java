package com.wynd.vop.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import brave.sampler.Sampler;

/**
 * An <tt>Person Service Application</tt> enabled for Spring Boot Application,
 * Spring Cloud Netflix Feign Clients, Hystrix circuit breakers, Swagger and
 * AspectJ's @Aspect annotation.
 *
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class PersonApplication {

	/**
	 * Runs the spring-boot application with this class and any command-line arguments.
	 *
	 * @param args the array or command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	/**
	 * Always sampler for Zipkin traces.
	 *
	 * @return the sampler
	 */
	@Bean
	Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
