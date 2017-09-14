package de.morphbit.thymeleaf.demo.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import de.morphbit.thymeleaf.dialect.ComponentDialect;
import de.morphbit.thymeleaf.model.ThymeleafComponent;

@Configuration
public class ThymeleafConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public SpringTemplateEngine templateEngine(
	        ITemplateResolver templateResolver) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.addDialect(new ComponentDialect(thymeleafComponents()));
		return templateEngine;
	}
	
	@Bean
	public Set<ThymeleafComponent> thymeleafComponents() {
		Set<ThymeleafComponent> components = new HashSet<>();
		components.add(new ThymeleafComponent("link", "components/link :: link"));
		components.add(new ThymeleafComponent("panel", "components/panel :: panel"));
		return components;
	}
}
