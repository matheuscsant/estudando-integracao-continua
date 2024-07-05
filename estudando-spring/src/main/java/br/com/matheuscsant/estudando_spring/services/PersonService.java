package br.com.matheuscsant.estudando_spring.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheuscsant.estudando_spring.models.Person;
import br.com.matheuscsant.estudando_spring.repositories.PersonRepository;
import br.com.matheuscsant.estudando_spring.services.exceptions.ResourceAlreadyExistsException;
import br.com.matheuscsant.estudando_spring.services.exceptions.ResourceNotFoundException;
import br.com.matheuscsant.estudando_spring.utils.NumericUtils;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public List<Person> findAll() {

		logger.info("Finding all people!");

		List<Person> allPersons = repository.findAll();

		logger.info("People found!");

		return allPersons;
	}

	public Long createPerson(Person person) {

		Optional<Person> findPerson = repository.findByEmail(person.getEmail());

		if (findPerson.isPresent())
			throw new ResourceAlreadyExistsException("Person already exist with given e-mail: " + person.getEmail());

		logger.info("Creating person!");

		var newPerson = repository.save(person);

		logger.info("Person created!");

		return newPerson.getId();

	}

	public Person updatePerson(Person person) {

		if (person.getId() == null || !repository.existsById(person.getId()))
			throw new ResourceNotFoundException("Person not found for this id: " + person.getId());

		logger.info("Updating person!");

		Person updatedPerson = null;

		updatedPerson = repository.save(person);

		logger.info("Person updated!");

		return updatedPerson;
	}

	public void deletePerson(Long id) {

		logger.info("Deleting person!");

		if (!repository.existsById(id))
			throw new ResourceNotFoundException("Person not found for this id: " + id);

		repository.deleteById(id);

		logger.info("Person deleted!");

	}

	public Person findById(String id) {
		if (!NumericUtils.isNumeric(id))
			throw new NumberFormatException("Informe um valor númerico");

		logger.info("Finding one person!");

		var person = repository.findById(Long.parseLong(id))
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id: " + id));

		logger.info("Person found!");

		return person;
	}

}
