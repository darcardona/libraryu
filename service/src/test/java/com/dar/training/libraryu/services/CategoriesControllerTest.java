package com.dar.training.libraryu.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.dar.training.libraryu.model.catalog.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/test-config-servlet.xml")
public class CategoriesControllerTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void shouldAddJsonStringCategory() {
		String jsonStringCategory = "{" + "\"id\":\"\"" + ","
				+ "\"name\":\"dar\"" + "," + "\"state\":\"INACTIVE\"" + "}";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<String>(jsonStringCategory,
				headers);

		Category returnedCategory = restTemplate.postForObject(
				"http://localhost:8080/LibraryU/catalog/categories/", request,
				Category.class);
		
		 restTemplate.postForObject(
					"http://localhost:8080/LibraryU/catalog/categories/", request,
					Category.class);
		

		assertNotNull(returnedCategory.getId());
		assertEquals("dar", returnedCategory.getName());
		assertEquals("INACTIVE", returnedCategory.getState());
	}
}