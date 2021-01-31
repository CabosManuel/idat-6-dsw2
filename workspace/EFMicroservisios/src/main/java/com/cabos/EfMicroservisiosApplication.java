package com.cabos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EfMicroservisiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EfMicroservisiosApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor("manuel","a123");
		
        RestTemplate rt = new RestTemplate();
        rt.getInterceptors().add(interceptor);
		return rt;
	}
}
