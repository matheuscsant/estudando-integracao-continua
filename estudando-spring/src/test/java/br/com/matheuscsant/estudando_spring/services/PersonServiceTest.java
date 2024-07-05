package br.com.matheuscsant.estudando_spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.matheuscsant.estudando_spring.models.Person;
import br.com.matheuscsant.estudando_spring.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository repository;

	@InjectMocks
	private PersonService service;

	private Person person0;

	@BeforeEach
	public void setup() {
		// Given / Arrange
		person0 = new Person("Matheus", "Santos", "Rua teste - São Paulo", "Male", "matheus@teste.com");
	}

	@DisplayName("Given person object when save person then return person object")
	@Test
	void testGivenPersonObject_WhenSavePerson_thenReturnPersonObject() {
		// Given / Arrange
		given(repository.findByEmail(anyString())).willReturn(Optional.empty());
		given(repository.save(person0)).willReturn(person0);
		given(repository.findById(anyLong())).willReturn(Optional.of(person0));

		// When / Act
		service.createPerson(person0);
		Person savedPerson = service.findById("1");

		// Then / Assert
		assertNotNull(savedPerson);
		assertEquals("Matheus", savedPerson.getFirstName());
	}

	@DisplayName("Given person list when find all persons then return persons list")
	@Test
	void testGivenPersonList_WhenFindAllPersons_thenReturnPersonsList() {
		// Given / Arrange
		Person person1 = new Person("Rafhael", "Santos", "Rua teste - 123", "Male", "rafhael@teste.com");
		given(repository.findAll()).willReturn(List.of(person0, person1));

		// When / Act
		List<Person> persons = service.findAll();

		// Then / Assert
		assertNotNull(persons);
		assertFalse(persons.isEmpty());
		assertEquals(2, persons.size());
	}

	@DisplayName("Given empty persons list when find all persons then return empty persons list")
	@Test
	void testGivenEmptyPersonList_WhenFindAllPersons_thenReturnEmptyPersonsList() {
		// Given / Arrange
		given(repository.findAll()).willReturn(Collections.emptyList());

		// When / Act
		List<Person> persons = service.findAll();

		// Then / Assert
		assertNotNull(persons);
		assertTrue(persons.isEmpty());
		assertEquals(0, persons.size());
	}

	@DisplayName("Given person id when find by id then return person object")
	@Test
	void testGivenPersonId_WhenFindById_thenReturnPersonObject() {
		// Given / Arrange
		given(repository.findById(anyLong())).willReturn(Optional.of(person0));

		// When / Act
		Person person = service.findById("1");

		// Then / Assert
		assertNotNull(person);
		assertEquals("Matheus", person.getFirstName());
	}

	@DisplayName("Given person object when update person then return updated person")
	@Test
	void testGivenPersonObject_WhenUpdatePerson_thenReturnUpdatedPerson() {
		// Given / Arrange
		person0.setId(1L);
		given(repository.existsById(anyLong())).willReturn(true);

		person0.setEmail("jorge@teste.com");
		person0.setFirstName("Jorge");

		given(repository.save(person0)).willReturn(person0);

		// When / Act
		Person person = service.updatePerson(person0);

		// Then / Assert
		assertNotNull(person);
		assertEquals("Jorge", person.getFirstName());
		assertEquals("jorge@teste.com", person.getEmail());
	}

	@DisplayName("Given person object when delete person then return void")
	@Test
	void testGivenPersonId_WhenDeletePerson_thenReturnVoid() {
		// Given / Arrange
		person0.setId(1L);
		given(repository.existsById(anyLong())).willReturn(true);
		willDoNothing().given(repository).deleteById(person0.getId());

		// When / Act
		service.deletePerson(person0.getId());

		// Then / Assert
		verify(repository, atLeastOnce()).deleteById(person0.getId());
	}

}
