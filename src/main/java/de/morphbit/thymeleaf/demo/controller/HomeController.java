package de.morphbit.thymeleaf.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.morphbit.thymeleaf.demo.model.Country;

@Controller
public class HomeController {

	private final Set<Country> countries = new HashSet<>();

	public HomeController() {
		this.countries.add(new Country("AU", "Australia"));
		this.countries.add(new Country("DE", "Germany"));
		this.countries.add(new Country("FR", "France"));
		this.countries.add(new Country("US", "United States"));
	}

	@ModelAttribute("countries")
	public Set<Country> countriesModel() {
		return this.countries;
	}

	@GetMapping("/")
	public String index(Model model) {
		var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("greeting",
				"Welcome to Thymeleaf Components Dialect - " + LocalDateTime.now().format(formatter));
		model.addAttribute("country", new Country());
		return "index";
	}

	@PostMapping("/country/add")
	public String countryAdd(@Valid @ModelAttribute("country") Country country, BindingResult result, Model model) {
		if (country.getName() == null || country.getName().isEmpty()) {
			result.addError(new FieldError("country", "name", "Field name cannot be null"));
			model.addAttribute("country", country);
			return "index";
		}
		this.countries.add(country);
		return "redirect:/";
	}
}
