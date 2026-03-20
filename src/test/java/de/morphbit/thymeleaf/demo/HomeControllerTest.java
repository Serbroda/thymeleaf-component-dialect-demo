package de.morphbit.thymeleaf.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import de.morphbit.thymeleaf.demo.controller.HomeController;
import de.morphbit.thymeleaf.demo.model.Country;

class HomeControllerTest {

	private MockMvc mockMvc;

	@BeforeEach
	void setup() {
		var controller = new HomeController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testIndex() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	@Test
	void testPostWithValidCountry() throws Exception {
		mockMvc.perform(post("/country/add")
				.param("isoCode", "JP")
				.param("name", "Japan")
				.sessionAttr("country", new Country())
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().is3xxRedirection());
	}

	@Test
	void testPostWithEmptyNameReturnsIndex() throws Exception {
		mockMvc.perform(post("/country/add")
				.param("isoCode", "XX")
				.sessionAttr("country", new Country())
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}
}
