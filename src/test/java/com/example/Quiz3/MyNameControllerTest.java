package com.example.Quiz3;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class MyNameControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void testGetMyName() throws Exception {
		this.mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("Hello my name is User"));
	}

	@Test
	void testWithParameter() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "Shaz").accept(MediaType.ALL_VALUE))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string("Hello my name is Shaz"));
	}
}
