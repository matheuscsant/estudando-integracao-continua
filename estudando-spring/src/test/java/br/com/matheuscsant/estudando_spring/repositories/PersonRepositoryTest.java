package br.com.matheuscsant.estudando_spring.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.matheuscsant.estudando_spring.models.Person;

@DataJpaTest
class PersonRepositoryTest {

	@Autowired
	private PersonRepository repository;

	private Person person0;
	private Person savedPerson;

	@BeforeEach
	public void setup() {
		// Given / Arrange
		person0 = new Person("Matheus", "Santos", "Rua teste - São Paulo", "Male", "matheus@teste.com");
		savedPerson = repository.save(person0);
	}

	@DisplayName("Given person object when find by email then return person object")
	@Test
	void testGivenPersonObject_whenFindByEmail_thenReturnPersonObject() {

		// When / Act
		Person findPerson = repository.findByEmail(savedPerson.getEmail()).orElse(null);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(savedPerson.getId(), findPerson.getId());
		assertTrue(findPerson.getId() > 0);

	}

	@DisplayName("Given person object when find by id then return person object")
	@Test
	void testGivenPersonObject_whenFindById_thenReturnPersonObject() {

		// When / Act
		Person findPerson = repository.findById(savedPerson.getId()).orElse(null);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(savedPerson.getId(), findPerson.getId());
		assertTrue(findPerson.getId() > 0);

	}

	@DisplayName("Given person object when update person then return updated person object")
	@Test
	void testGivenPersonObject_whenUpdatePerson_thenReturnUpdatedPersonObject() {

		// When / Act
		savedPerson.setFirstName("Leonardo");
		savedPerson.setEmail("leonardo@teste.com");
		Person updatedPerson = repository.save(savedPerson);

		// Then / Assert
		assertNotNull(updatedPerson);
		assertEquals(savedPerson.getId(), updatedPerson.getId());
		assertEquals(updatedPerson.getFirstName(), "Leonardo");
		assertEquals(updatedPerson.getEmail(), "leonardo@teste.com");
		assertTrue(updatedPerson.getId() > 0);

	}

	@DisplayName("Given person object when save then return saved person")
	@Test
	void testGivenPersonObject_whenSave_thenReturnSavedPerson() {
		// Given / Arrange
		Person personWithException = new Person("Matheus", "Santos", "Rua teste - São Paulo", "Maleeeeee",
				"matheus@teste.com");

		// When / Act
		Person savedPerson = repository.save(person0);

		// Then / Assert
		assertNotNull(savedPerson);
		assertTrue(savedPerson.getId() > 0);
		assertThrows(DataIntegrityViolationException.class, () -> repository.save(personWithException),
				() -> "Should have throw an DataIntegrityViolationException");
	}

	@DisplayName("Given person object when save then return saved person")
	@Test
	void testGivenPersonList_whenFindAll_thenReturnPersonList() {
		// Given / Arrange
		Person person1 = new Person("Rafhael", "Santos", "Rua teste - Rio de Janeiro", "Male", "rafhael@teste.com");

		repository.save(person0);
		repository.save(person1);

		// When / Act
		List<Person> personList = repository.findAll();

		// Then / Assert
		assertNotNull(personList);
		assertEquals(personList.size(), 2);
	}

	@DisplayName("Given person object when delete person then remove person")
	@Test
	void testGivenPersonObject_whenDeletePerson_thenRemovePerson() {

		// When / Act
		repository.deleteById(person0.getId());
		Optional<Person> optionalPerson = repository.findById(savedPerson.getId());

		// Then / Assert
		assertTrue(optionalPerson.isEmpty());
	}

	@DisplayName("Given first name and last name when find by JPQL then return person object")
	@Test
	void testGivenFirstNameAndLastName_whenFindByJPQL_thenReturnPersonObject() {
		// Given / Arrange
		String firstName = "Matheus";
		String lastName = "Santos";

		// When / Act
		Person findPerson = repository.findByJPQL(firstName, lastName);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(firstName, findPerson.getFirstName());
		assertEquals(lastName, findPerson.getLastName());

	}

	@DisplayName("Given first name and last name when find by JPQL named parameters then return person object")
	@Test
	void testGivenFirstNameAndLastName_whenFindByJPQLNamedParameters_thenReturnPersonObject() {
		// Given / Arrange
		String firstName = "Matheus";
		String lastName = "Santos";

		// When / Act
		Person findPerson = repository.findByJPQLNamedParameters(firstName, lastName);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(firstName, findPerson.getFirstName());
		assertEquals(lastName, findPerson.getLastName());

	}

	@DisplayName("Given first name and last name when find by native SQL then return person object")
	@Test
	void testGivenFirstNameAndLastName_whenFindByNativeSQL_thenReturnPersonObject() {
		// Given / Arrange
		String firstName = "Matheus";
		String lastName = "Santos";

		// When / Act
		Person findPerson = repository.findByNativeSQL(firstName, lastName);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(firstName, findPerson.getFirstName());
		assertEquals(lastName, findPerson.getLastName());

	}

	@DisplayName("Given first name and last name when find by native SQL with named parameters then return person object")
	@Test
	void testGivenFirstNameAndLastName_whenFindByNativeSQLWithNativeParameters_thenReturnPersonObject() {
		// Given / Arrange
		String firstName = "Matheus";
		String lastName = "Santos";

		// When / Act
		Person findPerson = repository.findByNativeSQLNamedParameters(firstName, lastName);

		// Then / Assert
		assertNotNull(findPerson);
		assertEquals(firstName, findPerson.getFirstName());
		assertEquals(lastName, findPerson.getLastName());

	}

}
