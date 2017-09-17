package de.morphbit.thymeleaf.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import de.morphbit.thymeleaf.demo.controller.HomeController;
import de.morphbit.thymeleaf.demo.model.Country;

public class HomeControllerTest {

	private MockMvc mockMvc;
	
	private HomeController controller;
	
	@Before
	public void setup() {
		this.controller = new HomeController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
	@Test
	public void testPost() throws Exception {
		mockMvc.perform(post("/country/add")
				.sessionAttr("country", new Country())
				.contentType(MediaType.APPLICATION_JSON)
			).andExpect(status().is3xxRedirection());
	}
}
