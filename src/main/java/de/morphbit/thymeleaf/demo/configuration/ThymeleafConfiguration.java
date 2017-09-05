package de.morphbit.thymeleaf.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import de.morphbit.thymeleaf.dialect.ComponentDialect;

@Configuration
@EnableWebMvc
public class ThymeleafConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public SpringTemplateEngine templateEngine(
	        ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new ComponentDialect());
		return templateEngine;
	}
}
