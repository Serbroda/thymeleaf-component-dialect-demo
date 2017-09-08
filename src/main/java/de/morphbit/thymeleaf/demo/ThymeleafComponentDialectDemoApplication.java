package de.morphbit.thymeleaf.demo;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class ThymeleafComponentDialectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafComponentDialectDemoApplication.class,
		    args);
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("msg", "Hello world " + new Date());
		model.addAttribute("html", "<span th:text=\"${msg}\"></span>");
		return "index";
	}
}
