package br.com.munizes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.munizes.controllers.TokenFilter;

@SpringBootApplication
public class ClientesmvcApplication {

	@Bean
	public FilterRegistrationBean<TokenFilter> filtroJwt() {
		System.out.println("add beann");
		FilterRegistrationBean<TokenFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new TokenFilter());
		filter.addUrlPatterns("/private/*");
		return filter;
	}
				
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesmvcApplication.class, args);
	}

}

