package com.idwall.desafio.idwall.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testResquestSucess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor"))
				.andExpect(MockMvcResultMatchers.status().isOk());

		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor/justified"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testRequestText() throws Exception {
		String text = "Teste OK!";

		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor", text))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().equals(text);

		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor/justified", text))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().equals(text);
	}

	@Test
	public void testRequestLimit() throws Exception {
		String limit = "19";
		String text = "o limit não pode ser menor que 20!";

		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor", limit))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
				.equals("o limit não pode ser menor que 20!");

		mockMvc.perform(MockMvcRequestBuilders.post("/string/refactor/justified", text))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
				.equals("o limit não pode ser menor que 20!");
	}

}
