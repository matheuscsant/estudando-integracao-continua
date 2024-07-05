package br.com.matheuscsant.estudando_spring.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.matheuscsant.estudando_spring.models.Person;
import br.com.matheuscsant.estudando_spring.services.PersonService;

@WebMvcTest
public class PersonResourceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private PersonService service;

	private Person person0;

	@BeforeEach
	public void setup() {
		// Given / Arrange
		person0 = new Person("Matheus", "Santos", "Rua teste - São Paulo", "Male", "matheus@teste.com");
	}

	@DisplayName("Given person object when create person then return saved person")
	@Test
	void testGivenPersonObject_WhenCreatePerson_thenReturnSavedPerson() throws JsonProcessingException, Exception {
		// Given / Arrange
		given(service.createPerson(any(Person.class))).willAnswer(invocation -> invocation.getArgument(0));

		// When / Act
		ResultActions response = mockMvc
				.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(person0)));

		// Then / Assert
		response.andDo(print()).andExpect(status().isCreated());
	}
}
