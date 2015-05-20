package com.darcardona.libraryu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.darcardona.libraryu.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class CategoryControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private final String viewPath = "/WEB-INF/views/categories/";

	private final String requestPath = "/categories";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	// @Test
	public void getHome() throws Exception {
		this.mockMvc.perform(get(requestPath))
				// .andDo(print())
				.andExpect(status().isOk())
				.andExpect(forwardedUrl(viewPath + "list.jsp"));
	}

	// @Test
	public void postSomething() throws Exception {

		this.mockMvc
				.perform(
						post(requestPath + "/add").param("name", "science")
								.param("location", "south"))
				// .andDo(print())
				.andExpect(status().isMovedTemporarily())
				.andExpect(model().hasNoErrors())
				.andExpect(flash().attributeExists("message"))
				.andExpect(redirectedUrl("list"));
	}

	// @Test
	public void postEmptyData() throws Exception {
		this.mockMvc
				.perform(post(requestPath + "/add"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().attributeHasFieldErrors("category", "name"))
				.andExpect(
						model().attributeHasFieldErrors("category", "location"))
				.andExpect(forwardedUrl(viewPath + "add.jsp"));
	}

}
