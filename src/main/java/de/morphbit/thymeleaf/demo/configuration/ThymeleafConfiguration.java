package de.morphbit.thymeleaf.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.morphbit.thymeleaf.dialect.ComponentDialect;
import de.morphbit.thymeleaf.parser.StandardThymeleafComponentParser;

@Configuration
public class ThymeleafConfiguration {

	@Bean
	public ComponentDialect componentDialect() {
		var dialect = new ComponentDialect();
		dialect.addParser(new StandardThymeleafComponentParser("templates/", ".html", "components"));
		return dialect;
	}
}
