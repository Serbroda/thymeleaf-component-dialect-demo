package de.morphbit.thymeleaf.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.morphbit.thymeleaf.dialect.ComponentDialect;
import de.morphbit.thymeleaf.parser.StandardThymeleafComponentParser;

@Configuration
public class ThymeleafConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ComponentDialect componentDialect() {
		ComponentDialect dialect = new ComponentDialect();
		dialect.addParser(
		    new StandardThymeleafComponentParser("templates/", ".html", "components"));
		return dialect;
	}
}
